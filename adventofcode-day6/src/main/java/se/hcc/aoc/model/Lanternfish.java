package se.hcc.aoc.model;

/**
 * Class representing a Lanternfish
 * @author Andreas Sjöström
 *
 */
public class Lanternfish {
	
	static final  int RESET_DAYS = 6;
	static final  int DEFAULT_SPAWNTIME = 8;
	
	private Integer daysToSpawnOffspring;
	
	public Lanternfish() {
		this.daysToSpawnOffspring = DEFAULT_SPAWNTIME;
	}
		
	public Lanternfish(int daysToSpawnOffspring) {
		this.daysToSpawnOffspring = daysToSpawnOffspring;
	}
	
	
	/**
	 *  Simulates that a day have passed
	 */
	public void dayPass() {
		
		if(daysToSpawnOffspring > 0)
			daysToSpawnOffspring--;
		else
			daysToSpawnOffspring = RESET_DAYS;
				
	}
	
	public int getDaysToSpawnOffspring() {
		return daysToSpawnOffspring;
	}
	
	/**
	 * Determines if fish should spawn offspring
	 * @return boolean telling if offspring should be spawned - true = offspring should be spawned
	 */
	
	public boolean spawnOffSpring() {
		boolean result = false;
		
		if(daysToSpawnOffspring == 0) {
			result = true;
		}
		
		return result;
	}
	
	public String toString() {
		return daysToSpawnOffspring.toString();
	}

}
