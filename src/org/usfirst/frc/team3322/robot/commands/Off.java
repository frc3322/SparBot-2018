package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Off extends Command {

	public Off() {
		super(1);
		requires(Robot.m_arm);
	}
	
	@Override
	protected void initialize() {
		Robot.m_arm.open();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
