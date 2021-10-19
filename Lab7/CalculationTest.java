package Lab7;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTest {

    @Test
    public void findMax() {
        int[] arr = new int[] {1, 2, 3, 4};
        assertEquals(4, Calculation.findMax(arr));
    }

    @Test
    public void cube() {
        assertEquals(27, Calculation.cube(3));
    }

    @Test
    public void reverseWord() {
    }
}