package Tests;

import AssociativeArrays.LegendaryFarming;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedHashMap;
import java.util.List;

public class LegendaryFarmingTest {

    @Test
    public void testGetObtainedLegendaryItem() {
        LinkedHashMap<String, Integer> itemsList = new LinkedHashMap<>();
        itemsList.put("shards", 0);
        itemsList.put("fragments", 0);
        itemsList.put("motes", 0);
        itemsList.put("foo", 100);

        List<String> obtainedLegendaryItem = LegendaryFarming.getObtainedLegendaryItem(itemsList);
        Assertions.assertTrue(obtainedLegendaryItem.isEmpty(), "No legendary item should be obtained yet");

        itemsList.put("shards", 250);
        obtainedLegendaryItem = LegendaryFarming.getObtainedLegendaryItem(itemsList);
        Assertions.assertEquals(1, obtainedLegendaryItem.size(), "Should obtain Shadowmourne");
        Assertions.assertEquals("Shadowmourne", obtainedLegendaryItem.get(0), "Should obtain Shadowmourne");

        itemsList.put("fragments", 250);
        obtainedLegendaryItem = LegendaryFarming.getObtainedLegendaryItem(itemsList);
        Assertions.assertEquals(2, obtainedLegendaryItem.size(), "Should obtain Valanyr and Shadowmourne");
        Assertions.assertTrue(obtainedLegendaryItem.contains("Valanyr"), "Should obtain Valanyr");
        Assertions.assertTrue(obtainedLegendaryItem.contains("Shadowmourne"), "Should obtain Shadowmourne");

        itemsList.put("motes", 250);
        obtainedLegendaryItem = LegendaryFarming.getObtainedLegendaryItem(itemsList);
        Assertions.assertEquals(3, obtainedLegendaryItem.size(), "Should obtain Dragonwrath, Valanyr, and Shadowmourne");
        Assertions.assertTrue(obtainedLegendaryItem.contains("Dragonwrath"), "Should obtain Dragonwrath");
        Assertions.assertTrue(obtainedLegendaryItem.contains("Valanyr"), "Should obtain Valanyr");
        Assertions.assertTrue(obtainedLegendaryItem.contains("Shadowmourne"), "Should obtain Shadowmourne");
    }
}




/*
public class LegendaryFarmingTest {

    private InputStream sysInBackup;

    @Before
    public void setUpStreams() {
        sysInBackup = System.in;
    }

    @After
    public void restoreStreams() {
        System.setIn(sysInBackup);
    }

    @Test
    public void testLegendaryFarming1() {
        String input = "3 Motes 5 stones 5 Shards\n6 leathers 255 fragments 7 Shards\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LegendaryFarming lf = new LegendaryFarming();
        lf.playGame();
        assertEquals("Valanyr obtained!\nshards: 5\nfragments: 5\nmotes: 3\nstones: 5\nleathers: 6\n", lf.getGameResult());
    }

    @Test
    public void testLegendaryFarming2() {
        String input = "123 silver 6 shards 8 shards 5 motes\n9 fangs 75 motes 103 MOTES 8 Shards\n86 Motes 7 stones 19 silver\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LegendaryFarming lf = new LegendaryFarming();
        lf.playGame();
        assertEquals("Dragonwrath obtained!\nshards: 22\nfragments: 0\nmotes: 19\nsilver: 123\nfangs: 9\n", lf.getGameResult());
    }

}
*/

