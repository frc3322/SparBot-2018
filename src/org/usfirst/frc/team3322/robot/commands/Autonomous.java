package org.usfirst.frc.team3322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{
	public Autonomous() {
		//addSequential(new DriveDistance(-20));
		//addSequential(new RotateRobot(90));
		addSequential(new DriveDistance(-8));
	}

}
