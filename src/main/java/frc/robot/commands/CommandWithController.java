package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LauncherSubsystem;

public class CommandWithController extends Command
{
    private ControllerSubsystem _controller;
    private Drivetrain _drivetrain;
    private LauncherSubsystem _launcher;

    public CommandWithController()
    {
        _controller = ControllerSubsystem.getInstance();
        _drivetrain = Drivetrain.getInstance();
        _launcher = LauncherSubsystem.getInstance();
    }

    @Override
    public void execute()
    {
        double driveSpeed = _controller.getJoystick().getRawAxis(ControllerMap.RIGHT_TRIGGER) - _controller.getJoystick().getRawAxis(ControllerMap.LEFT_TRIGGER);
        double driveTurn = _controller.getJoystick().getRawAxis(ControllerMap.LEFT_AXIS_X);
        double launcher = _controller.getJoystick().getRawAxis(ControllerMap.LEFT_BUMPER);
        double currentTimeMillis = System.currentTimeMillis();
        //Handles arcade drive
        _drivetrain.arcadeDrive(driveSpeed, driveTurn);

        if(launcher != 0 && _launcher.getMotorStatus() == false)
        {
            _launcher.launchAtPerOut(1);
        }
        //Checks if gate can be opened, current delay is 200millis
        if(currentTimeMillis - _launcher.getTimeSinceRev() < 200)
        {
            _launcher.openGate();
        }

    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
        _drivetrain.arcadeDrive(0,0);
    }

    @Override
    protected void interrupted()
    {
        end();
    }
}
