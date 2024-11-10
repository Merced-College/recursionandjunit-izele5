//Izel Escoto
//11.8.24
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveMethodsTest {

    // Test for count8 method
    @Test
    public void testCount8_single8() {
        assertEquals(1, RecursiveMethods.count8(8));
    }

    @Test
    public void testCount8_double8() {
        assertEquals(4, RecursiveMethods.count8(8818));
    }

    @Test
    public void testCount8_no8() {
        assertEquals(0, RecursiveMethods.count8(123));
    }

    // Test for countHi method
    @Test
    public void testCountHi_singleHi() {
        assertEquals(1, RecursiveMethods.countHi("hi"));
    }

    @Test
    public void testCountHi_multipleHi() {
        assertEquals(2, RecursiveMethods.countHi("hihihi"));
    }

    @Test
    public void testCountHi_noHi() {
        assertEquals(0, RecursiveMethods.countHi("hello"));
    }

    // Test for countHi2 method
    @Test
    public void testCountHi2_singleHi() {
        assertEquals(1, RecursiveMethods.countHi2("ahixhi"));
    }
    public class RecursiveMethods {

        // Method to count occurrences of 8, with double counting for consecutive 8s
        public static int count8(int n) {
            if (n == 0) return 0; // Base case: no digits left
            if (n % 10 == 8) {
                // If the current digit is 8 and the next digit is also 8, count it as 2
                if ((n / 10) % 10 == 8) {
                    return 2 + count8(n / 10);
                } else {
                    return 1 + count8(n / 10);
                }
            }
            return count8(n / 10);
        }

        // Method to count occurrences of "hi" in a string
        public static int countHi(String str) {
            if (str.length() < 2) return 0;
            if (str.startsWith("hi")) {
                return 1 + countHi(str.substring(2));
            }
            return countHi(str.substring(1));
        }

        // Method to count occurrences of "hi" in a string, but skip "hi" preceded by 'x'
        public static int countHi2(String str) {
            if (str.length() < 2) return 0;
            if (str.startsWith("hi")) {
                if (str.length() > 2 && str.charAt(0) == 'x') {
                    return countHi2(str.substring(3));
                }
                return 1 + countHi2(str.substring(2));
            }
            return countHi2(str.substring(1));
        }

        // Method to count non-overlapping occurrences of a substring in a string
        public static int strCount(String str, String sub) {
            if (str.length() < sub.length()) return 0;
            if (str.startsWith(sub)) {
                return 1 + strCount(str.substring(sub.length()), sub);
            }
            return strCount(str.substring(1), sub); e
        }

        // Method to clean a string by removing consecutive duplicate characters
        public static String stringClean(String str) {
            if (str.length() < 2) return str;
            if (str.charAt(0) == str.charAt(1)) {
                return stringClean(str.substring(1));
            }
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }