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
		Robot.m_drivetrain.drive(Robot.m_OI.getJoystick());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_drivetrain.drive(0, 0);
	}
}


