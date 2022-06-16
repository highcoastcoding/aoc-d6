package se.hcc.aoc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.hcc.aoc.model.Lanternfish;

public class LanternFishService {
	
	private List<Lanternfish> shoolOfFish = new ArrayList<>();
	private Logger logger = LoggerFactory.getLogger(LanternFishService.class);
	
	/**
	 * Generates a starting school class
	 * @param daysToSpawn - Array of Integers containing the initial values of current school class spawn times
	 */
	public void createClass(Integer[] daysToSpawn) {
		
		for (Integer timeToSpawn : daysToSpawn) {
			shoolOfFish.add(new Lanternfish(timeToSpawn));
		}
	}
	
	/**
	 * Retrieves the current size of class
	 * @return
	 */
	public int getSchoolClassSize() {
		return shoolOfFish.size();
	}
	
	
	/**
	 * Makes a day pass, spawning new fishes 
	 */
	protected void makeDayPass() {
		
		List<Lanternfish> spawned = new ArrayList<Lanternfish>();
		
		for (Lanternfish lanternfish : shoolOfFish) {
			
			//checks if we should spawn any offsprings
			if(lanternfish.spawnOffSpring()) {
				spawned.add(new Lanternfish());
			}
			
			//decrease time to spawn
			lanternfish.dayPass();
		}
		
		shoolOfFish.addAll(spawned);
		
		logger.debug(getClassAsString());
		
	}
	
	/**
	 * Makes given nr of days pass
	 * @param nrOfDays
	 */
	public void passDays(int nrOfDays) {
		for (int i = 0; i < nrOfDays; i++) {
			makeDayPass();
		}
		
		logger.info(String.format("After %d days has passed the class has a size of %d fishes",nrOfDays,shoolOfFish.size()));
	}
	
	public String getClassAsString() {
		String result =  Arrays.toString(shoolOfFish.toArray());
		result = result.replaceAll("[^a-zA-Z0-9,]", "");
		return result;
	}
	
	
			

}
