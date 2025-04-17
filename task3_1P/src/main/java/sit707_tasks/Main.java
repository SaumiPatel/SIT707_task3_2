package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

    // Fix failing tests with name and student ID
    @Test
    public void testStudentIdentity() {
        String studentId = "S223979728";
        assertNotNull("Student ID is null", studentId);
        System.out.println("Test: Student Identity\nResult: Student ID = " + studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Saumil Patel";
        assertNotNull("Student name is null", studentName);
        System.out.println("Test: Student Name\nResult: Student Name = " + studentName);
    }

    // === Constructor Tests ===
    @Test
    public void testConstructorValidDate() {
        System.out.println("Test: Constructing valid date 15 June 2020");
        DateUtil date = new DateUtil(15, 6, 2020);
        assertEquals(15, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMinDay() {
        System.out.println("Test: Constructing valid date with min day 1 Jan 2020");
        DateUtil date = new DateUtil(1, 1, 2020);
        assertEquals(1, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMaxDayJanuary() {
        System.out.println("Test: Constructing valid date with max day 31 Jan 2020");
        DateUtil date = new DateUtil(31, 1, 2020);
        assertEquals(31, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMinMonth() {
        System.out.println("Test: Constructing valid date with min month 15 Jan 2020");
        DateUtil date = new DateUtil(15, 1, 2020);
        assertEquals(15, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMaxMonth() {
        System.out.println("Test: Constructing valid date with max month 15 Dec 2020");
        DateUtil date = new DateUtil(15, 12, 2020);
        assertEquals(15, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMinYear() {
        System.out.println("Test: Constructing valid date with min year 15 June 1700");
        DateUtil date = new DateUtil(15, 6, 1700);
        assertEquals(15, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1700, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidMaxYear() {
        System.out.println("Test: Constructing valid date with max year 15 June 2024");
        DateUtil date = new DateUtil(15, 6, 2024);
        assertEquals(15, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2024, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidFeb29LeapYear() {
        System.out.println("Test: Constructing valid 29 Feb 2020 (leap year)");
        DateUtil date = new DateUtil(29, 2, 2020);
        assertEquals(29, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValidFeb28NonLeapYear() {
        System.out.println("Test: Constructing valid 28 Feb 2021 (non-leap year)");
        DateUtil date = new DateUtil(28, 2, 2021);
        assertEquals(28, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(2021, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorValid30DayMonth() {
        System.out.println("Test: Constructing valid 30 April 2020");
        DateUtil date = new DateUtil(30, 4, 2020);
        assertEquals(30, date.getDay());
        assertEquals(4, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testConstructorInvalidDayZero() {
        System.out.println("Test: Constructing with invalid day 0 (0 Jan 2020)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(0, 1, 2020);
            fail("Expected RuntimeException for day 0");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 0, expected range 1-31", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidDay32() {
        System.out.println("Test: Constructing with invalid day 32 (32 Jan 2020)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(32, 1, 2020);
            fail("Expected RuntimeException for day 32");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 32, expected range 1-31", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidMonthZero() {
        System.out.println("Test: Constructing with invalid month 0 (1 Month-0 2020)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(1, 0, 2020);
            fail("Expected RuntimeException for month 0");
        } catch (RuntimeException e) {
            assertEquals("Invalid month: 0, expected range 1-12", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidMonth13() {
        System.out.println("Test: Constructing with invalid month 13 (1 Month-13 2020)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(1, 13, 2020);
            fail("Expected RuntimeException for month 13");
        } catch (RuntimeException e) {
            assertEquals("Invalid month: 13, expected range 1-12", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidYear1699() {
        System.out.println("Test: Constructing with invalid year 1699 (1 Jan 1699)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(1, 1, 1699);
            fail("Expected RuntimeException for year 1699");
        } catch (RuntimeException e) {
            assertEquals("Invalid year: 1699, expected range 1700-2024", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidYear2025() {
        System.out.println("Test: Constructing with invalid year 2025 (1 Jan 2025)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(1, 1, 2025);
            fail("Expected RuntimeException for year 2025");
        } catch (RuntimeException e) {
            assertEquals("Invalid year: 2025, expected range 1700-2024", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidFeb29NonLeapYear() {
        System.out.println("Test: Constructing invalid 29 Feb 2021 (non-leap year)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(29, 2, 2021);
            fail("Expected RuntimeException for 29 Feb 2021");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 29, max day: 28", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidDay31April() {
        System.out.println("Test: Constructing invalid 31 April 2020");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 4, 2020);
            fail("Expected RuntimeException for 31 April");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidDay31June1994() {
        System.out.println("Test: Constructing invalid 31 June 1994 (table case 5A/5B)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 6, 1994);
            fail("Expected RuntimeException for 31 June 1994");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidDay31September() {
        System.out.println("Test: Constructing invalid 31 September 2020");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 9, 2020);
            fail("Expected RuntimeException for 31 September");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorInvalidDay31November() {
        System.out.println("Test: Constructing invalid 31 November 2020");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 11, 2020);
            fail("Expected RuntimeException for 31 November");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    // === Previous Date Tests (Decrement) ===
    @Test
    public void testPreviousDate_1A_1June1994() {
        System.out.println("Test 1A: Decrement 1 June 1994, expect 31 May 1994");
        DateUtil date = new DateUtil(1, 6, 1994);
        date.decrement();
        assertEquals(31, date.getDay());
        assertEquals(5, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_2A_2June1994() {
        System.out.println("Test 2A: Decrement 2 June 1994, expect 1 June 1994");
        DateUtil date = new DateUtil(2, 6, 1994);
        date.decrement();
        assertEquals(1, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_3A_15June1994() {
        System.out.println("Test 3A: Decrement 15 June 1994, expect 14 June 1994");
        DateUtil date = new DateUtil(15, 6, 1994);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_4A_30June1994() {
        System.out.println("Test 4A: Decrement 30 June 1994, expect 29 June 1994");
        DateUtil date = new DateUtil(30, 6, 1994);
        date.decrement();
        assertEquals(29, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_5A_31June1994_Invalid() {
        System.out.println("Test 5A: Constructing invalid 31 June 1994");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 6, 1994);
            fail("Expected RuntimeException for 31 June");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testPreviousDate_6A_15Jan1994() {
        System.out.println("Test 6A: Decrement 15 Jan 1994, expect 14 Jan 1994");
        DateUtil date = new DateUtil(15, 1, 1994);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_7A_15Feb1994() {
        System.out.println("Test 7A: Decrement 15 Feb 1994, expect 14 Feb 1994");
        DateUtil date = new DateUtil(15, 2, 1994);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_8A_15Nov1994() {
        System.out.println("Test 8A: Decrement 15 Nov 1994, expect 14 Nov 1994");
        DateUtil date = new DateUtil(15, 11, 1994);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(11, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_9A_15Dec1994() {
        System.out.println("Test 9A: Decrement 15 Dec 1994, expect 14 Dec 1994");
        DateUtil date = new DateUtil(15, 12, 1994);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_10A_15June1700() {
        System.out.println("Test 10A: Decrement 15 June 1700, expect 14 June 1700");
        DateUtil date = new DateUtil(15, 6, 1700);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1700, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_11A_15June1701() {
        System.out.println("Test 11A: Decrement 15 June 1701, expect 14 June 1701");
        DateUtil date = new DateUtil(15, 6, 1701);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1701, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_12A_15June2023() {
        System.out.println("Test 12A: Decrement 15 June 2023, expect 14 June 2023");
        DateUtil date = new DateUtil(15, 6, 2023);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2023, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testPreviousDate_13A_15June2024() {
        System.out.println("Test 13A: Decrement 15 June 2024, expect 14 June 2024");
        DateUtil date = new DateUtil(15, 6, 2024);
        date.decrement();
        assertEquals(14, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2024, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    // === Next Date Tests (Increment) ===
    @Test
    public void testNextDate_1B_1June1994() {
        System.out.println("Test 1B: Increment 1 June 1994, expect 2 June 1994");
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        assertEquals(2, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_2B_2June1994() {
        System.out.println("Test 2B: Increment 2 June 1994, expect 3 June 1994");
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        assertEquals(3, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_3B_15June1994() {
        System.out.println("Test 3B: Increment 15 June 1994, expect 16 June 1994");
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_4B_30June1994() {
        System.out.println("Test 4B: Increment 30 June 1994, expect 1 July 1994");
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        assertEquals(1, date.getDay());
        assertEquals(7, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_5B_31June1994_Invalid() {
        System.out.println("Test 5B: Constructing invalid 31 June 1994");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(31, 6, 1994);
            fail("Expected RuntimeException for 31 June");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 31, max day: 30", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testNextDate_6B_15Jan1994() {
        System.out.println("Test 6B: Increment 15 Jan 1994, expect 16 Jan 1994");
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_7B_15Feb1994() {
        System.out.println("Test 7B: Increment 15 Feb 1994, expect 16 Feb 1994");
        DateUtil date = new DateUtil(15, 2, 1994);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_8B_15Nov1994() {
        System.out.println("Test 8B: Increment 15 Nov 1994, expect 16 Nov 1994");
        DateUtil date = new DateUtil(15, 11, 1994);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(11, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_9B_15Dec1994() {
        System.out.println("Test 9B: Increment 15 Dec 1994, expect 16 Dec 1994");
        DateUtil date = new DateUtil(15, 12, 1994);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(12, date.getMonth());
        assertEquals(1994, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_10B_15June1700() {
        System.out.println("Test 10B: Increment 15 June 1700, expect 16 June 1700");
        DateUtil date = new DateUtil(15, 6, 1700);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1700, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_11B_15June1701() {
        System.out.println("Test 11B: Increment 15 June 1701, expect 16 June 1701");
        DateUtil date = new DateUtil(15, 6, 1701);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(1701, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_12B_15June2023() {
        System.out.println("Test 12B: Increment 15 June 2023, expect 16 June 2023");
        DateUtil date = new DateUtil(15, 6, 2023);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2023, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testNextDate_13B_15June2024() {
        System.out.println("Test 13B: Increment 15 June 2024, expect 16 June 2024");
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        assertEquals(16, date.getDay());
        assertEquals(6, date.getMonth());
        assertEquals(2024, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    // === Extra Tests for February Leap Year ===
    @Test
    public void testFebruaryLeapYear_28Feb2020() {
        System.out.println("Test: Increment 28 Feb 2020 (leap year), expect 29 Feb 2020");
        DateUtil date = new DateUtil(28, 2, 2020);
        date.increment();
        assertEquals(29, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testFebruaryLeapYear_29Feb2020() {
        System.out.println("Test: Increment 29 Feb 2020 (leap year), expect 1 March 2020");
        DateUtil date = new DateUtil(29, 2, 2020);
        date.increment();
        assertEquals(1, date.getDay());
        assertEquals(3, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testFebruaryLeapYear_Decrement1March2020() {
        System.out.println("Test: Decrement 1 March 2020 (leap year), expect 29 Feb 2020");
        DateUtil date = new DateUtil(1, 3, 2020);
        date.decrement();
        assertEquals(29, date.getDay());
        assertEquals(2, date.getMonth());
        assertEquals(2020, date.getYear());
        System.out.println("Result: Success - Date: " + date);
    }

    @Test
    public void testFebruaryNonLeapYear_29Feb2021_Invalid() {
        System.out.println("Test: Constructing invalid 29 Feb 2021 (non-leap year)");
        try {
            System.out.println("Attempting to create date...");
            new DateUtil(29, 2, 2021);
            fail("Expected RuntimeException for 29 Feb 2021");
        } catch (RuntimeException e) {
            assertEquals("Invalid day: 29, max day: 28", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    // === Boundary Tests for Year Edges ===
    @Test
    public void testDecrementBelow1700() {
        System.out.println("Test: Decrement 1 Jan 1700, expect exception");
        DateUtil date = new DateUtil(1, 1, 1700);
        try {
            System.out.println("Attempting to decrement...");
            date.decrement();
            fail("Expected RuntimeException for decrement below 1700");
        } catch (RuntimeException e) {
            assertEquals("Cannot decrement below 1 January 1700", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }

    @Test
    public void testIncrementBeyond2024() {
        System.out.println("Test: Increment 31 Dec 2024, expect exception");
        DateUtil date = new DateUtil(31, 12, 2024);
        try {
            System.out.println("Attempting to increment...");
            date.increment();
            fail("Expected RuntimeException for increment beyond 2024");
        } catch (RuntimeException e) {
            assertEquals("Cannot increment beyond 31 December 2024", e.getMessage());
            System.out.println("Result: Caught expected error: " + e.getMessage());
        }
    }
}