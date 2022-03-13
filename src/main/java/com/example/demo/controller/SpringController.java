package com.example.demo.controller;

import java.security.SecureRandom;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class SpringController {
	
	private Logger logger = Logger.getLogger("SpringController");

	@Value("${EXAMPLE_PROPERTIES}")
//	@Value("#{systemEnvironment['EXAMPLE_PROPERTIES']}")
	private String exampleProperties;
	
	@Value("${secret.username}")
//	@Value("#{systemEnvironment['secret.username']}")
	private String username;
	
	@Value("${secret.password}")
//	@Value("#{systemEnvironment['secret.password']}")
	private String password;
	
	
	@GetMapping(value = "hello")
	public String getPrintout(@RequestParam int number) {

		return "myRandomNumberIs: " + generateRandom(number);
	}
	
	@GetMapping(value="getProperties")
	public String getProperties() {
		logger.info("Get from properties: " + exampleProperties);
		return "the property retrieve is: " + exampleProperties;
	}
	
	@GetMapping(value="getSecretProperties")
	public String getSecretProperties() {
		logger.info(username + " : " + password);
		return ("getting secret at: " + username + " : " + password);

	}

	public static String generateRandom(int maximumValue) {
		SecureRandom test = new SecureRandom();
		int result = test.nextInt(1000000);
		String resultStr = result + "";
		if (resultStr.length() != maximumValue)
			for (int x = resultStr.length(); x < maximumValue; x++)
				resultStr = "0" + resultStr;
		return resultStr;
	}
}
