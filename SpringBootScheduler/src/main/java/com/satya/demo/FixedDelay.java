package com.satya.demo;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedDelay {
//	@Scheduled(initialDelay = 2000, fixedDelay = 10000)
	@Scheduled(initialDelayString = "3000", fixedDelayString = "20000")
	public void scheduledMethod() {
		System.out.println("FixedDelay.ScheduledMethod executed =>"+new Date());
	}
}
