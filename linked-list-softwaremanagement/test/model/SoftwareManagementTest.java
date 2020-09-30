package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SoftwareManagementTest {
	private SoftwareManagement sm;
	
	public void setupScenary1() {
	}
	
	public void setupScenary2() {
		sm = new SoftwareManagement();
	}
	
	public void setupScenary3() {
		sm = new SoftwareManagement();
		sm.addSoft("Firefox", "Mozilla Foundation", "GPL");
	}
	
	public void setupScenary4() {
		sm = new SoftwareManagement();
		sm.addSoft("Firefox", "Mozilla Foundation", "MPL");
		sm.addSoft("Eclipse", "Eclipse Foundation", "EPL");
	}
	
	@Test
	public void testSoftwareManagement() {
		setupScenary1();
		sm = new SoftwareManagement();	
		assertNull(sm.getFirstSoft());
	}
	
	@Test
	public void testAddSoftware1() {
		setupScenary2();
		
		String n = "Windows 10";
		String d = "Microsoft";
		String l = "Comercial";
		
		sm.addSoft(n, d, l);
		
		assertNotNull(sm.getFirstSoft());
		
		Software s = sm.getFirstSoft();
		assertEquals(n, s.getName());
		assertEquals(d, s.getDeveloper());
		assertEquals(l, s.getLicense());
		
		assertNull(s.getNextSoft());
	}
	
	@Test
	public void testAddSoftware2() {
		setupScenary3();
		
		String n = "Ubuntu";
		String d = "Canonical";
		String l = "GPL";
		
		sm.addSoft(n, d, l);
		
		assertNotNull(sm.getFirstSoft());
		assertNotNull(sm.getFirstSoft().getNextSoft());
		
		Software s = sm.getFirstSoft().getNextSoft();
		
		assertEquals(n, s.getName());
		assertEquals(d, s.getDeveloper());
		assertEquals(l, s.getLicense());
		
		assertNull(s.getNextSoft());
	}

}
