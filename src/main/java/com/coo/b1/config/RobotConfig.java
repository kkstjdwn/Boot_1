package com.coo.b1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coo.b1.robot.LeftArm;
import com.coo.b1.robot.RightArm;

@Configuration
public class RobotConfig {
	
	@Bean("left")
	public LeftArm getLeftArm() throws Exception{
		LeftArm leftArm = new LeftArm();
		return leftArm;
	}
	
	@Bean("right")
	public RightArm getRightArm() throws Exception{
		RightArm rightArm = new RightArm();
		return rightArm;
	}
	
}
