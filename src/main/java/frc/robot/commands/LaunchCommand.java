package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.LauncherSubsystem;

import java.util.concurrent.TimeUnit;

public class LaunchCommand extends Command {
    private LauncherSubsystem _launcher;
    public LaunchCommand() throws InterruptedException {
        _launcher.bothMotorsOn();
        TimeUnit.MILLISECONDS.sleep(200);
        _launcher.openGate();
        TimeUnit.MILLISECONDS.sleep(1000);
        _launcher.closeGate();
        _launcher.bothMotorsOff();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
