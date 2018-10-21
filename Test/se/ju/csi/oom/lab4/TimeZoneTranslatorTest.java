package se.ju.csi.oom.lab4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before public void setUp() throws Exception {
	}

	@Test public void testShiftTimeZone() {

		/* DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0, 0); DateTime LectureEnd = new DateTime(2018, 8, 27, 9, 45, 0); Person johannes =
		 * new Person("Johannes Schmidt"); Person ragnar = new Person("Ragnar Nohre"); Place HC218 = new Place("Hc218",57.7785672,14.1614833,20.0);
		 * 
		 * Event firstOomLecture = new Event("OOM 2018 Lecture 1", LectureStart, LectureEnd, new HashSet<>(Arrays.asList(johannes, ragnar)),
		 * HC218); */

		/* test to string */
		//int year = 2018, month = 2, day = 31, hour = 10, minute = 10, second = 59;
		DateTime dtString = new DateTime(2018, 2, 31, 10, 0, 0);

		//		%04d-%02d-%02d %02d:%02d:%02d
		assertEquals("2018-02-31 10:00:00", dtString.toString());

		//varje månad är 31 dagar i detta program.
		DateTime dt = new DateTime(2018, 05, 15, 11, 0, 10);

		//		%04d-%02d-%02d %02d:%02d:%02d
		assertEquals("2018-05-15 11:00:10", dt.toString());

		/* Start test */
		//vanliga byten av tidszon framåt utan byte
		dt = TimeZoneTranslator.shiftTimeZone(dt, 0, 1);
		assertEquals("2018-05-15 12:00:10", dt.toString());

		/* Test 2 next day change timezone */
		DateTime dtND = new DateTime(2018, 2, 30, 23, 0, 0);
		dtND = TimeZoneTranslator.shiftTimeZone(dtND, 0, 1);

		assertEquals("2018-02-31 00:00:00", dtND.toString());

		/* Test 3 next month change timezone */
		DateTime dtNM = new DateTime(2018, 2, 31, 23, 0, 0);
		dtNM = TimeZoneTranslator.shiftTimeZone(dtNM, 0, 1);

		assertEquals("2018-03-01 00:00:00", dtNM.toString());

		/* Test 4 next year change timezone */
		DateTime dtNY = new DateTime(2017, 12, 31, 23, 0, 0);
		dtNY = TimeZoneTranslator.shiftTimeZone(dtNY, 0, 1);

		assertEquals("2018-01-01 00:00:00", dtNY.toString());

		/* Test 5 day before change timezone */
		DateTime dtDB = new DateTime(2018, 2, 30, 0, 0, 0);
		dtDB = TimeZoneTranslator.shiftTimeZone(dtDB, 0, -1);

		assertEquals("2018-02-29 23:00:00", dtDB.toString());

		/* Test 6 moth before change timezone */
		DateTime dtMB = new DateTime(2018, 3, 1, 0, 0, 0);
		dtMB = TimeZoneTranslator.shiftTimeZone(dtMB, 0, -1);

		assertEquals("2018-02-31 23:00:00", dtMB.toString());

		/* Test 7 year before change timezone */
		DateTime dtYB = new DateTime(2018, 1, 1, 0, 0, 0);
		dtYB = TimeZoneTranslator.shiftTimeZone(dtYB, 0, -1);

		assertEquals("2017-12-31 23:00:00", dtYB.toString());

		/* Back in time extreme: change on year date and time */
		DateTime dt3 = new DateTime(2016, 1, 1, 6, 0, 0);

		dt3 = TimeZoneTranslator.shiftTimeZone(dt3, 1, -8);
		assertEquals("2015-12-31 21:00:00", dt3.toString());

	}

	@Test public void testShiftEventTimeZone() {
		String startDate = "2018-02-05 05:10:20";
		String endDate = "2018-02-20 05:10:20";

		int year = 2018, month = 2, day = 5, hour = 5, minute = 10, second = 20;
		DateTime dt = new DateTime(year, month, day, hour, minute, second);

		int endyear = 2018, endmonth = 2, endday = 20, endhour = 5, endminute = 10, endsecond = 20;
		DateTime dtSlut = new DateTime(endyear, endmonth, endday, endhour, endminute, endsecond);

		Event ev = new Event(null, dt, dtSlut, null, null);

		assertEquals(startDate, ev.getStartDate().toString());
		assertEquals(endDate, ev.getEndDate().toString());

		String newSDate = "2018-02-10 06:12:05";
		DateTime dtStartNew = new DateTime(newSDate);
		ev.setEndDate(dtStartNew);
		assertEquals(newSDate, ev.getEndDate().toString());

		//		TimeZoneTranslator

		//fail("Not yet implemented");
	}

}
