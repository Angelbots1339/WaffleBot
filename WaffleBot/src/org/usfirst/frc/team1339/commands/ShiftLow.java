package org.usfirst.frc.team1339.commands;

import org.usfirst.frc.team1339.base.CommandBase;
import org.usfirst.frc.team1339.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

public class ShiftLow extends CommandBase{
	
	Joystick stick;
	int counter = 0;
	
	public ShiftLow(){
		requires(Robot.shifting);
		setRunSpeed(0.05); 
	}
	
	protected void init(){
		
	}
	
	public void execute(){
		if(counter == 0){
			Robot.shifting.setShiftOut(false);
			Robot.shifting.setShiftIn(true);
			counter++;
		}
		else{
			Robot.shifting.setShiftIn(false);
			counter++;
		}
	}
	
	public boolean isFinished(){
		return counter > 1;
	}
	
	protected void end(){
		
	}
	
	protected void interrupted(){
		
	}
}
