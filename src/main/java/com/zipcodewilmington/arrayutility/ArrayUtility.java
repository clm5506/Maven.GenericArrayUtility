package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] removeValue(T valueToRemove) {

        List<T> list = Stream.of(inputArray).filter(t -> !t.equals(valueToRemove)).collect(Collectors.toList());
        T[] answer = (T[]) Array.newInstance(inputArray.getClass().getComponentType(), list.size());

        return list.toArray(answer);
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {

        List<T> newList = new ArrayList<>(Arrays.asList(inputArray));
        newList.addAll(Arrays.asList(arrayToMerge));

        return Collections.frequency(newList,valueToEvaluate);

    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        List<T> newList = new ArrayList<>(Arrays.asList(inputArray));

        return Collections.frequency(newList,valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {

        List<T> newList = new ArrayList<>(Arrays.asList(inputArray));
        newList.addAll(Arrays.asList(arrayToMerge));

        T mostCommon = newList.get(0);
        int count = 0;

        for(int i = 0; i < newList.size(); i++){
           if(Collections.frequency(newList,newList.get(i)) > count){
               mostCommon = newList.get(i);
               count = Collections.frequency(newList,newList.get(i));
           }
        }
        return mostCommon;
    }
}
