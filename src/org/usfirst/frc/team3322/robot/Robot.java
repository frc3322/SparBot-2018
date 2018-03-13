/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3322.robot;

import org.usfirst.frc.team3322.robot.subsys.Arm;
import org.usfirst.frc.team3322.robot.subsys.Climber;
import org.usfirst.frc.team3322.robot.subsys.DriveTrain;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot { 

	public static DriveTrain m_drivetrain;
	public static OI m_OI;
	public static Arm m_arm;
	public static Climber m_climber;
		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		m_drivetrain = new DriveTrain();
		m_arm = new Arm();
		m_climber = new Climber();
		m_OI = new OI();
		SmartDashboard.putData(m_drivetrain);
		
		SmartDashboard.putNumber("accle Pow", 3);
		SmartDashboard.putNumber("rotate Pow", 3);
		
//        UsbCamera camera = new UsbCamera("cam0",0);
//        camera.setFPS(15);
//        camera.setResolution(320, 240); //320 = width, 240 = height
//        CameraServer.getInstance().startAutomaticCapture(camera);
	}

	/**
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit() {
		m_drivetrain.reset();
	}

	/**
	 * This function is called periodically during teleoperated mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}
	
	/**
	 * This function is called periodically during test mode.
	 */
	
	private void log() {
		m_drivetrain.log();
        m_arm.log();
        m_climber.log();
	}
}
