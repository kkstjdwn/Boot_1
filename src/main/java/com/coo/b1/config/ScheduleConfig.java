package com.coo.b1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler tpts = new ThreadPoolTaskScheduler();
		
		tpts.setPoolSize(8);
		tpts.setThreadNamePrefix("뜨레주르");
		tpts.initialize();
		taskRegistrar.setTaskScheduler(tpts);
	}
	
}
