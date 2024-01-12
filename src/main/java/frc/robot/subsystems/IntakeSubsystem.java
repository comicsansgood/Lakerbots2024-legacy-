package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    
    public CANSparkFlex intakeSpinMotor;
    public CANSparkFlex intakeWristMotor;
    public SparkPIDController intakeWristPidController;
    public double closedPosition = 0;
    public double openPosition = 1;
    public double tolerance = 0.1;
    public final double WristInSetpoint = 0; //TODO tune this
    public final double WristOutSetpoint = 1;//TODO tune this
    public double setpoint;
    
    public IntakeSubsystem(){
        intakeSpinMotor = new CANSparkFlex(4, MotorType.kBrushless);
        intakeWristMotor = new CANSparkFlex(5, MotorType.kBrushless);
        intakeWristPidController = intakeWristMotor.getPIDController();
        intakeWristPidController.setP(0.1);

    }

    public void intakeSpin(double x){
        intakeSpinMotor.set(x);
    }
    
    public void intakeStop(){
        intakeSpinMotor.set(0);
    }

    public void intakeOut(){
        setpoint = 0;
        intakeWristPidController.setReference(0, CANSparkFlex.ControlType.kSmartMotion);
    }
    
    public void intakeIn(){
        setpoint = 1;
        intakeWristPidController.setReference(1, CANSparkFlex.ControlType.kSmartMotion);
    }
   
    public double intakeWristGetPosition(){
        return intakeWristMotor.getEncoder().getPosition();
    }

    public boolean intakeWristAtTargetPosition(){
        return(Math.abs(setpoint - intakeWristMotor.getEncoder().getPosition()) < tolerance);
    }


    @Override
    public void periodic() {
    }
}
