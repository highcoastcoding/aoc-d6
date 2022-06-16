package se.hcc.aoc.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LanternFishServiceTest {

	LanternFishService serviceLanterFish = new LanternFishService();
	
	@Test
	@DisplayName("Test of class size generation")
	void creationDefaultDaysTest() {
		
		Integer[] spawnDays = {1,2,3,4,5};
		serviceLanterFish.createClass(spawnDays);
	
		assertThat(serviceLanterFish.getSchoolClassSize()).isEqualTo(5);
		
	}
	
	@Test
	@DisplayName("Test day pass but no spawns")
	void noSpawnsTest() {
		
		Integer[] spawnDays = {1,2,3,4,5};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.makeDayPass();
	
		assertThat(serviceLanterFish.getSchoolClassSize()).isEqualTo(5);
		
	}
	
	@Test
	@DisplayName("Test day pass but and one spawn")
	void spawnTest() {
		
		Integer[] spawnDays = {0,2,3,4,5};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.makeDayPass();

		assertThat(serviceLanterFish.getSchoolClassSize()).isEqualTo(6);
		
	}
	
	@Test
	@DisplayName("Test 4 days pass")
	void fourDaysPassTest() {
		
		Integer[] spawnDays = {3,4,3,1,2};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.passDays(4);
		assertThat(serviceLanterFish.getClassAsString()).isEqualTo("6,0,6,4,5,6,7,8,8");
		
	}
	
	
	@Test
	@DisplayName("Test 18 days pass")
	void multipleDaysPassTest() {
		
		Integer[] spawnDays = {3,4,3,1,2};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.passDays(18);
		assertThat(serviceLanterFish.getSchoolClassSize()).isEqualTo(26);
		
	}
	
	@Test
	@DisplayName("Test 80 days pass")
	void largeNumberOfDaysPassTest() {
		
		Integer[] spawnDays = {3,4,3,1,2};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.passDays(80);
		assertThat(serviceLanterFish.getSchoolClassSize()).isEqualTo(5934);
		
	}
	
	@ParameterizedTest
	@CsvSource(value = {
		"1:2,3,2,0,1",
		"2:1,2,1,6,0,8",
		"3:0,1,0,5,6,7,8",
		"4:6,0,6,4,5,6,7,8,8",
		"5:5,6,5,3,4,5,6,7,7,8",
		"6:4,5,4,2,3,4,5,6,6,7",
		"7:3,4,3,1,2,3,4,5,5,6",
		"8:2,3,2,0,1,2,3,4,4,5",
		"9:1,2,1,6,0,1,2,3,3,4,8",
		"10:0,1,0,5,6,0,1,2,2,3,7,8",
		"11:6,0,6,4,5,6,0,1,1,2,6,7,8,8,8",
		"12:5,6,5,3,4,5,6,0,0,1,5,6,7,7,7,8,8",
		"13:4,5,4,2,3,4,5,6,6,0,4,5,6,6,6,7,7,8,8",
		"14:3,4,3,1,2,3,4,5,5,6,3,4,5,5,5,6,6,7,7,8",
		"15:2,3,2,0,1,2,3,4,4,5,2,3,4,4,4,5,5,6,6,7",
		"16:1,2,1,6,0,1,2,3,3,4,1,2,3,3,3,4,4,5,5,6,8",
		"17:0,1,0,5,6,0,1,2,2,3,0,1,2,2,2,3,3,4,4,5,7,8",
		"18:6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8"
	}, delimiterString=":")
	void daysPassTest(int numberOfDaysToPass, String expectedResult) {
		
		Integer[] spawnDays = {3,4,3,1,2};
		serviceLanterFish.createClass(spawnDays);
		serviceLanterFish.passDays(numberOfDaysToPass);
		assertThat(serviceLanterFish.getClassAsString()).isEqualTo(expectedResult);
		
	}
	
}
