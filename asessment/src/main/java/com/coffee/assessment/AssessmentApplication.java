package com.coffee.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessmentApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(AssessmentApplication.class, args);
		} catch (Throwable ex){
			ex.printStackTrace();
		}
	}

}
