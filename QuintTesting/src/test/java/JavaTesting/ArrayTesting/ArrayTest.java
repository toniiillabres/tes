package JavaTesting.ArrayTesting;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayTest {

    @Test
    public void exempleArraySenzill(){
        String[] numerals = {"Un", "Dos", "Tres", "Quatre"};

        assertEquals("Un",numerals[0]);

        String nombres = "";

        for (String n: numerals){
            nombres += n + "|";
        }

        assertEquals(nombres,"Un|Dos|Tres|Quatre|");
    }

    @Test
    public void provesOrdenacioArray(){
        String[] numerals = {"Un", "Dos", "Tres", "Quatre"};

        Arrays.sort(numerals);

        for (int i=0; i< numerals.length -1; i++){
            assertTrue(numerals[i].compareTo(numerals[i+1]) < 0);
        }
    }

    @Test
    public void farcirArrayPosicionament(){
        int[] nums = {0,1,2,3,4,5,6,7,8,9};

        Arrays.fill(nums,5,10,-1);

        for (int i=5; i< nums.length; i++){
            assertTrue(nums[i] == -1);
        }
    }

    @Test
    public void copiaRangMatriu(){
        String[] dies = {"Dilluns","Dimarts","Dimecres","Dijous","Divendres","Dissabte","Diumenge"};

        String[] feiners = Arrays.copyOfRange(dies,0,5);

        assertTrue(feiners.length == 5);
        assertTrue(feiners[1].equals("Dimarts"));

        String[] feinersEsclaus = Arrays.copyOfRange(feiners,0,7);

        assertTrue(feinersEsclaus[0].equals("Dilluns"));

        assertEquals(feinersEsclaus[5],null);
        assertEquals(feinersEsclaus[6],null);

        feinersEsclaus[5] = "dissabteDeFeina";
        feinersEsclaus[6] = "diaDeDescans";

        assertTrue(feinersEsclaus[6].equals("diaDeDescans"));

    }

    @Test
    public void arraysIrregularsTest(){
        int[][] arraysIrregulars = {{0,1,2,3,4,5},
                {0,1,2,3,4},
                {0,1,2,3},
                {0,1,2},
                {0,1},
                {0}
        };

        assertEquals(arraysIrregulars.length,6);

        assertEquals(arraysIrregulars[0].length,6);

        assertEquals(arraysIrregulars[5].length,1);
    }
}
