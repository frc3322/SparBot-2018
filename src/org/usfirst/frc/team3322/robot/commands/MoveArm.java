package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {

	
	double m_speed;
	public MoveArm(double speed) {
		m_speed = speed;
		requires(Robot.m_arm);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void initialize() {
		Robot.m_arm.raiseOrLower(m_speed);
	}
	@Override
	protected void end() {
			Robot.m_arm.raiseOrLower(0);
	}
}
