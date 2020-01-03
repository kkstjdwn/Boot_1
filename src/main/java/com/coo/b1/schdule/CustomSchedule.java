package com.coo.b1.schdule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {
	
	//@Scheduled(fixedRate = 5000)
	//@Scheduled(fixedRateString = "5000")
	public void fixedRateSchedule() throws Exception{
		System.out.println("FixedRate - " + Thread.currentThread().getName());
		Thread.sleep(2000);
	}
	
	//@Scheduled(fixedDelay = 1000)
	//@Scheduled(fixedDelayString = "1000")
	public void fixedDelaySchedule() throws Exception{
		System.out.println("Delay - " + Thread.currentThread().getName());
	}
	
	//@Scheduled(cron = "*/3 * * * * *")
	public void cronSchedule() throws Exception{
		System.out.println("크롱크롱 - " + Thread.currentThread().getName());
	}
}
