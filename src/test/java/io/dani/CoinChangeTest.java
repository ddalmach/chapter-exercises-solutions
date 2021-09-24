package io.dani;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CoinChangeTest {

    @Test
    void shouldReturn4Combinations(){
        List<Integer> coinDenominations =Arrays.asList(1,2,3);
        int desiredChange = 4;
        Set<List<Integer>> result = Solutions.numberOfCombinationsByGivenDenominations(desiredChange, coinDenominations);
        System.out.println("result = " + result);
        Assertions.assertEquals(4, result.size());
    }

    @Test
    void shouldReturn6Combinations(){
        List<Integer> coinDenominations = Arrays.asList(1,3,5,7);
        int desiredChange = 8;

        Assertions.assertEquals(6, Solutions.numberOfCombinationsByGivenDenominations(desiredChange, coinDenominations).size());
    }
}
