package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {
    private E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public E[] removeValue(E valueToRemove) {

        int count = getNumberOfOccurrences(valueToRemove);
        E[] removed = Arrays.copyOf(inputArray, inputArray.length - count);
        int index = 0;
        for (int i=0; i<inputArray.length; i++) {
            if (!inputArray[i].equals(valueToRemove)) {
                removed[index++] = inputArray[i];
            }
        }
        return removed;
    }


    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {

        int duplicates = 0;
        E[] merged = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        for (int i=inputArray.length; i<merged.length; i++) {
            merged[i] = arrayToMerge[i-inputArray.length];
        }

        return getNumberOfOccurrences(merged, valueToEvaluate);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {

        E[] merged = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        for (int i=inputArray.length; i<merged.length; i++) {
            merged[i] = arrayToMerge[i-inputArray.length];
        }

        E mostCommon = null;
        int elementCount = 0;
        for (int i=0; i<merged.length; i++) {
            int elementOccurrences = getNumberOfOccurrences(merged, merged[i]);
            if (elementOccurrences > elementCount) {
                elementCount = elementOccurrences;
                mostCommon = merged[i];
            }
        }

        return mostCommon;
    }

    private Integer getNumberOfOccurrences(E[] array, E valueToEvaluate) {

        int count = 0;
        for (int i=0; i<array.length; i++) {
            if(array[i].equals(valueToEvaluate)) {
                count++;
            }
        }
        return count;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        return getNumberOfOccurrences(inputArray, valueToEvaluate);
    }
}

