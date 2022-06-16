package se.hcc.aoc;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.hcc.aoc.service.LanternFishService;

@SpringBootApplication
public class AdventofcodeDay6Application {
	
	static Logger logger = LoggerFactory.getLogger(AdventofcodeDay6Application.class);

	public static void main(String[] args) {
		SpringApplication.run(AdventofcodeDay6Application.class, args);
		
		Integer[] spawnDays = {3,4,3,1,2};
		logger.debug(String.format("The starting class is %s", Arrays.toString(spawnDays)));
		
		LanternFishService serviceFish = new LanternFishService();
		serviceFish.createClass(spawnDays);
		
		//Get the number of days to pass from user
		logger.info("");
		logger.info("");
		logger.info("********************************************");
		
		Scanner in = new Scanner(System.in);
		
		boolean done = false;
		//run until user actually gives a number
		for (int i = 0; i < 10 && !done; i++) {
			logger.info("Type the number of days to pass max(100):");	
			try {
				int nrOfDays = in.nextInt();
								
				if(nrOfDays > 300) {
					throw new InputMismatchException("Number of days can not be larger than 100");
				}
				
				done=true;
				serviceFish.passDays(nrOfDays);
				
			}catch (InputMismatchException e) {
				in.nextLine();
				logger.info("Invalid number of days, must be a number <= 100");
				logger.info("Type the number of days to pass:");
				
			}
		}
		
		in.close();
		
		
		
		
		
	}

}
