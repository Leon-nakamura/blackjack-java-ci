package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class BlackJackTest {

    @Test
    public void testScoreCalculation_Normal() {
        assertEquals(18, BlackJackLogic.calculateScore(Arrays.asList("H10", "S8")));
    }

    @Test
    public void testScoreCalculation_AceAdjusted() {
        // A, K, Q は 21点 (11+10+10 = 31 -> Aを1に変更して 21)
        assertEquals(21, BlackJackLogic.calculateScore(Arrays.asList("HA", "SK", "SQ")));
    }

    @Test
    public void testDeckGeneration() {
        assertEquals(52, BlackJackLogic.createDeck().size());
    }
}
