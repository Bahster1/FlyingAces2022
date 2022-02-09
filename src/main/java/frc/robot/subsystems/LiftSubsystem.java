package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.RobotMap;

public class LiftSubsystem extends Subsystem
{
    private static LiftSubsystem _instance;
    WPI_TalonSRX leftMotor;
    WPI_TalonSRX rightMotor;
    private LiftSubsystem()
    {
        leftMotor = new WPI_TalonSRX(RobotMap.LEFT_LIFT_ID);
        rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_LIFT_ID);
    }

    //Sets speed of both motors to a float -1 to +1
    public void bothMotorsAtPerOut(float speed)
    {
        leftMotor.set(ControlMode.PercentOutput, speed);
        rightMotor.set(ControlMode.PercentOutput, speed);
    }

    //Sets both motors to speed of 0 (No motion)
    public void bothMotorsOff()
    {
        leftMotor.set(ControlMode.PercentOutput, 0);
        rightMotor.set(ControlMode.PercentOutput, 0);
    }

    //Sets speed of left motor to a float -1 to +1
    public void leftMotorAtPerOut(float speed)
    {
        leftMotor.set(ControlMode.PercentOutput, speed);
    }

    //Sets left motor to speed of 0 (No motion)
    public void leftMotorOff(float speed)
    {
        leftMotor.set(ControlMode.PercentOutput, 0);
    }

    //Sets speed of right motor to a float -1 to +1
    public void rightMotorAtPerOut(float speed)
    {
        rightMotor.set(ControlMode.PercentOutput, speed);
    }

    //Sets right motors to speed of 0 (No motion)
    public void rightMotorOff(float speed)
    {
        rightMotor.set(ControlMode.PercentOutput, 0);
    }


    public static LiftSubsystem getInstance()
    {
        if (_instance == null)
        {
            _instance = new LiftSubsystem();
        }

        return _instance;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
