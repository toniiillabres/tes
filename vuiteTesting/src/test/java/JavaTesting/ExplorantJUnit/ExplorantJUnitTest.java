package JavaTesting.ExplorantJUnit;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class ExplorantJUnitTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test (expected = IllegalArgumentException.class)
    public void IllegalArgumentExceptionTest(){

        throw new IllegalArgumentException();
    }

    @Ignore
    @Test
    public void IllegalParametersTest(){
        expected.expect(IllegalArgumentException.class);

        throw new IllegalArgumentException();
    }

    @Test
    public void MissatgeExcepcioTest(){
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("the");

        throw new IllegalArgumentException("the exception");
    }

    @BeforeClass
    public static void ExecuteBeforeAnyClassTest(){
        System.out.println("Abans d'executar qualsevol test, un cop per classe");
    }

    @AfterClass
    public static void ExecuteAfterAnyClassTest(){
        System.out.println("Després d'executar qualsevol test, un cop per classe");
    }

    @Before
    public void executaBeforeAnyTest(){
        System.out.println("Abans d'executar qualsevol test, un cop per cada test");
    }

    @After
    public void executaAfterAnyTest(){
        System.out.println("Després d'executar qualsevol test, un cop per cada test");
    }

    @Test
    public void assertionsJUnit(){
        assertEquals(5,2+3);

        assertFalse("fals == false",false);
        assertFalse((3 > 5));

        assertTrue((5 > 3));

        int[] finsA10 = {1,2,3,4,5,6,7,8,9,10};
        int[] primers10 = {1,2,3,4,5,6,7,8,9,10};

        Arrays.sort(primers10);

        assertArrayEquals(finsA10, primers10);

        assertNotNull("Un String buit NO es null","");
        assertNotNull("");

        assertNotSame("Un String buit NO es null","",null);
        assertNotSame("",null);

        assertNull("Nomes null es considerat null",null);

        Object obj = null;
        assertSame(obj,null);
    }

    @Test
    public void HancrestAssertion(){

        assertThat(4+5, is(9));
        assertThat("Testejant que 4+5 són 9",4+5, is(9));

        assertThat("fals es fals",false, equalTo(false));
        assertThat(false, is(false));

        assertThat("true es true",true, equalTo(true));
        assertThat(true, is(true));

        assertThat("Un String buit NO es null", is(not(nullValue())));

        assertThat("Aixo es un text", containsString("un"));
        assertThat("Aixo es un text", endsWith("xt"));
        assertThat("Aixo es un text", startsWith("Ai"));
    }
}
