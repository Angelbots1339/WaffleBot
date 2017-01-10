
package org.usfirst.frc.team1339.robot;


import org.usfirst.frc.team1339.subsystems.*;
import org.usfirst.frc.team1339.utils.HardwareAdapter;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	public Autonomous a;
	public TeleOp t;
	public static HardwareAdapter HardwareAdapter;
	public static Chassis chassis;
	public static Shifting shifting;
    public Robot() {
		a = new Autonomous();
    	t = new TeleOp();
    }

    public void robotInit() {
		HardwareAdapter = new HardwareAdapter();
    	chassis = new Chassis();
    	shifting = new Shifting();
    }

    @Override
    public void disabledInit(){
    	
    }

    @Override
    public void disabledPeriodic(){
    	
    }

    @Override
    public void teleopInit(){
    	t.init();
    }

    @Override
    public void teleopPeriodic(){
        while (isEnabled()) {
        	t.teleOpPeriodic();
        }
    }

    @Override
    public void autonomousInit(){
    	a.init();
    }

    @Override
    public void autonomousPeriodic(){
    	while(isAutonomous())
    		a.autonomousPeriodic();
    }
}
