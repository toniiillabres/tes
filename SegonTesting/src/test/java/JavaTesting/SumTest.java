package JavaTesting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {

    @Test
    public void SumTest(){
        int r = 1 + 1;

        assertEquals("Esteim comporvant que 1 + 1 és 2",2,r);
    }
}
