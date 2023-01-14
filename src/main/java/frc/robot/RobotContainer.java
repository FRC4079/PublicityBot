// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.utils.LogitechGamingPad;
import frc.robot.commands.*;

public class RobotContainer {
  LogitechGamingPad drivePad = new LogitechGamingPad(0);

  DriveTrain driveTrain = new DriveTrain();
  Shooter shooter = new Shooter();
  NoiseMakers noiseMakers = new NoiseMakers();

  private JoystickButton driveA = new JoystickButton(drivePad, 1);
  private JoystickButton driveB = new JoystickButton(drivePad, 2);
  private JoystickButton driveX = new JoystickButton(drivePad, 3);
  private JoystickButton driveY = new JoystickButton(drivePad, 4);
  private JoystickButton driveRightBumper = new JoystickButton(drivePad, 5);
  private JoystickButton driveLeftBumper = new JoystickButton(drivePad, 6);
  private JoystickButton driveStart = new JoystickButton(drivePad, 8);

  public RobotContainer() {
    
    driveTrain.setDefaultCommand(new ArcadeDrive(driveTrain, drivePad));
    //driveTrain.setDefaultCommand(new ArcadeDrive(1, drivePad))
    configureButtonBindings();
  }


  private void configureButtonBindings() {
    driveA.whileTrue(new MakeSomeNoise(noiseMakers));
    driveB.onTrue(new InstantCommand(() -> driveTrain.toggleSlowMode()));


    driveX.whileTrue(new IndexShirts(shooter));
    driveY.whileTrue(new Shoot(shooter));
    driveLeftBumper.whileTrue(new Actuate(shooter, false, drivePad));
    driveRightBumper.whileTrue(new Actuate(shooter, true, drivePad));

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
