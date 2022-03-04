package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.config.RobotMap;

public class DrivetrainSubsystem extends Subsystem
{
    private static DrivetrainSubsystem _instance;
    private WPI_TalonFX _leftMaster, _rightMaster;
    private DifferentialDrive _differentialDrive;

    private DrivetrainSubsystem()
    {
        // motor controllers with CPR 2048 encoders
        _leftMaster = new WPI_TalonFX(RobotMap.LEFT_MASTER_ID);
        _rightMaster = new WPI_TalonFX(RobotMap.RIGHT_MASTER_ID);
        WPI_TalonFX rightSlave = new WPI_TalonFX(RobotMap.RIGHT_SLAVE_ID);
        WPI_TalonFX leftSlave = new WPI_TalonFX(RobotMap.LEFT_SLAVE_ID);

        // speed control groups (left and right side wheels)
        SpeedControllerGroup leftGroup = new SpeedControllerGroup(_leftMaster, leftSlave);
        SpeedControllerGroup rightGroup = new SpeedControllerGroup(_rightMaster, rightSlave);

        // combined speed control groups
        _differentialDrive = new DifferentialDrive(leftGroup, rightGroup);
        _differentialDrive.setSafetyEnabled(false);

    }

    public void arcadeDrive(double accel, double turn)
    {
        _differentialDrive.arcadeDrive(accel, turn);
    }

    public static DrivetrainSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new DrivetrainSubsystem();

        return _instance;
    }

    // TODO: report motor controller encoder positions - [DONE]
    public void zeroDrivetrain()
    {
        _leftMaster.setSelectedSensorPosition(0.0);
        _rightMaster.setSelectedSensorPosition(0.0);
    }

    public double getLeftCurrentPosition()
    {
        return _leftMaster.getSelectedSensorPosition(0);
    }

    public double getRightCurrentPosition()
    {
        return _rightMaster.getSelectedSensorPosition(0);
    }

    public double getLeftCurrentVelocity()
    {
        return _leftMaster.getSelectedSensorVelocity(0);
    }

    public double getRightCurrentVelocity()
    {
        return _rightMaster.getSelectedSensorVelocity(0);
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
