package org.usfirst.frc.team1339.utils;

import edu.wpi.first.wpilibj.Joystick;

public class HardwareAdapter{
	
	private Joystick xboxStick = new Joystick(Constants.xboxPort);
	
	public HardwareAdapter(){
		
	}
	
	public void checkTriggers(){
		/*
		 * This is where you put any whenPressed() or toggle() things. eg:
		 * AButton.whenPressed(new DriveShooter);
		 * or
		 * XButton.toggle(new TankDrive(), new ArcadeDrive());
		 */
	}
	
	public Joystick getXboxStick(){
		return xboxStick;
	}
}
