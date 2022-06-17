package JavaTesting.CollectionsTesting;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SimpleCollectionTest {

    @Test
    public void firstCollectionTest(){
        String[] nombres = {"zero","un","dos","tres"};

        List<String> numerals = new ArrayList<>();

        for (String n : nombres){
            numerals.add(n);
        }

        numerals.add("quatre");

        assertTrue(numerals.size() == 5);

        List<String> LlistaNumerals = Arrays.asList(nombres);

        //LlistaNumerals.add("quatre");

        assertTrue(LlistaNumerals.size() == 4);
    }

    @Test
    public void diesSetmana(){
        List<String> diesSetmana = new ArrayList<>();
        List<String> diesFeiners = new ArrayList<>();
        List<String> diesCapDeSetmana = new ArrayList<>();
        List<String> calculDies = new ArrayList<>();

        initDiesFeiners(diesFeiners);

        assertTrue(diesFeiners.size() == 5);

        assertEquals(0,diesSetmana.size());
        assertFalse(diesSetmana.containsAll(diesFeiners));

        // Dies feiners

        diesSetmana.addAll(diesFeiners);

        assertEquals(5,diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesFeiners));

        // Dies cap de setmana

        diesCapDeSetmana.add("Dissabte");
        diesCapDeSetmana.add("Diumenge");

        diesSetmana.addAll(diesCapDeSetmana);

        assertEquals(7,diesSetmana.size());
        assertTrue(diesSetmana.containsAll(diesCapDeSetmana));

        // Dies senars

        List<String> diesSenars = new ArrayList<>();

        diesSenars.addAll(diesSetmana);

        assertTrue(diesSenars.contains("Dimarts"));

        diesSenars.remove(1);

        assertFalse(diesSenars.contains("Dimarts"));

        diesSenars.remove("Dijous");

        assertFalse(diesSenars.contains("Dijous"));

        // Dies feiners senars

        List<String> diesFeinersSenars = new ArrayList<>();

        diesFeinersSenars.addAll(diesSenars);

        diesFeinersSenars.removeAll(diesCapDeSetmana);

        assertEquals(3,diesFeinersSenars.size());

        assertFalse(diesFeinersSenars.contains("Dissabte"));

        calculDies.addAll(diesSetmana);

        calculDies.clear();

        assertTrue(calculDies.isEmpty());

        calculDies.addAll(diesSetmana);

        calculDies.removeAll(diesCapDeSetmana);

        assertEquals(5,calculDies.size());
    }

    public void initDiesFeiners(List<String> dies){
        dies.add("Dilluns");
        dies.add("Dimarts");
        dies.add("Dimecres");
        dies.add("Dijous");
        dies.add("Divendres");
    }

    @Test
    public void provesAmbMapTest(){
        Map<String,String> map = new HashMap<>();

        map.put("fons","negre");
        map.put("menus","blau");
        map.put("dialeg","verd");

        assertEquals(map.size(),3);

        assertTrue(map.containsKey("menus"));
        assertTrue(map.containsValue("negre"));

        map.remove("dialeg");

        assertEquals(map.size(),2);

        assertEquals(map.get("fons"),"negre");
    }

    @Test
    public void provaSetTest(){
        Set<String> dies = new HashSet<>();

        dies.add("Dilluns");
        dies.add("Dilluns");
        dies.add("Dilluns");

        assertEquals(dies.size(),1);
    }
}
