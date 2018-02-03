package org.usfirst.frc.team3322.robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {


	public TankDrive() {
		requires(Robot.m_drivetrain);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//double acclePow  = 1;//SmartDashboard.getNumber("accelation_force", 1);
		//double rotatePow = 1;//SmartDashboard.getNumber("rotation_force", 1);
		double accel  =  Robot.m_drivetrain.m_stick.getRawAxis(1);// *Math.abs(Math.pow(m_stick.getRawAxis(1), acclePow-1));
		double rotate = -Robot.m_drivetrain.m_stick.getRawAxis(4);// *Math.abs(Math.pow(m_stick.getRawAxis(4), rotatePow-1));
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


