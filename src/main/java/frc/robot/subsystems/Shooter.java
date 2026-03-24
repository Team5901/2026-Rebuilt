package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import frc.robot.states.ShooterState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private TalonFX shooter1;
    private TalonFX shooter2;
    private ShooterState _currentState = ShooterState.IDLE;

    ///
    /// 
    /// 
    /// 
    /// 
    /// 
    private VoltageOut ON = new VoltageOut(6.50);
    //
    ///
    /// 
    /// 
    /// 
    /// 
    /// 
    private VoltageOut OFF = new VoltageOut(0);


    //prepares thing
    public Shooter(){
        shooter1 = new TalonFX(33, "Default Name");
        shooter2 = new TalonFX(32, "Default Name");

        shooter2.setControl(new Follower(shooter1.getDeviceID(), MotorAlignmentValue.Opposed));

        shooter1.setNeutralMode(NeutralModeValue.Coast);
                shooter2.setNeutralMode(NeutralModeValue.Coast);

    }

    //does thing
    @Override
    public void periodic() {
        handleCurrentState();
    }

    public void setWantedState(ShooterState wantedState) {
        if(wantedState != _currentState){
            _currentState = wantedState;
        }
    }

    private void handleCurrentState(){
        switch (_currentState) {
            case IDLE:
                shooter1.setControl(OFF);
                break;
            case ON:
            shooter1.setControl(ON);
                break;

        }
    }
}
