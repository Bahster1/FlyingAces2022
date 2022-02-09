package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

public class TestMotorSubsystem extends Subsystem
{
    private static TestMotorSubsystem _instance;
    WPI_TalonFX motor;
    double newSpeed;
    double error;
    double perOut;
    int startTicks;
    private TestMotorSubsystem()
    {
        motor = new WPI_TalonFX(5);
        motor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    }

    public void run(double speed) {
        motor.set(ControlMode.PercentOutput, speed);
        //System.out.println("EncoderValue: " + motor.getSelectedSensorPosition()/2048.0);
    }

    public void runVelo(double speed){
        newSpeed = motor.getSelectedSensorVelocity();

        while(startTicks < 200)
        {
            newSpeed = speed- 2;
            System.out.println(startTicks);
            startTicks++;
        }

        error = speed/newSpeed;
        if(error > 1)
        {
            perOut = (newSpeed * error) / 20220;
        }

        motor.set(ControlMode.PercentOutput, perOut);
        System.out.println("Velo:" + motor.getSelectedSensorVelocity());
        System.out.println("Err:" + error);
        System.out.println("Per:" + perOut);
    }


    public static TestMotorSubsystem getInstance()
    {
        if (_instance == null)
        {
            _instance = new TestMotorSubsystem();
        }

        return _instance;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
