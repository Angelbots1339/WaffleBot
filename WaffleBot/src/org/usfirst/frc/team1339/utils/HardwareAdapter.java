package org.usfirst.frc.team1339.utils;

import org.usfirst.frc.team1339.commands.*;

import edu.wpi.first.wpilibj.Joystick;

public class HardwareAdapter{
	
	public static SplineProfile splineProfile = new SplineProfile(0.0008, 0, 0, 0.5, 0.5);
	
	private Joystick xboxStick = new Joystick(Constants.xboxPort);
	
	private AngelButton aButton = new AngelButton(xboxStick, Constants.xboxAButton);
	private AngelButton xButton = new AngelButton(xboxStick, Constants.xboxXButton);
	private AngelButton rightBumper = new AngelButton(xboxStick, Constants.xboxRightBumper);
	
	public HardwareAdapter(){
		
	}
	
	public void checkTriggers(){
		aButton.whenPressed(new Spline());
		xButton.toggle(new ShiftHigh(), new ShiftLow());
	}
	
	public Joystick getXboxStick(){
		return xboxStick;
	}
	public AngelButton getAButton(){
		return aButton;
	}
	public AngelButton getXButton(){
		return xButton;
	}
	public AngelButton getRightBumper(){
		return rightBumper;
	}
}
