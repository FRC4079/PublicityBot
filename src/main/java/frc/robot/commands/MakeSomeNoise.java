// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NoiseMakers;

// while held
public class MakeSomeNoise extends CommandBase {
  /** Creates a new MakeSomeNoise. */
  NoiseMakers noiseMakers;
  public MakeSomeNoise(NoiseMakers noiseMakers) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(noiseMakers);
    this.noiseMakers = noiseMakers;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    noiseMakers.makeNoise();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    noiseMakers.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
