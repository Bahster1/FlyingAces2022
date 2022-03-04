package frc.robot.utils;

import frc.robot.config.RobotMap;

public class Conversions
{
	public static double convertPositionToEncoderPulses(double inches, double wheelDiameter)
	{
		double circumference = Math.PI * wheelDiameter;

		return (inches / circumference) * RobotMap.PULSES_PER_REVOLUTION;
	}

	public static double convertEncoderPulsesToPosition(double position, double wheelDiameter)
	{
		double circumference = Math.PI * wheelDiameter;

		return (position / RobotMap.PULSES_PER_REVOLUTION) * circumference;
	}
}
