// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class DriveTrain extends SubsystemBase {
  // declare our variables
  private VictorSPX frontL;
  private TalonSRX frontR;
  private TalonSRX backL;
  private VictorSPX backR;

  private boolean slowModeOn = true;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontL = new VictorSPX(Constants.ID.DRIVETRAIN_FRONT_LEFT);
    frontR = new TalonSRX(Constants.ID.DRIVETRAIN_FRONT_RIGHT);
    backL = new TalonSRX(Constants.ID.DRIVETRAIN_BACK_LEFT);
    backR = new VictorSPX(Constants.ID.DRIVETRAIN_BACK_RIGHT);

    //Either make the sparks follow each other or code them both
    //CAN IDs will likely be off

    frontL.setNeutralMode(NeutralMode.Brake);
    frontR.setNeutralMode(NeutralMode.Brake);
    backL.setNeutralMode(NeutralMode.Brake);
    backR.setNeutralMode(NeutralMode.Brake);
    
    frontL.setInverted(true);
    backL.setInverted(true);
    frontR.setInverted(false);
    backR.setInverted(false);

    backL.follow(frontL);
    backR.follow(frontR);

    // No neutral mode for sparks
    // frontL.setNeutralMode(NeutralMode.Brake);;
    // frontR.setNeutralMode(NeutralMode.Brake);
    // backL.setNeutralMode(NeutralMode.Brake);
    // backR.setNeutralMode(NeutralMode.Brake);


  }

  @Override
  public void periodic() {

  }

  

  public void tankDrive(double leftSpeed, double rightSpeed) {
    frontL.set(VictorSPXControlMode.PercentOutput, leftSpeed);
    frontR.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void arcadeDrive(double x, double y) {
    SmartDashboard.putNumber("L", y - x);
    SmartDashboard.putNumber("R", y + x);
    frontL.set(VictorSPXControlMode.PercentOutput, y - x);
    backL.set(ControlMode.PercentOutput, y - x);
    frontR.set(ControlMode.PercentOutput, y + x);
    backR.set(VictorSPXControlMode.PercentOutput, y + x);
  }

  public void stop() {
    frontL.set(VictorSPXControlMode.PercentOutput, 0.0);
    frontR.set(ControlMode.PercentOutput, 0.0);
  }

  public void toggleSlowMode() {
    slowModeOn = !slowModeOn;
  }

  public boolean getSlowMode() {
    return slowModeOn;
  }
}