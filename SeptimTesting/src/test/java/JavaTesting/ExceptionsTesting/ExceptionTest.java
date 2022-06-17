package JavaTesting.ExceptionsTesting;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExceptionTest {

    @Test (expected = NullPointerException.class)
    public void NullPointerTest(){
        Integer edat = null;

        String edatEnLletres = edat.toString();

        assertEquals(""+10,edatEnLletres);
    }

    @Test
    public void CatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres;

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
        }

        assertEquals(""+18,edatEnLletres);
    }

    @Test
    public void TryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres="";
        String text;

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
        } finally {
            text = "Edat == "+edatEnLletres;
        }

        assertEquals("Edat == 18",text);
    }

    @Test (expected = IllegalAccessException.class)
    public void ThrowingIllegalArgumentExceptionTryCatchNullPointerTest(){
        Integer edat = null;
        String edatEnLletres = "";

        try {
            System.out.println("Pas 1: generam NullPointerException");
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe) {
            System.out.println("Pas 2: capturam l'excepcio");
            System.out.println("Pas 3: llançam una nova expecion");
            throw new IllegalArgumentException("Excepcio llançada i creada per mi");
        } finally {
            System.out.println("Pas final: codi de tancament");
        }
    }

    @Test (expected = NullPointerException.class)
    public void ExcepcioErronia(){
        Integer edat = null;
        String edatEnLletres = "";

        try {
            System.out.println("Pas 1: generam NullPointerException");
            edatEnLletres = edat.toString();
            throw new IllegalArgumentException("Excepcio creada i llançada per mi");
        } catch (IllegalArgumentException iae) {
            System.out.println("Pas 2: capturam l'excepcio");
        } finally {
            System.out.println("Pas final: codi de tancament");
        }
    }

    @Test
    public void PlayingWithObjectsTest(){
        Integer edat = null;
        String edatEnLletres;

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
            System.out.println("Anem a jugar amb l'objecte expecio");

            System.out.println(npe.getMessage());
            System.out.println(npe.getStackTrace());
            npe.printStackTrace();
        }

        assertEquals(""+18,edatEnLletres);
    }
}
