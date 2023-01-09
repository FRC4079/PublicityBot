// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class DriveTrain extends SubsystemBase {
  // declare our variables
  private Spark frontL;
  private Spark frontR;
  private Spark backL;
  private Spark backR;

  private boolean slowModeOn = true;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    frontL = new Spark(Constants.ID.DRIVETRAIN_FRONT_LEFT);
    frontR = new Spark(Constants.ID.DRIVETRAIN_FRONT_RIGHT);
    backL = new Spark(Constants.ID.DRIVETRAIN_BACK_LEFT);
    backR = new Spark(Constants.ID.DRIVETRAIN_BACK_RIGHT);

    //Either make the sparks follow each other or code them both
    //CAN IDs will likely be off

    frontL.setInverted(true);
    backL.setInverted(true);
    frontR.setInverted(false);
    backR.setInverted(false);

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
    frontL.set(leftSpeed);
    frontR.set(rightSpeed);
  }

  public void arcadeDrive(double x, double y) {
    frontL.set(y - x);
    frontR.set(y + x);
  }

  public void driveOne(){
    frontL.set(0.4);
  }

  public void stop() {
    frontL.set(0.0);
    frontR.set(0.0);
  }

  public void toggleSlowMode() {
    slowModeOn = !slowModeOn;
  }

  public boolean getSlowMode() {
    return slowModeOn;
  }
}