package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.MaximumCapacityException;

class ElevatorTest {
	private Elevator elev;
	
	public void setupScenary1() {
		elev = new Elevator();
	}
	
	public void setupScenary2() {
		elev = new Elevator();
		try {
			elev.addPerson("Juan", 80);
			elev.addPerson("Pedro", 90);
			elev.addPerson("Diana", 60);
		}catch(MaximumCapacityException mce) {
			
		}
	}

	@Test
	public void testAddPerson_1(){
		setupScenary1();
		String n = "Paola";
		double w = 45;
		
		try {
			elev.addPerson(n, w);
			assertEquals(1, elev.getPeople().size());
			assertEquals(n, elev.getPeople().get(0).getName());			
			assertEquals(w, elev.getPeople().get(0).getWeight());			
		} catch (MaximumCapacityException mce) {
			fail("MaximumCapacityException isn't expected here");
		}
	}
	
	@Test
	public void testAddPerson_2() {
		setupScenary2();
		
		int sizeBefore = elev.getPeople().size();
		
		try {
			elev.addPerson("Pablo", 90);
			fail("MaximumCapacityException is expected");
		}catch (MaximumCapacityException mce) {
			assertEquals(sizeBefore, elev.getPeople().size(),"The person should not be added");
		}
	}

}
