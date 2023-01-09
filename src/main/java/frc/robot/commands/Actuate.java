
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;
import frc.robot.utils.LogitechGamingPad;

public class Actuate extends CommandBase {
  /** Creates a new ActuateUp. */
  Shooter shooter;
  boolean up;
  LogitechGamingPad drivePad;

  public Actuate(Shooter shooter, boolean up, LogitechGamingPad drivePad) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);

    this.shooter = shooter;
    this.up = up;
    this.drivePad = drivePad;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.articulate(up);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if (drivePad.checkDPad(0)) {
    // System.out.println("a");
    // shooter.articulate(false);
    // }
    // else if (drivePad.checkDPad(4)) {
    // shooter.articulate(true);
    // }
    // else {
    // shooter.stopArticulating();
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stopArticulating();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
