package se.hcc.aoc.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LanternfishTest {
	
	@Test
	@DisplayName("Test of spawn time generation")
	void creationDaysTest() {
		int daysToSpawn = 3;
		//arrange
		Lanternfish fish = new Lanternfish(daysToSpawn);
		//assert
		assertThat(fish.getDaysToSpawnOffspring()).isEqualTo(daysToSpawn);
		
	}
	
	@Test
	@DisplayName("Test of default spawn time generation")
	void creationDefaultDaysTest() {
		
		//arrange
		Lanternfish fish = new Lanternfish();
		//assert
		assertThat(fish.getDaysToSpawnOffspring()).isEqualTo(Lanternfish.DEFAULT_SPAWNTIME);
		
	}
	
	@Test
	@DisplayName("Test of day passing")
	void dayPassTest() {
		
		//arrange
		Lanternfish fish = new Lanternfish(3);
		//act
		fish.dayPass();
		//assert
		assertThat(fish.getDaysToSpawnOffspring()).isEqualTo(2);
		
	}
	
	@Test
	@DisplayName("Test of day passing reaching reset")
	void dayPassTestReset() {
		
		//arrange
		Lanternfish fish = new Lanternfish(0);
		//act
		fish.dayPass();
		//assert
		assertThat(fish.getDaysToSpawnOffspring()).isEqualTo(Lanternfish.RESET_DAYS);
		
	}
	
	@Test
	@DisplayName("Test no offspring should be spawned")
	void noOffspringTest() {
		
		//arrange
		Lanternfish fish = new Lanternfish();
		//assert
		assertThat(fish.spawnOffSpring()).isFalse();
		
	}
	
	@Test
	@DisplayName("Test offspring should be spawned")
	void offspringTest() {
		
		//arrange
		Lanternfish fish = new Lanternfish(0);
		//assert
		assertThat(fish.spawnOffSpring()).isTrue();
		
	}

}
