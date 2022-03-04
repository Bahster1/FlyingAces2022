package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

public class LiftSubsystem extends Subsystem
{
    private static LiftSubsystem _instance;

    private final WPI_TalonSRX _leftMotor;
    private final WPI_TalonSRX _rightMotor;

    private LiftSubsystem()
    {
        _leftMotor = new WPI_TalonSRX(RobotMap.LEFT_LIFT_ID);
        _rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_LIFT_ID);
    }

    public void liftOn(int speed)
    {
        _leftMotor.set(ControlMode.PercentOutput, speed);
        _rightMotor.set(ControlMode.PercentOutput, speed);
    }

    public void liftOff()
    {
        _leftMotor.set(ControlMode.PercentOutput, 0);
        _rightMotor.set(ControlMode.PercentOutput, 0);
    }

    public double getPosition()
    {
        return _leftMotor.getSelectedSensorPosition();
    }

    public static LiftSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new LiftSubsystem();

        return _instance;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
