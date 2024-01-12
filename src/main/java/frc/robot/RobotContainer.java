package frc.robot;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LauncherCommands.*;
import frc.robot.commands.LauncherCommands.LauncherGo;
import frc.robot.subsystems.LauncherSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  //private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public RobotContainer() {

    m_launcherSubsystem.setDefaultCommand(new LauncherSet(m_launcherSubsystem,m_driverController.getLeftTriggerAxis(), m_driverController.getRightTriggerAxis()));

    SmartDashboard.putData("launcher go", new LauncherGo(m_launcherSubsystem));
    SmartDashboard.putData("launcher stop", new LauncherStop(m_launcherSubsystem));
    //SmartDashboard.putData("position", new m_launcherSubsystem.launcherLeftMotor.getEncoder().getPosition());



    configureBindings();

  }


  private void configureBindings() {
  
    m_driverController.a().whileTrue(new LauncherGo(m_launcherSubsystem));
    m_driverController.b().whileTrue(new LauncherStop(m_launcherSubsystem));
    
  }


  /*public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
  */
}
