
 package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.config.ControllerMap;
import frc.robot.subsystems.ControllerSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.TestMotorSubsystem;

public class TestCommand extends Command {

    private TestMotorSubsystem _testMotor;
    private ControllerSubsystem _controller;
    //Var to track powerInc
    //IE Cruise control
    private double _setSpeed = 0.0;
    //Clock Cycle
    private int clockCycle = 0;
    //Robot Requires drivetrain system
    private Drivetrain _drivetrain;

    public TestCommand() {
        _testMotor = TestMotorSubsystem.getInstance();
        _controller = ControllerSubsystem.getInstance();
        _drivetrain = Drivetrain.getInstance();
    }

    @Override
    public void execute()
    {
        //Tracking Clock Cycle
        if (clockCycle < 50)
        {
            clockCycle++;
            System.out.println("Logging ClockCycle: " + clockCycle);
        }
        else
        {
            if(_controller.getJoystick().getRawAxis(ControllerMap.RIGHT_TRIGGER) > 0.1)
            {
                if(_setSpeed < 2) {
                    if(_setSpeed <= 1 && _setSpeed >= 0) {
                        _setSpeed = 1.0;
                    }
                    else {
                        _setSpeed += 0.25;
                    }
                }
                clockCycle = 0;
            }
            else if(_controller.getJoystick().getRawAxis(ControllerMap.LEFT_TRIGGER) > 0.1)
            {
                if(_setSpeed > -2) {
                    if(_setSpeed >= -1.0 && _setSpeed <= 0) {
                        _setSpeed = -1.0;
                    }
                    else {
                        _setSpeed -= 0.25;
                    }
                }
                clockCycle = 0;
            }
            System.out.println("TestCommandElse: Ran");
        }
        _drivetrain.arcadeDrive(_setSpeed, 0);
        System.out.println("TestCommandSpeed: " + _setSpeed);
        //_testMotor.runVelo(15000);
        //_testMotor.run(1);
        //_testMotor.run(_controller.getJoystick().getRawAxis(ControllerMap.RIGHT_TRIGGER) - _controller.getJoystick().getRawAxis(ControllerMap.LEFT_TRIGGER));
    }


    @Override
    protected boolean isFinished() {
        return false;
    }
}

