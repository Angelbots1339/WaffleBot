package org.usfirst.frc.team1339.utils;

import org.usfirst.frc.team1339.commands.*;

import edu.wpi.first.wpilibj.Joystick;

public class HardwareAdapter{
	
	private Joystick xboxStick = new Joystick(Constants.xboxPort);
	
	private AngelButton aButton = new AngelButton(xboxStick, Constants.xboxAButton);
	private AngelButton xButton = new AngelButton(xboxStick, Constants.xboxXButton);
	private AngelButton rightBumper = new AngelButton(xboxStick, Constants.xboxRightBumper);
	
	public HardwareAdapter(){
		
	}
	
	public void checkTriggers(){
		aButton.toggle(new WheelDrive(), new ArcadeDrive());
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
