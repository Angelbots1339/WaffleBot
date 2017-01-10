package org.usfirst.frc.team1339.subsystems;

import org.usfirst.frc.team1339.base.SubsystemBase;
import org.usfirst.frc.team1339.commands.ArcadeDrive;
import org.usfirst.frc.team1339.utils.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;

public class Chassis extends SubsystemBase{
	
	CANTalon leftOne, leftTwo, rightOne, rightTwo;
	Solenoid shifter;
	
	public Chassis(){
		leftOne = new CANTalon(Constants.chassisLeftOne);
		leftTwo = new CANTalon(Constants.chassisLeftTwo);
		rightOne = new CANTalon(Constants.chassisRightOne);
		rightTwo = new CANTalon(Constants.chassisRightTwo);
		
		shifter = new Solenoid(Constants.chassisShifter);
	}
	
	public void initDefaultCommand(){
		setDefaultCommand(new ArcadeDrive());
	}
	
	public void arcadeDrive(double throttle, double turn){
		double right = throttle;
    	double left = throttle;
    	double turningThrottleScale;
    	
    	if (Math.abs(throttle) > 0.1)
    		turningThrottleScale = Math.abs(throttle);
        else
        	turningThrottleScale = 0.75;
    	
    	right += turn * turningThrottleScale;  
        left -= turn * turningThrottleScale;
        
        if(Math.abs(right) <= 0.05)
        	right = 0;
        if(Math.abs(left) <= 0.05)
        	left = 0;
        
        setMotorValues(left, right);
	}
	
	private void setMotorValues(double left, double right){
		leftOne.set(left);
		leftTwo.set(left);
		rightOne.set(right);
		rightTwo.set(right);
	}
}
