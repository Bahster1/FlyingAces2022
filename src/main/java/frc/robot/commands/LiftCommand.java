package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LiftSubsystem;

// TODO: Turn lift off when at a certain height; toggle between up and down
public class LiftCommand extends Command
{
	private LiftSubsystem _lift;
	private boolean _finished = false;

	public LiftCommand()
	{
		_lift = LiftSubsystem.getInstance();
	}

	@Override
	public void execute()
	{
		_finished = true;
	}

	@Override
	protected boolean isFinished()
	{
		return _finished;
	}
}
