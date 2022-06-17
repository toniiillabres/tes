package JavaTesting.TreballAmbClasses;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WorkWithClasses {

    @Test
    public void WorkWithClassesTest(){
        Integer vuit = new Integer(8);
        Integer vint = new Integer(20);
        Integer treze = 13;
        int esperat = 13;

        assertEquals("El nombre treze val realment 13", esperat, treze.intValue());

        assertEquals("El nombre vint val realment 20", 20, vint.intValue());
    }

    @Test
    public void WorkWithClassesComp(){
        Integer vuit = new Integer(8);
        Integer eight = new Integer(8);

        assertEquals("El nombre vuit val realment 8", 8, vuit.intValue());

        assertEquals("El nombre eight val realment 8", 8, eight.intValue());

        // No funciona perquè està comparant si es tracta de la mateixa instància de l'objecte.
        // assertTrue(vuit == eight);

        assertTrue(vuit.equals(eight));
    }

    @Test
    public void WorkWithClassesBinaryTest(){
        Integer dos = new Integer(2);
        Integer vint = new Integer(20);
        Integer treze = 13;

        String tipusPersones = "Hi ha "+Integer.toBinaryString(dos)+" de persones que entenen el binari i el que NO";

        assertEquals(tipusPersones, 2, dos.intValue());

        // assertEquals("El nombre vint val realment 20", 20, vint.intValue());
    }

    @Test
    public void WorkWithClassesMinValue(){
        int minim = -2147483648;

        assertEquals("El valor minim d'un int es -2147483648", minim, Integer.MIN_VALUE);

        // assertEquals("El nombre vint val realment 20", 20, vint.intValue());
    }
}
