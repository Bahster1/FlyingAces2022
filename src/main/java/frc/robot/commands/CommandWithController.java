package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.Drivetrain;

public class CommandWithController extends Command
{
    private ControllerSubsystem _controller;
    private Drivetrain _drivetrain;

    public CommandWithController()
    {
        _controller = ControllerSubsystem.getInstance();
        _drivetrain = Drivetrain.getInstance();
    }

    @Override
    public void execute()
    {
        double driveSpeed = _controller.getJoystick().getRawAxis(ControllerMap.RIGHT_TRIGGER) - _controller.getJoystick().getRawAxis(ControllerMap.LEFT_TRIGGER);
        double driveTurn = _controller.getJoystick().getRawAxis(ControllerMap.LEFT_AXIS_X);
        double launcher = _controller.getJoystick().getRawAxis(ControllerMap.LEFT_BUMPER);
        //Handles arcade drive
        _drivetrain.arcadeDrive(driveSpeed, driveTurn);


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
