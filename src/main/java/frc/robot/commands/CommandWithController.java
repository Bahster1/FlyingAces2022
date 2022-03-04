package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CommandWithController extends Command
{
    private ControllerSubsystem _controller;
    private DrivetrainSubsystem _drivetrain;

    public CommandWithController()
    {
        _controller = ControllerSubsystem.getInstance();
        _drivetrain = DrivetrainSubsystem.getInstance();
    }

    @Override
    public void execute()
    {
        double driveSpeed = _controller.getJoystick().getRawAxis(ControllerMap.RIGHT_TRIGGER) - _controller.getJoystick().getRawAxis(ControllerMap.LEFT_TRIGGER);
        double driveTurn = _controller.getJoystick().getRawAxis(ControllerMap.LEFT_AXIS_X);

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
