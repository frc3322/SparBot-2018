package org.usfirst.frc.team3322.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem {
	Talon m_frontLeft = new Talon(0);
	Talon m_rearLeft = new Talon(1);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	Talon m_frontRight = new Talon(2);
	Talon m_rearRight = new Talon(3);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	DifferentialDrive m_robotDrive;
	PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	private Encoder m_leftEncoder = new Encoder(1, 2);
	private Encoder m_rightEncoder = new Encoder(3, 4);
	
	AHRS ahrs;
	
	private Joystick m_stick = new Joystick(0);
	private Timer m_timer = new Timer();
	
	
	
	public DriveTrain() {
		super();

			m_left.setInverted(true);
			m_right.setInverted(true);
			m_robotDrive = new DifferentialDrive(m_left, m_right);

		m_leftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		m_rightEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		
		// Let's name the sensors on the LiveWindow
		addChild("DifferentialDrive", m_robotDrive);
		addChild("Left Encoder", m_leftEncoder);
		addChild("Right Encoder", m_rightEncoder);
	
		m_left.setInverted(true);
		m_right.setInverted(true);
		m_robotDrive = new DifferentialDrive(m_left, m_right);
		
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		double acclePow  = SmartDashboard.getNumber("accelation_force", 1);
		double rotatePow = SmartDashboard.getNumber("rotation_force", 1);
		double accel  =  m_stick.getRawAxis(1) *Math.abs(Math.pow(m_stick.getRawAxis(1), acclePow-1));
		double rotate = -m_stick.getRawAxis(4) *Math.abs(Math.pow(m_stick.getRawAxis(4), rotatePow-1));
		m_robotDrive.arcadeDrive(accel, rotate);
        SmartDashboard.putNumber("acceleration", accel);
        SmartDashboard.putNumber("rotation", rotate);
       
	}

	public void log() {
		SmartDashboard.putNumber("Left Distance", m_leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Distance", m_rightEncoder.getDistance());
		SmartDashboard.putNumber("Left Speed", m_leftEncoder.getRate());
		SmartDashboard.putNumber("Right Speed", m_rightEncoder.getRate());

		SmartDashboard.putNumber("current", pdp.getCurrent(0));
		SmartDashboard.putNumber("Voltage", pdp.getVoltage());
		
		SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
        SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
	
	}

}