package org.usfirst.frc.team3322.robot.subsys;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
	
	Talon m_arm = new Talon(4);
	DoubleSolenoid exampleDouble = new DoubleSolenoid(0, 1);
	
	
	Potentiometer pot;
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Arm() {
		pot = new AnalogPotentiometer(0, 270);
	}
	
	public void open() {
		exampleDouble.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close() {
		exampleDouble.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void raiseOrLower(double input) {
		m_arm.set(input);
	}

	public double armPosition() {
		return pot.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void log() {
    	 SmartDashboard.putNumber("arm angle", pot.get());
    }
}

