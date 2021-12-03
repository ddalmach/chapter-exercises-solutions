package io.dani;

import java.util.*;
import java.util.stream.Collectors;

public class Solutions {

    public static Set<List<Integer>> numberOfCombinationsByGivenDenominations(int desiredChange, List<Integer> coinDenominations) {
        Set<List<Integer>> result = new HashSet<>();
        if(desiredChange == 0){
            List<Integer> emptyMutableList = new ArrayList<>();
            Set<List<Integer>> emptyMutableSetOfLists = new HashSet<>();
            emptyMutableSetOfLists.add(emptyMutableList);
            return emptyMutableSetOfLists;
        }
        //TODO no es necesario retornar null
        if(desiredChange < 0) {
            return null;
        }

        for (Integer coinDenomination: coinDenominations) {
            int remainder = desiredChange - coinDenomination;
            Set<List<Integer>> possibleCombination = numberOfCombinationsByGivenDenominations(remainder, coinDenominations);
            if (possibleCombination != null) {
                possibleCombination = possibleCombination.stream()
                        .map( list -> addCoinDenomination(list, coinDenomination))
                        .collect(Collectors.toSet());

                result.addAll(possibleCombination);
            }
        }
        return result;
    }

    private static List<Integer> addCoinDenomination(List<Integer> list, int coin) {
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(coin);
        Collections.sort(list);
        return list;
    }

}
