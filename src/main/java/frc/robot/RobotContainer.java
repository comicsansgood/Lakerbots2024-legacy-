<<<<<<< HEAD
//TODO: tune swerve drive JSON config files

=======

//test change
>>>>>>> b84fe762307b80a7a33a0e469341862dfbffce17
package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.FeederCommands.FeederGo;
import frc.robot.commands.FeederCommands.FeederStop;
import frc.robot.commands.LauncherCommands.*;
import frc.robot.commands.LauncherCommands.LauncherGo;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.commands.DrivetrainCommands.Drive;
import java.io.File;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  //private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
  private final LauncherSubsystem m_launcherSubsystem = new LauncherSubsystem();
  private final FeederSubsystem m_feederSubsystem = new FeederSubsystem();
  private final SwerveSubsystem m_drivetrainSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),"swerve"));

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public RobotContainer() {

    m_drivetrainSubsystem.setDefaultCommand(new Drive(m_drivetrainSubsystem,
    m_driverController.getLeftY(),
    m_driverController.getLeftX(),
    m_driverController.getRightX(),
    m_driverController.getRightY()
    ));

    //m_launcherSubsystem.setDefaultCommand(new LauncherSet(m_launcherSubsystem,m_driverController.getLeftTriggerAxis(), m_driverController.getRightTriggerAxis()));

    SmartDashboard.putData("launcher go", new LauncherGo(m_launcherSubsystem));
    SmartDashboard.putData("launcher stop", new LauncherStop(m_launcherSubsystem));
    //SmartDashboard.putData("position", new m_launcherSubsystem.launcherLeftMotor.getEncoder().getPosition());



    configureBindings();

  }

  private void configureBindings() {
  
    m_driverController.a().whileTrue(new LauncherGo(m_launcherSubsystem));
    m_driverController.b().whileTrue(new LauncherStop(m_launcherSubsystem));

    m_driverController.x().whileTrue(new FeederGo(m_feederSubsystem));
    m_driverController.y().whileTrue(new FeederStop(m_feederSubsystem));
    
  }


  /*public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
  */
}
