package org.usfirst.frc.team3322.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3322.robot.Robot;

/**
 * Drive until the robot is the given distance away from the box. Uses a local
 * PID controller to run a simple PID loop that is only enabled while this
 * command is running. The input is the averaged values of the left and right
 * encoders.
 */
public class SetArmAngle extends Command {
	private PIDController m_pid;

	public SetArmAngle(double angle) {
		requires(Robot.m_arm);
		m_pid = new PIDController(0.3, 0, 0, new PIDSource() {
			PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

			@Override
			public double pidGet() {
				return Robot.m_arm.armPosition();
			}

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				m_sourceType = pidSource; 
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				return m_sourceType;
			}
		}, d -> Robot.m_arm.raiseOrLower(-d));

		m_pid.setAbsoluteTolerance(2);
		m_pid.setInputRange(5, 295);
		m_pid.setOutputRange(-0.5, 0.5);
		m_pid.setContinuous(true);
		m_pid.setSetpoint(angle);
		//LiveWindow.addActuator("ArmSystem",  "RotateArm", m_pid);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
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
		Robot.m_arm.raiseOrLower(0);
	}
}
