package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TurnToCommand extends Command
{
	private DrivetrainSubsystem _drivetrain;
	private double _degree;

	public TurnToCommand(double degree)
	{
		_drivetrain = DrivetrainSubsystem.getInstance();
		_degree = degree;

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
		_drivetrain.arcadeDrive(0, _degree / Math.abs(_degree));
	}

	@Override
	protected boolean isFinished()
	{
		return false;
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
