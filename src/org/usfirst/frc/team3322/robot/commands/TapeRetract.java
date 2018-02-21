package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TapeRetract extends Command {
	
	public TapeRetract() {
		requires(Robot.m_climber);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		Robot.m_climber.extendStop();
	}
	
	@Override
	protected void initialize() {
		Robot.m_climber.tapeRetract();
	}

}
