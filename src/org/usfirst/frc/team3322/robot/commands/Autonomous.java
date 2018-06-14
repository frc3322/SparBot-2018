package org.usfirst.frc.team3322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup{

	public enum Position {
		LEFT,
		CENTER,
		RIGHT
	}

	private Position startPos;

	public Autonomous() {

		this.startPos = Position.LEFT;
		//addSequential(new DriveDistance(-20));
		//addSequential(new RotateRobot(90));
		//addSequential(new DriveDistance(-8));
		switch(Position){
			case LEFT:
			case RIGHT:
				addSequential(new DriveDistance(-8));
				break;
			case CENTER:
				//null
		}
	}

}
