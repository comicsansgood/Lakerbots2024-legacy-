package frc.robot.commands.IntakeCommands.IntakeSpinCommands;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeSpin extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final IntakeSubsystem m_intakeSpin;
  public double value;

  public IntakeSpin(IntakeSubsystem intake, double value) {
    
    m_intakeSpin = intake;
    this.value = value;
    
    addRequirements(m_intakeSpin);
  }

  @Override
  public void initialize() {
    m_intakeSpin.intakeSpin(value);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
