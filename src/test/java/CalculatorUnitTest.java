import com.epam.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Test Calculator methods")
class CalculatorUnitTest {

    static Calculator calculator;

    @BeforeAll
    public static void prepTest() {
        calculator = new Calculator();
    }

    @DisplayName("Test sum of two numbers by long type")
    @ParameterizedTest(name = ("{0}+{1}={2}"))
    @CsvSource({
            "-30, 30, 0",
            "-30, -15, -45",
            "10, 0, 10",
            "30, 15, 45",
            "100, -30, 70"
    })
    void testSumByLongType(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @DisplayName("Test sum of two numbers by double type")
    @ParameterizedTest(name = "{0}+{1}={2}")
    @CsvSource({
            "-16.34, 8.2, -8.14",
            "-33.75, -16.34, -50.09",
            "10, 0, 10",
            "8.2, 15.8, 24.0",
            "30.72, 100.470, 131.19"
    })
    void testSumByDoubleType(double a, double b, double expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @DisplayName("Test subtraction of two numbers by long type")
    @ParameterizedTest(name = "{0}-{1}={2}")
    @CsvSource({
            "-30, 30, -60",
            "-30, -15, -15",
            "10, 0, 10",
            "30, -15, 45",
            "100, -30, 130"
    })
    void testSubByLongType(long a, long b, long expected) {
        assertEquals(expected, calculator.sub(a, b));
    }


    @DisplayName("Test subtraction of two numbers by double type")
    @ParameterizedTest(name = "{0}-{1}={2}")
    @CsvSource({
            "-16.34, 8.2, -24.54",
            "-33.75, -16.34, -17.41",
            "10, 0, 10",
            "8.2, 15.2, -7.0",
            "30.72, 100.470, -69.75"
    })
    void testSubByDoubleType(double a, double b, double expected) {
        assertEquals(expected, calculator.sub(a, b));
    }

    @DisplayName("Test multiplication of two numbers by long type")
    @ParameterizedTest(name = "{0}*{1}={2}")
    @CsvSource({
            "-30, 30, -900",
            "-10, -15, 150",
            "10, 0, 0",
            "30, -5, -150",
            "10, -30, -300"
    })
    void testMultByLongType(long a, long b, long expected) {
        assertEquals(expected, calculator.mult(a, b));
    }

    @DisplayName("Test multiplication of two numbers by double type")
    @ParameterizedTest(name = "{0}*{1}={2}")
    @CsvSource({
            "-16.34, 8.2, -134.0",
            "-33.75, -16.34, 551.0",
            "10, 0, 0",
            "8.2, 9.4, 77.0",
            "30.72, 100.470, 3086.0"
    })
    void testMultByDoubleType(double a, double b, double expected) {
        assertEquals(expected, calculator.mult(a, b));
    }

    @DisplayName("Test division of two numbers by long type")
    @ParameterizedTest(name = "{0}/{1}={2}")
    @CsvSource({
            "-30, 30, -1",
            "-15, -15, 1",
            "30, -5, -6",
            "30, -10, -3"
    })
    void testDivByLongType(long a, long b, long expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    @DisplayName("Test division of two numbers by double type")
    @ParameterizedTest(name = "{0}/{1}={2}")
    @CsvSource({
            "-16.48, 8.24, -2.0",
            "-65.36, -16.34, 4.0",
            "9.4, 9.4, 1",
            "1.0, 2.0, 0.5"
    })
    void testDivByDoubleType(double a, double b, double expected) {
        assertEquals(expected, calculator.div(a, b));
    }

    @Test
    @DisplayName("Test division by zero")
    void testDivByZero() {
        assertThrows(NumberFormatException.class, () -> calculator.div(10, 0));
    }

    @DisplayName("Test number raised to the power of the second argument")
    @ParameterizedTest(name = "{0}^{1}={2}")
    @CsvSource({
            "-3.0, 6.6, 729",
            "-15, 1, -15",
            "2, -5, 0.03125",
            "6, 0.5, 1.0",
            "8, 0, 1"
    })
    void testPow(double a, double b, double expected) {
        assertEquals(expected, calculator.pow(a, b));
    }

    @DisplayName("Test square root of a double value")
    @ParameterizedTest(name = "sqrt({1})={0}")
    @CsvSource({
            "0, 0",
            "12, 144",
            "15, 225",
            "18, 324",
            "20, 400"
    })
    void testSqrt(int expected, int input) {
        assertEquals(expected, calculator.sqrt(input));
    }

    @DisplayName("Test sin of an angle")
    @ParameterizedTest(name = "sin({0})=0")
    @ValueSource(doubles = { 0, Math.PI, 2 * Math.PI })
    void testSin(double input) {
        assertEquals(0, Math.round(calculator.sin(input)));
    }

    @DisplayName("Test cos of an angle")
    @ParameterizedTest(name = "cos({0})=1")
    @ValueSource(doubles = { 0, 2 * Math.PI })
    void testCos(double input) {
        assertEquals(1, calculator.cos(input));
    }

    @DisplayName("Test tg of an angle")
    @ParameterizedTest(name = "tg({0})=0")
    @ValueSource(doubles = { 0, Math.PI, 2 * Math.PI })
    void testTg(double input) {
        assertEquals(0, Math.round(calculator.tg(input)));
    }

    @DisplayName("Test ctg of an angle")
    @ParameterizedTest(name = "ctg({0})=0")
    @ValueSource(doubles = { Math.PI / 4, 5 * Math.PI / 4 })
    void testCtg(double input) {
        assertEquals(1, Math.round(calculator.ctg(input)));
    }

    @DisplayName("Test positive value")
    @ParameterizedTest(name = "{0}")
    @ValueSource(longs = {1L, 42L, 8690L, 6273L, 35636L, Long.MAX_VALUE})
    void testPositiveValue(long value) {
        assertTrue(calculator.isPositive(value));
    }

    @DisplayName("Test negative value")
    @ParameterizedTest(name = "{0}")
    @ValueSource(longs = {-1L, -42L, -8690L, -6273L, -35636L, Long.MIN_VALUE})
    void testNegativeValue(long value) {
        assertFalse(calculator.isPositive(value));
    }

}
