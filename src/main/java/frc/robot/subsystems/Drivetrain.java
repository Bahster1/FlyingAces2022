package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.config.RobotMap;

public class Drivetrain extends Subsystem
{
    private static Drivetrain _instance;
    private WPI_TalonSRX _leftMaster;
    private WPI_TalonSRX _rightMaster;
    private WPI_TalonSRX _launcher;
    private DifferentialDrive _drive;
    private final double MULTIPLIER = .55;

    private TalonSRXConfiguration _config;

    private Drivetrain()
    {
        //placeholder numbers
        WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_ID);
        WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.LEFT_SLAVE_ID);

        _leftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER_ID);
        _config = new TalonSRXConfiguration();
        //_config.nominalOutputForward = .5;        _leftMaster.configAllSettings(_config);
        _rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_ID);

        SpeedControllerGroup leftGroup = new SpeedControllerGroup(_leftMaster, leftSlave);
        SpeedControllerGroup rightGroup = new SpeedControllerGroup(_rightMaster, rightSlave);
        _drive = new DifferentialDrive(leftGroup, rightGroup);
        _drive.setSafetyEnabled(false);

    }

    public void arcadeDrive(double accel, double turn)
    {
        _drive.arcadeDrive(accel*MULTIPLIER, turn*MULTIPLIER);
    }

    public static Drivetrain getInstance()
    {
        if (_instance == null)
        {
            _instance = new Drivetrain();
        }

        return _instance;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
