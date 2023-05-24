package com.main.sbp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.sbp.service.PopulationSearch;

@SpringBootTest
public class PopulationSearchTest {
	
	@InjectMocks
	private PopulationSearch populationSearch;
	
	@Test
	public void findPopulation () {
		
		String city = "Mumbai";
		int expectedPopulationCount = 800000;
		int count = populationSearch.getPopulation(city);
		assertEquals(expectedPopulationCount, count);
	}
	
	@Test
	public void findPopulationWithEmptyInput () {
		
		Exception exception = assertThrows(NullPointerException.class, () -> {
			String city = "";
			populationSearch.getPopulation(city);
	    });
		
//		String expectedMessage = "Input shouldn't be Empty";
//	    String actualMessage = exception.getMessage();
//
//	    assertTrue(actualMessage.contains(expectedMessage));
	    assertEquals("Input shouldn't be Empty", exception.getMessage());
	}
	
	@Test
	public void findPopulationWithInvalidInput () {
		
		Exception exception = assertThrows(NullPointerException.class, () -> {
			String city = "Abc";
			populationSearch.getPopulation(city);
	    });
		
//		String expectedMessage = "Invalid input";
//	    String actualMessage = exception.getMessage();
//
//	    assertTrue(actualMessage.contains(expectedMessage));
	    assertEquals("Invalid input", exception.getMessage());
	}

}
