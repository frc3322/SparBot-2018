package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class Release extends TimedCommand {

	public Release() {
		super(1);
		requires(Robot.m_arm);
	}
	
	@Override
	protected void initialize() {
		Robot.m_arm.close();
	}
}
