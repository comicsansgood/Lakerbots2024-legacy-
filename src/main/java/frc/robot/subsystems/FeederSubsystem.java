package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.sysid.SysIdRoutineLog.MotorLog;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase{

    public CANSparkFlex feederMotor; //probably

    public FeederSubsystem(){

        feederMotor = new CANSparkFlex(6, MotorType.kBrushless);
        feederMotor.setIdleMode(IdleMode.kCoast);

    }

    public void feederStop(){
        feederMotor.set(0);
    }

    public void feederGo(){
        feederMotor.set(.1);
    }
    @Override
    public void periodic(){

    }

}
