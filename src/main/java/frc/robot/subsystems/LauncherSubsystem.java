package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

import java.util.concurrent.TimeUnit;

public class LauncherSubsystem extends Subsystem
{
    private static LauncherSubsystem _instance;
    WPI_TalonSRX leftMotor;
    WPI_TalonSRX rightMotor;
    WPI_TalonSRX launchGate;
    private LauncherSubsystem()
    {
        leftMotor = new WPI_TalonSRX(RobotMap.LEFT_LAUNCHER_ID);
        rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_LAUNCHER_ID);
        launchGate = new WPI_TalonSRX(RobotMap.LAUNCH_GATE_ID);
    }

    //Sets speed of both motors to a float -1 to +1
    public void bothMotorsOn() {
        leftMotor.set(ControlMode.PercentOutput, 1);
        rightMotor.set(ControlMode.PercentOutput, 1);
    }

    //Sets both motors to speed of 0 (No motion)
    public void bothMotorsOff()
    {
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public void openGate()
    {
        launchGate.set(ControlMode.PercentOutput, 1);
    }

    public void closeGate()
    {
        launchGate.set(ControlMode.PercentOutput, 0);
    }

    public static LauncherSubsystem getInstance()
    {
        if (_instance == null)
        {
            _instance = new LauncherSubsystem();
        }

        return _instance;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
