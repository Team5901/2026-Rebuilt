package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.states.IndexerState;
import frc.robot.states.ShooterState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase{
    private TalonFX indexer;
    private TalonFX neck;
    private IndexerState _currentState = IndexerState.IDLE;
    private VoltageOut ON = new VoltageOut(8);
    private VoltageOut OFF = new VoltageOut(0);


    //prepares thing
    public Indexer(){
        indexer = new TalonFX(30, "Default Name");
        neck = new TalonFX(36, "Default Name");
    }

    //does thing
    @Override
    public void periodic() {
        handleCurrentState();
    }

        public void setWantedState(IndexerState wantedState) {
        if(wantedState != _currentState){
            _currentState = wantedState;
        }
    }

    private void handleCurrentState(){
        switch (_currentState) {
            case IDLE:
                indexer.setControl(OFF);
                neck.setControl(OFF);
                break;
            case ON:
            indexer.setControl(ON);
            neck.setControl(ON);
            break;

        }
    }
}