package frc.robot.commands.IntakeCommands.IntakeSpinCommands;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeStop extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final IntakeSubsystem m_intakeSpin;

  public IntakeStop(IntakeSubsystem intake) {
    
    m_intakeSpin = intake;
    
    addRequirements(m_intakeSpin);
  }

  @Override
  public void initialize() {
    m_intakeSpin.intakeStop();
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
