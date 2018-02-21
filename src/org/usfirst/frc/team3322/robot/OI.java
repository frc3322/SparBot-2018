package org.usfirst.frc.team3322.robot;

import org.usfirst.frc.team3322.robot.commands.Climb;
import org.usfirst.frc.team3322.robot.commands.DriveDistance;
import org.usfirst.frc.team3322.robot.commands.ExtendTape;
import org.usfirst.frc.team3322.robot.commands.Grab;
import org.usfirst.frc.team3322.robot.commands.MoveArm;
import org.usfirst.frc.team3322.robot.commands.Off;
import org.usfirst.frc.team3322.robot.commands.Release;
import org.usfirst.frc.team3322.robot.commands.TapeRetract;
import org.usfirst.frc.team3322.robot.subsys.Climber;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick m_joystick = new Joystick(0);
	

	public OI() {
		JoystickButton lb = new JoystickButton(m_joystick, 5);
		JoystickButton rb = new JoystickButton(m_joystick, 6);
		JoystickButton backButt = new JoystickButton(m_joystick, 7);
		JoystickButton startButt = new JoystickButton(m_joystick, 8);
		JoystickButton l2 = new JoystickButton(m_joystick, 9);
		JoystickButton r2 = new JoystickButton(m_joystick, 10);
		JoystickButton l1 = new JoystickButton(m_joystick, 11);
		JoystickButton r1 = new JoystickButton(m_joystick, 12);
		JoystickButton abutt = new JoystickButton(m_joystick, 1);
		JoystickButton bbutt = new JoystickButton(m_joystick, 2);
		JoystickButton xbutt = new JoystickButton(m_joystick, 3);
		JoystickButton ybutt = new JoystickButton(m_joystick, 4);

		ybutt.whenPressed(new MoveArm(-0.5));
		ybutt.whenReleased(new MoveArm(0));
		
		abutt.whenPressed(new MoveArm(0.5));
		abutt.whenReleased(new MoveArm(0));
		
		xbutt.whenPressed(new Release());
		bbutt.whenPressed(new Grab());
		
		rb.whileHeld(new ExtendTape());
		lb.whileHeld(new Climb());		
		
		backButt.whenPressed(new DriveDistance(24));
		startButt.whileHeld(new TapeRetract());
		
	}
	
	public Joystick getJoystick() {
		return m_joystick;
	}
}
