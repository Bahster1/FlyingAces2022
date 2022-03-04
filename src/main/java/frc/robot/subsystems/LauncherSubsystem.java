package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

public class LauncherSubsystem extends Subsystem
{
    private static LauncherSubsystem _instance;
    private final WPI_TalonSRX _leftMotor;
    private final WPI_TalonSRX _rightMotor;
    private final WPI_TalonSRX _launchGate;

    private LauncherSubsystem()
    {
        _leftMotor = new WPI_TalonSRX(RobotMap.LEFT_LAUNCHER_ID);
        _rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_LAUNCHER_ID);
        _launchGate = new WPI_TalonSRX(RobotMap.LAUNCH_GATE_ID);
    }

    public void bothMotorsOn()
    {
        _leftMotor.set(ControlMode.PercentOutput, 1);
        _rightMotor.set(ControlMode.PercentOutput, 1);
    }

    public void bothMotorsOff()
    {
        _leftMotor.set(ControlMode.PercentOutput, 0);
        _rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public void openGate()
    {
        _launchGate.set(ControlMode.PercentOutput, 1);
    }

    public void closeGate()
    {
        _launchGate.set(ControlMode.PercentOutput, 0);
    }

    public double getLauncherPosition()
    {
        return _leftMotor.getSelectedSensorPosition(0);
    }

    public void zeroLauncher()
    {
        _leftMotor.setSelectedSensorPosition(0.0);
        _rightMotor.setSelectedSensorPosition(0.0);
    }

    public static LauncherSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new LauncherSubsystem();

        return _instance;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
