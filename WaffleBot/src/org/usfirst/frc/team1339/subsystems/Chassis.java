package org.usfirst.frc.team1339.subsystems;

import org.usfirst.frc.team1339.base.SubsystemBase;
import org.usfirst.frc.team1339.commands.ArcadeDrive;
import org.usfirst.frc.team1339.utils.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;

public class Chassis extends SubsystemBase{
	
	private CANTalon leftOne, leftTwo, rightOne, rightTwo;
	private Solenoid shifter;
	
	private double mQuickStopAccumulator;
	private double kTurnSensitivity = 1.0;
	
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
	
	public void openShifter(){
		
	}
	
	public void closeShifter(){
		
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

	public void wheelDrive(double throttle, double turn, boolean isQuickTurn) {
		double overPower;

        double angularPower;

        if (isQuickTurn) {
            if (Math.abs(throttle) < 0.2) {
                double alpha = 0.1;
                double limitedWheel = 0;
                if(turn > 0)
                	limitedWheel = Math.min(turn, 1.0);
                else
                	limitedWheel = Math.max(turn, -1.0);
                mQuickStopAccumulator = (1 - alpha) * mQuickStopAccumulator + alpha * limitedWheel * 2;
            }
            overPower = 1.0;
            angularPower = turn;
        } else {
            overPower = 0.0;
            angularPower = Math.abs(throttle) * turn * kTurnSensitivity - mQuickStopAccumulator;
            if (mQuickStopAccumulator > 1) {
                mQuickStopAccumulator -= 1;
            } else if (mQuickStopAccumulator < -1) {
                mQuickStopAccumulator += 1;
            } else {
                mQuickStopAccumulator = 0.0;
            }
        }

        double right = throttle - angularPower;
        double left = throttle + angularPower;
        if (left > 1.0) {
            right -= overPower * (left - 1.0);
            left = 1.0;
        } else if (right > 1.0) {
            left -= overPower * (right - 1.0);
            right = 1.0;
        } else if (left < -1.0) {
            right += overPower * (-1.0 - left);
            left = -1.0;
        } else if (right < -1.0) {
            left += overPower * (-1.0 - right);
            right = -1.0;
        }
        
        setMotorValues(left, right);
	}
}
