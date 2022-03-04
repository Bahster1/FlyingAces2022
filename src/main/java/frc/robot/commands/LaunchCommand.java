package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.RobotMap;
import frc.robot.subsystems.LauncherSubsystem;

public class LaunchCommand extends Command
{
    private LauncherSubsystem _launcher;
    private boolean _finished = false;
    private final int SECONDS_TO_ENCODER_PULSES;

    public LaunchCommand(int time)
    {
        _launcher = LauncherSubsystem.getInstance();
        SECONDS_TO_ENCODER_PULSES = time * RobotMap.LAUNCHER_MOTOR_RPM * RobotMap.PULSES_PER_REVOLUTION;

        requires(_launcher);
    }

    @Override
    public void initialize()
    {
        _launcher.zeroLauncher();
        _launcher.bothMotorsOn();
        _launcher.openGate();
    }

    @Override
    public void execute()
    {
        _finished = _launcher.getLauncherPosition() >= SECONDS_TO_ENCODER_PULSES;
    }

    @Override
    protected boolean isFinished()
    {
        return _finished;
    }

    @Override
    protected void end()
    {
        _launcher.closeGate();
        _launcher.bothMotorsOff();
    }
}
