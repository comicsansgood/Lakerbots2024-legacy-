package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    
    public CANSparkFlex intakeMotor;
    public SparkPIDController pidController;
    public double closedPosition = 0;
    public double openPosition = 1;
    public double tolerance = 0.1;
    public double setpoint;
    
    public IntakeSubsystem(){
        intakeMotor = new CANSparkFlex(0, MotorType.kBrushless);
        pidController = intakeMotor.getPIDController();
        pidController.setP(0.1);

    }

    public void intakeClose(){
        setpoint = 0;
        pidController.setReference(0, CANSparkFlex.ControlType.kSmartMotion);
    }
    
    public void intakeOpen(){
        setpoint = 1;
        pidController.setReference(1, CANSparkFlex.ControlType.kSmartMotion);
    }

   
    public double intakeGetPosition(){
        return intakeMotor.getEncoder().getPosition();
    }

    public boolean intakeAtTargetPosition(){
        return(Math.abs(setpoint - intakeMotor.getEncoder().getPosition()) < tolerance);
    }


    @Override
    public void periodic() {
    }
}
