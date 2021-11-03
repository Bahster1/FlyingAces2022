package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.config.ControllerMap;

public class ControllerSubsystem extends Subsystem
{
    private static ControllerSubsystem _instance;
    private final Joystick _joystick;

    private ControllerSubsystem()
    {
        _joystick = new Joystick(ControllerMap.JOYSTICK_PORT);
    }

    public static ControllerSubsystem getInstance()
    {
        if (_instance == null)
            _instance = new ControllerSubsystem();

        return _instance;
    }

    public Joystick getJoystick()
    {
        return _joystick;
    }

    @Override
    protected void initDefaultCommand()
    {

    }
}
