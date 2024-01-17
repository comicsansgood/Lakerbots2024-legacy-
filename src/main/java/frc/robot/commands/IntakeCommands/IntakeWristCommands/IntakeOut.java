package frc.robot.commands.IntakeCommands.IntakeWristCommands;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeOut extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final IntakeSubsystem m_intakeWrist;
  public double position;

  public IntakeOut(IntakeSubsystem intake) {
    
    m_intakeWrist = intake;
    
    addRequirements(m_intakeWrist);
  }

  @Override
  public void initialize() {
    m_intakeWrist.intakeOut();
  }

  @Override
  public void execute() {
    position = m_intakeWrist.intakeWristGetPosition();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return m_intakeWrist.intakeWristAtTargetPosition();
  }
}
