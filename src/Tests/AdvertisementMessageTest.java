
package Tests;

import ObjectsAndClasses.AdvertisementMessage.AdvertisementMessageGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdvertisementMessageGeneratorTest {

    @Test
    public void testGenerateMessages() {
        AdvertisementMessageGenerator generator =
                new AdvertisementMessageGenerator(
                        new String[]{"Excellent product."},
                        new String[]{"Now I feel good."},
                        new String[]{"Diana"},
                        new String[]{"Sofia"}
                );

        String[] messages = generator.generateMessages(1);
        Assert.assertNotNull("Messages array should not be null", messages);
        Assert.assertEquals("There should be 1 message", 1, messages.length);
        Assert.assertNotNull("Generated message should not be null", messages[0]);
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        Assertions.assertEquals(normalizedExpected, normalizedActual);
    }

}


