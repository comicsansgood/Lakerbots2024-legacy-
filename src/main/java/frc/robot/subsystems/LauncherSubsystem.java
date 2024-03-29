package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase{
    
    public CANSparkFlex launcherLeftMotor;
    public CANSparkFlex launcherRightMotor;

    public LauncherSubsystem(){ //yeah this probably does something important
        launcherLeftMotor = new CANSparkFlex(2, MotorType.kBrushless);
        launcherRightMotor = new CANSparkFlex(3, MotorType.kBrushless);
        launcherLeftMotor.setInverted(false);
        launcherRightMotor.setInverted(true);
    }
    public void launcherGo(){
        launcherLeftMotor.set(.8);
        launcherRightMotor.set(.5);
    }


    public void launcherStop() {
        launcherLeftMotor.set(0);
        launcherRightMotor.set(0);
    }

    public void launcherSet(double val1, double val2){
        launcherLeftMotor.set(val1);
        launcherRightMotor.set(val2);
    }

    @Override
    public void periodic() {
    }
}
