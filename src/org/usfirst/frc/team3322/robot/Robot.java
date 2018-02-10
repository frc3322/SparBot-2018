/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3322.robot;

import org.usfirst.frc.team3322.robot.subsys.Arm;
import org.usfirst.frc.team3322.robot.subsys.DriveTrain;
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
		
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		m_drivetrain = new DriveTrain();
		m_OI = new OI();
		m_arm = new Arm();
		SmartDashboard.putData(m_drivetrain);
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
		Joystick joystick = m_OI.getJoystick();
		JoystickButton abutt = new JoystickButton(joystick, 1);
		JoystickButton bbutt = new JoystickButton(joystick, 2);
		JoystickButton xbutt = new JoystickButton(joystick, 3);
		JoystickButton ybutt = new JoystickButton(joystick, 4);
        SmartDashboard.putBoolean(  "A button",		abutt.get());
        SmartDashboard.putBoolean(  "B button",		bbutt.get());	
        SmartDashboard.putBoolean(  "X button",		xbutt.get());
        SmartDashboard.putBoolean(  "Y button",		ybutt.get());
        m_arm.log();
	}
}
