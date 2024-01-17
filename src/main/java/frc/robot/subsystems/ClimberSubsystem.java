package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.sysid.SysIdRoutineLog.MotorLog;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase{

    public CANSparkFlex climberLeftMotor;
    public CANSparkFlex climberRightMotor;

    public ClimberSubsystem(){

        climberLeftMotor = new CANSparkFlex(7, MotorType.kBrushless);
        climberLeftMotor = new CANSparkFlex(8, MotorType.kBrushless);

    }

    public void climberSet(double leftSpeed, double rightSpeed){
        climberLeftMotor.set(leftSpeed);
        climberRightMotor.set(rightSpeed);
    }
    
    @Override
    public void periodic(){

    }

}
