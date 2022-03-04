package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.RobotMap;
import frc.robot.utils.Conversions;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveToCommand extends Command
{
	private DrivetrainSubsystem _drivetrain;
	private double _distance;

	public DriveToCommand(double distance)
	{
		_distance = Conversions.convertPositionToEncoderPulses(distance, RobotMap.DRIVETRAIN_WHEEL_DIAMETER);
		_drivetrain = DrivetrainSubsystem.getInstance();

		requires(_drivetrain);
	}

	@Override
	protected void initialize()
	{
		_drivetrain.zeroDrivetrain();
	}

	@Override
	protected void execute()
	{
		// normalizes acceleration value to 1.0 or -1.0 depending on the distance.
		_drivetrain.arcadeDrive(_distance / Math.abs(_distance), 0);
	}

	@Override
	protected boolean isFinished()
	{
		// TODO: robot finishes when it covers a certain distance. [DONE]
		return _drivetrain.getLeftCurrentPosition() >= _distance;
	}

	@Override
	protected void interrupted()
	{
		end();
	}

	@Override
	protected void end()
	{
		_drivetrain.arcadeDrive(0,0);
	}
}
