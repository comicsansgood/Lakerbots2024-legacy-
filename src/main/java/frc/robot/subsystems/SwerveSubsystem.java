package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.io.File;
import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveControllerConfiguration;
import swervelib.parser.SwerveDriveConfiguration;
import swervelib.parser.SwerveParser;
import swervelib.SwerveController;
import swervelib.SwerveDrive;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.util.Units;


public class SwerveSubsystem extends SubsystemBase {
  private  SwerveDrive swerveDrive;
  
  double maximumSpeed = Units.feetToMeters(14.5);
  //File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(),"swerve");

  public SwerveSubsystem(File dir){
    
    try{
       swerveDrive = new SwerveParser(dir).createSwerveDrive(maximumSpeed);
    }catch(Exception e){
      throw new RuntimeException(e);

    }
  }

  public SwerveSubsystem(SwerveDriveConfiguration driveCfg, SwerveControllerConfiguration controllerCfg)
  {
    swerveDrive = new SwerveDrive(driveCfg, controllerCfg, maximumSpeed);
  }
  
  public void drive(Translation2d translation, double rotation, boolean fieldRelative)
  {
    swerveDrive.drive(translation, rotation, fieldRelative, false);
  }

  
  public void driveFieldOriented(ChassisSpeeds velocity)
  {
    swerveDrive.driveFieldOriented(velocity);
  }

  public void setChassisSpeeds(ChassisSpeeds chassisSpeeds)
  {
    swerveDrive.setChassisSpeeds(chassisSpeeds);
  }

  public void zeroGyro()
  {
    swerveDrive.zeroGyro();
  }
  
  public void setMotorBrake(boolean brake)
  {
    swerveDrive.setMotorIdleMode(brake);
  }

  public Rotation2d getHeading()
  {
    return swerveDrive.getYaw();
  }

  public ChassisSpeeds getTargetSpeeds(double xInput, double yInput, double headingX)
  {
    xInput = Math.pow(xInput, 3);
    yInput = Math.pow(yInput, 3);
    return swerveDrive.swerveController.getTargetSpeeds(xInput, yInput, headingX, getHeading().getRadians(), maximumSpeed);  
  }

  public SwerveController getSwerveController()
  {
    return swerveDrive.swerveController;
  }

  public ChassisSpeeds getFieldVelocity(){
    return swerveDrive.getFieldVelocity();
  }
  
  public ChassisSpeeds getRobotVelocity(){
    return swerveDrive.getFieldVelocity();
  }

  public Pose2d getPose(){
    return swerveDrive.getPose();
  }

  public SwerveDriveConfiguration getSwerveDriveConfiguration(){
    return swerveDrive.swerveDriveConfiguration;
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
