package frc.robot.commands.DrivetrainCommands;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveController;
import swervelib.math.SwerveMath;

import java.util.List;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;

public class Drive extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final SwerveSubsystem m_drivetrain;
  
  public ChassisSpeeds desiredSpeeds;
  public double vx, vy, vThetaX;
  public Translation2d translation;


  public Drive(SwerveSubsystem m_drivetrain, double x, double y, double thetaX) {
    
    this.m_drivetrain = m_drivetrain;
    vx = x;
    vy = y;
    vThetaX = thetaX;
    
    addRequirements(m_drivetrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    
    desiredSpeeds = m_drivetrain.getTargetSpeeds(vx, vy, vThetaX);
       // desiredSpeeds = m_drivetrain.getTargetSpeeds(0.5, 0.5, 0.5, 0.5);

    //System.out.println(desiredSpeeds);
    translation = SwerveController.getTranslation2d(desiredSpeeds);
    translation = SwerveMath.limitVelocity(translation, m_drivetrain.getFieldVelocity(), m_drivetrain.getPose(), Constants.LOOP_TIME, Constants.ROBOT_MASS, List.of(Constants.CHASSIS), m_drivetrain.getSwerveDriveConfiguration());
    System.out.println(translation);

    m_drivetrain.drive(translation, desiredSpeeds.omegaRadiansPerSecond, true);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
