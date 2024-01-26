package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase{

    public CANSparkFlex elevatorMotor; 
    public SparkPIDController elevatorPidController;

    public final double upPos = 1000;
    public final double downPos = 0;

    public final double tolerance = 0.1;

    public ElevatorSubsystem(){
        elevatorMotor = new CANSparkFlex(99, MotorType.kBrushless); //TODO : add this can number
        elevatorPidController = elevatorMotor.getPIDController();
        
        elevatorPidController.setP(0.1);
    }

    public void elevatorUp(){
        elevatorPidController.setReference(upPos, ControlType.kSmartMotion);
    }

    public void elevatorDown(){
        elevatorPidController.setReference(downPos, ControlType.kSmartMotion);
    }

    public double elevatorGetPosition(){
        return elevatorMotor.getEncoder().getPosition();
    }

    public boolean elevatorIsAtTarget(){
        return(Math.abs(elevatorGetPosition()) < tolerance);
    }
   
    
    @Override
    public void periodic(){

    }

}
