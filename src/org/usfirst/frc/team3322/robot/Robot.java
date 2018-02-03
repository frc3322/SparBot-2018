/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3322.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Talon m_frontLeft = new Talon(0);
	Talon m_rearLeft = new Talon(1);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	Talon m_frontRight = new Talon(2);
	Talon m_rearRight = new Talon(3);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
	
	DifferentialDrive m_robotDrive;
	PowerDistributionPanel pdp = new PowerDistributionPanel();
	
	private Joystick m_stick = new Joystick(0);
	private Timer m_timer = new Timer();
	
	AHRS ahrs;		//navx 

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_left.setInverted(true);
		m_right.setInverted(true);
		m_robotDrive = new DifferentialDrive(m_left, m_right);
		SmartDashboard.putNumber("accelation_force", 1);
		SmartDashboard.putNumber("rotation_force", 1);
		
		try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }

	}

	/**
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		m_timer.reset();
		m_timer.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
		} else {
			m_robotDrive.stopMotor(); // stop robot
		}
	}

	/**
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during teleoperated mode.
	 */
	@Override
	public void teleopPeriodic() {
		double acclePow  = SmartDashboard.getNumber("accelation_force", 1);
		double rotatePow = SmartDashboard.getNumber("rotation_force", 1);
		double accel  =  m_stick.getRawAxis(1) *Math.abs(Math.pow(m_stick.getRawAxis(1), acclePow-1));
		double rotate = -m_stick.getRawAxis(4) *Math.abs(Math.pow(m_stick.getRawAxis(4), rotatePow-1));
		m_robotDrive.arcadeDrive(accel, rotate);
        SmartDashboard.putNumber("acceleration", accel);
        SmartDashboard.putNumber("rotation", rotate);
       
		SmartDashboard.putNumber("current", pdp.getCurrent(0));
		SmartDashboard.putNumber("Voltage", pdp.getVoltage());
		
		SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
        SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
