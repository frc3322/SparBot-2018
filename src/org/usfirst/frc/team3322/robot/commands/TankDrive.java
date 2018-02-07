package org.usfirst.frc.team3322.robot.commands;

import org.usfirst.frc.team3322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	double m_acclePow;
	double m_rotatePow;
	public TankDrive(double accelPow, double rotatePow) {
		m_acclePow = accelPow;
		m_rotatePow = rotatePow;
		
		requires(Robot.m_drivetrain);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double accel  =  Robot.m_drivetrain.m_stick.getRawAxis(1)*Math.abs(Math.pow(Robot.m_drivetrain.m_stick.getRawAxis(1), m_acclePow-1));
		double rotate = -Robot.m_drivetrain.m_stick.getRawAxis(4)*Math.abs(Math.pow(Robot.m_drivetrain.m_stick.getRawAxis(4), m_rotatePow-1));
		Robot.m_drivetrain.m_robotDrive.arcadeDrive(accel, rotate);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_drivetrain.m_robotDrive.arcadeDrive(0, 0);
	}
}


