package org.usfirst.frc.team1339.commands;

import org.usfirst.frc.team1339.base.CommandBase;
import org.usfirst.frc.team1339.robot.Robot;
import org.usfirst.frc.team1339.utils.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class ArcadeDrive extends CommandBase{
	
	Joystick stick;
	
	public ArcadeDrive(){
		requires(Robot.chassis);
	}
	
	protected void init(){
		
	}
	
	public void execute(){
		stick = Robot.HardwareAdapter.getXboxStick();
		
		double throttle = stick.getRawAxis(Constants.xboxLeftYAxis);
		double turn = stick.getRawAxis(Constants.xboxRightXAxis);
		
		Robot.chassis.arcadeDrive(throttle, turn);
	}
	
	public boolean isFinished(){
		return false;
	}
	
	protected void end(){
		
	}
	
	protected void interrupted(){
		
	}
}
