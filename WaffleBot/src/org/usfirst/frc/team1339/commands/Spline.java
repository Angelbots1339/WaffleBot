package org.usfirst.frc.team1339.commands;

import org.usfirst.frc.team1339.base.CommandBase;
import org.usfirst.frc.team1339.robot.Robot;
import org.usfirst.frc.team1339.utils.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class Spline extends CommandBase{
	public Spline(){
		requires(Robot.chassis);
	}
	
	protected void init(){
		Robot.HardwareAdapter.splineProfile.configureSplineProfile(400, Math.toRadians(90), 0, 0, 0.4, true);
	}
	
	public void execute(){
		Robot.chassis.driveSpline();
	}
	
	public boolean isFinished(){
		return Robot.HardwareAdapter.splineProfile.isFinishedTrajectory();
	}
	
	protected void end(){
		
	}
	
	protected void interrupted(){
		
	}
}
