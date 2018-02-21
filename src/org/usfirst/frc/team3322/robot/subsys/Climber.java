package org.usfirst.frc.team3322.robot.subsys;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	Talon m_extend = new Talon(7);
	Talon m_winch1 = new Talon(6);
	Talon m_winch2 = new Talon(5);
	SpeedControllerGroup m_winch = new SpeedControllerGroup(m_winch1, m_winch2);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void extend() {
		m_extend.set(1);
		
	}
	
	public void winchPull() {
		m_winch.set(-1);
	}
	
	public void winchStop() {
		m_winch.set(0);
		
	}
	
	public void extendStop() {
		m_extend.set(0);
	}

	
	public void log() {
		
	}
	
	
}
