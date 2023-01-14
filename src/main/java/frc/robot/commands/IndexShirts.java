package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class IndexShirts extends CommandBase {
  /** Creates a new IndexShirts. */
  Shooter shooter;

  public IndexShirts(Shooter shooter) {

    addRequirements(shooter);
    this.shooter = shooter;
  }

  @Override
  public void initialize() {
    shooter.index();
    System.out.println("is in index shirts");
  }

  @Override
  public void execute() {
    System.out.println("is in index kjhyhfiofuyfuyshirts");
  }

  @Override
  public void end(boolean interrupted) {
    shooter.stopIndexing();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
