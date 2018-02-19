package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendTape extends Command {

	public ExtendTape() {
		requires(Robot.m_climber);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void initialize() {
		Robot.m_climber.extend();
	}

}
