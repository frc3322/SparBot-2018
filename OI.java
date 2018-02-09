package org.usfirst.frc.team3322.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick m_joystick = new Joystick(0);
	

	public OI() {
		JoystickButton dpadUp = new JoystickButton(m_joystick, 5);
		JoystickButton dpadRight = new JoystickButton(m_joystick, 6);
		JoystickButton dpadDown = new JoystickButton(m_joystick, 7);
		JoystickButton dpadLeft = new JoystickButton(m_joystick, 8);
		JoystickButton l2 = new JoystickButton(m_joystick, 9);
		JoystickButton r2 = new JoystickButton(m_joystick, 10);
		JoystickButton l1 = new JoystickButton(m_joystick, 11);
		JoystickButton r1 = new JoystickButton(m_joystick, 12);

	}
	public Joystick getJoystick() {
		return m_joystick;
	}
}
