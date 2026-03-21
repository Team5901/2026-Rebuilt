package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;


import frc.robot.states.IndexerState;
import frc.robot.states.IntakeState;
import frc.robot.states.ShooterState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Intake extends SubsystemBase{
    private SparkFlex intake;
    private IntakeState _currentState = IntakeState.IDLE;
    private VoltageOut ON = new VoltageOut(5);
    private VoltageOut OFF = new VoltageOut(0);
    


    //prepares thing
    public Intake(){
        intake = new SparkFlex(11, MotorType.kBrushless);
    }

    //does thing
    @Override
    public void periodic() {
        handleCurrentState();
    }

    public void setWantedState(IntakeState wantedState) {
        if(wantedState != _currentState){
            _currentState = wantedState;
        }
    }

    private void handleCurrentState(){
        switch (_currentState) {
            case IDLE:
               intake.set(0);
                break;
            case ON:
            intake.set(-0.30);
            break;
        }
    }
}