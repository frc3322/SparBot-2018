package org.usfirst.frc.team3322.robot.subsys;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3322.robot.commands.TankDrive;

import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem {
	Talon m_frontLeft = new Talon(2);
	Talon m_rearLeft = new Talon(3);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	Preferences prefs;
	double m_acclePow;
	double m_rotatePow;
	
	
	Talon m_frontRight = new Talon(0);
	Talon m_rearRight = new Talon(1);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	public DifferentialDrive m_robotDrive;
//	PowerDistributionPanel pdp = new PowerDistributionPanel();
	
//	private Encoder m_leftEncoder = new Encoder(1, 2);
//	private Encoder m_rightEncoder = new Encoder(3, 4);
	
	AHRS ahrs;
	
	
	public DriveTrain() {
		super();

		prefs = Preferences.getInstance();
		m_acclePow = prefs.getDouble("acclePow", 2.0);
		m_rotatePow = prefs.getDouble("rotatePow", 2.);

//		m_leftEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
//		m_rightEncoder.setDistancePerPulse((4.0 / 12.0 * Math.PI) / 360.0);
		
		try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
		
		// Let's name the sensors on the LiveWindow
	
		m_left.setInverted(true);
		m_right.setInverted(true);
		m_robotDrive = new DifferentialDrive(m_left, m_right);
		m_robotDrive.setSafetyEnabled(false);
		addChild("DifferentialDrive", m_robotDrive);
//		addChild("Left Encoder", m_leftEncoder);
//		addChild("Right Encoder", m_rightEncoder);
		
	}
	
	
	
	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(new TankDrive(m_acclePow, m_rotatePow));
        //SmartDashboard.putNumber("acceleration", accel);
        //SmartDashboard.putNumber("rotation", rotate);
       
	}

	public void drive(Joystick joy) { 		
		double accel  =  joy.getRawAxis(1)*Math.abs(Math.pow(joy.getRawAxis(1), m_acclePow-1));
		double rotate = -joy.getRawAxis(4)*Math.abs(Math.pow(joy.getRawAxis(4), m_rotatePow-1));
		drive(accel, rotate);
	}
	
	public void drive(double left, double right) {
		m_robotDrive.arcadeDrive(left, right);
	}
		
	public void log() {
//		SmartDashboard.putNumber("Left Distance", m_leftEncoder.getDistance());
//		SmartDashboard.putNumber("Right Distance", m_rightEncoder.getDistance());
//		SmartDashboard.putNumber("Left Speed", m_leftEncoder.getRate());
//		SmartDashboard.putNumber("Right Speed", m_rightEncoder.getRate());

//		SmartDashboard.putNumber("current", pdp.getCurrent(0));
//		SmartDashboard.putNumber("Voltage", pdp.getVoltage());
		
 	    SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
        SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
        SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
        SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());
        SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
        
	}

}