package org.usfirst.frc.team3322.robot.subsys;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	Talon m_arm = new Talon(4);
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Arm() {
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

