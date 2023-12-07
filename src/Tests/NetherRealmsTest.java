package Tests;

import RegularExpressions.NetherRealms;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import java.util.List;

public class NetherRealmsTest {

    @Test
    public void testExtractDemonData_InputM3ph_0_5s_0_5t0_0_ReturnsDemonData() {
        String input = "M3ph-0.5s-0.5t0.0**";
        String expectedOutput = "M3ph-0.5s-0.5t0.0** - 524 health, 8.00 damage";

        List<NetherRealms.Demon> demons = NetherRealms.extractDemonData(input);
        String actualOutput = demons.get(0).toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExtractDemonData_InputM3ph1st0__Azazel_ReturnsDemonData() {
        String input = "M3ph1st0**, Azazel";
        String expectedOutput = "M3ph1st0** - 524 health, 16.00 damage\nAzazel - 615 health, 0.00 damage";

        List<NetherRealms.Demon> demons = NetherRealms.extractDemonData(input);
        String actualOutput = demons.get(0).toString() + "\n" + demons.get(1).toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExtractDemonData_InputGos_ho_ReturnsDemonData() {
        String input = "Gos/ho";
        String expectedOutput = "Gos/ho - 512 health, 0.00 damage";

        List<NetherRealms.Demon> demons = NetherRealms.extractDemonData(input);
        String actualOutput = demons.get(0).toString();

        assertEquals(expectedOutput, actualOutput);
    }
}
