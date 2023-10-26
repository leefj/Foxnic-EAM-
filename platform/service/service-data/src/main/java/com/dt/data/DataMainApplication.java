package com.dt.data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport"})
public class DataMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataMainApplication.class,args);

	}
}