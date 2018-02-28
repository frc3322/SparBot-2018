package org.usfirst.frc.team3322.robot;

import org.usfirst.frc.team3322.robot.commands.Climb;
import org.usfirst.frc.team3322.robot.commands.DriveDistance;
import org.usfirst.frc.team3322.robot.commands.ExtendTape;
import org.usfirst.frc.team3322.robot.commands.Grab;
import org.usfirst.frc.team3322.robot.commands.MoveArm;
import org.usfirst.frc.team3322.robot.commands.Release;
import org.usfirst.frc.team3322.robot.commands.TapeRetract;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick m_joystick = new Joystick(0);
	

	public OI() {
		JoystickButton bumper_left = new JoystickButton(m_joystick, 5);
		JoystickButton bumper_right = new JoystickButton(m_joystick, 6);
		JoystickButton button_back = new JoystickButton(m_joystick, 7);
		JoystickButton button_start = new JoystickButton(m_joystick, 8);
		/*JoystickButton l2 = new JoystickButton(m_joystick, 9);
		JoystickButton r2 = new JoystickButton(m_joystick, 10);
		JoystickButton l1 = new JoystickButton(m_joystick, 11);
		JoystickButton r1 = new JoystickButton(m_joystick, 12);*/
		JoystickButton button_a = new JoystickButton(m_joystick, 1);
		JoystickButton button_b = new JoystickButton(m_joystick, 2);
		JoystickButton button_x = new JoystickButton(m_joystick, 3);
		JoystickButton button_y = new JoystickButton(m_joystick, 4);

		button_y.whenPressed(new MoveArm(-0.5));
		button_y.whenReleased(new MoveArm(0));
		
		button_a.whenPressed(new MoveArm(0.5));
		button_a.whenReleased(new MoveArm(0));
		
		button_x.whenPressed(new Release());
		button_b.whenPressed(new Grab());
		
		bumper_right.whileHeld(new ExtendTape());
		bumper_left.whileHeld(new Climb());		
		
		//button_back.whenPressed(new DriveDistance(0.01));
		button_start.whileHeld(new TapeRetract());
		
	}
	
	public Joystick getJoystick() {
		return m_joystick;
	}
}
