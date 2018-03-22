package org.usfirst.frc.team3322.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3322.robot.Robot;

/**
 * Drive until the robot is the given angle away from the box. Uses a local
 * PID controller to run a simple PID loop that is only enabled while this
 * command is running. The input is the averaged values of the left and right
 * encoders.
 */
public class RotateRobot extends Command {
	private PIDController m_pid;

	public RotateRobot(double angle) {
		requires(Robot.m_drivetrain);
		m_pid = new PIDController(0.03, 0, 0, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			@Override
			public double pidGet() {
				return Robot.m_drivetrain.getYaw();
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource;
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, d -> Robot.m_drivetrain.tankDrive(-d/2, d/2));

		m_pid.setAbsoluteTolerance(5.0);
		m_pid.setInputRange(-180.0f,  180.0f);
		m_pid.setOutputRange(-1.0, 1.0);
		m_pid.setContinuous(true);
		m_pid.setSetpoint(angle);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Get everything in a safe starting state.
		Robot.m_drivetrain.reset();
		m_pid.reset();
		m_pid.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return m_pid.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Stop PID and the wheels
		m_pid.disable();
		Robot.m_drivetrain.drive(0, 0);
		Robot.m_drivetrain.reset();
	}
}