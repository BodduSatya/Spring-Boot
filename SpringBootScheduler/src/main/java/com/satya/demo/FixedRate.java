package com.satya.demo;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRate {
	@Scheduled(fixedRate = 2000)
	public void scheduledMethod() {
		System.out.println("FixedRate.Scheduled Method =>"+new Date());
	}
}
