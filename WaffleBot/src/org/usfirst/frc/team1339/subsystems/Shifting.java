package org.usfirst.frc.team1339.subsystems;

import org.usfirst.frc.team1339.base.SubsystemBase;
import org.usfirst.frc.team1339.utils.Constants;

import edu.wpi.first.wpilibj.Solenoid;

public class Shifting extends SubsystemBase{
	
	private Solenoid shiftOut, shiftIn;
	
	private boolean highGear = true;
	
	public Shifting(){
		shiftOut = new Solenoid(Constants.chassisShiftOut);
		shiftIn = new Solenoid(Constants.chassisShiftIn);
	}
	
	public void initDefaultCommand(){

	}
	
	public void setShiftIn(boolean value){
		shiftIn.set(value);
	}
	
	public void setShiftOut(boolean value){
		shiftOut.set(value);
	}
	
	public boolean isHighGear(){
		return highGear;
	}
}
