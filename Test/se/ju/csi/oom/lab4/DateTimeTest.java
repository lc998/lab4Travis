package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before public void setUp() throws Exception {
	}

	@Test public void testToString() {
		DateTime dtString = new DateTime(2018, 2, 31, 10, 0, 0);
		
		assertEquals("2018-02-31 10:00", dtString.toString());
	}

	@Test public void testDateTimeString() {
		DateTime dtString = new DateTime(2018, 2, 31, 10, 0, 0);
		DateTime dtString2 = new DateTime("2018-02-31 10:00");

		assertEquals(dtString2, dtString);
		
	}

}
