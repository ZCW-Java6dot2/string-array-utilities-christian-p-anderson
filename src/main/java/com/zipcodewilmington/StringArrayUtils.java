package com.zipcodewilmington;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean answer = false;

         for(String element : array) {
             if (element == value) {
                 answer = true;
                 break;
             }
         }

         return answer;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        String[] reversed = new String[array.length];

        for(Integer i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }

        return reversed;

    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] reversed = reverse(array);

        if (array == reversed) {
            return true;
        }

        if (array == null || reversed == null) {
            return false;
        }

        Integer n = array.length;
        if (n != reversed.length) {
            return false;
        }

        for (Integer i = 0; i < n; i++) {
            if (!array[i].equals(reversed[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        boolean[] switches = new boolean[26];

        for (Integer i = 0; i < array.length; i++) {
            String elementOfArray = array[i];
            elementOfArray = elementOfArray.toUpperCase();

            for (Integer j = 0; j < elementOfArray.length(); j++) {
                int ascii = elementOfArray.charAt(j) - 65;
                if (ascii >= 0 && ascii < 26) {
                    switches[ascii] = true;
                }
            }
        }

        for (Integer k = 0; k < 26; k++) {
            if (!switches[k]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        Integer count = 0;

        for (Integer i = 0; i < array.length; i++) {
            if(array[i] == value) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        Integer newArraySize = array.length - getNumberOfOccurrences(array, valueToRemove);
        String[] resultArray = new String[newArraySize];
        Integer newArrayIndex = 0;

        for(Integer i = 0; i < array.length; i++) {
            if(array[i].equals(valueToRemove)) {
                newArrayIndex++;
            } else {
                resultArray[i - newArrayIndex] = array[i];
            }
        }

        return resultArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        Integer newArraySize = array.length - duplicateCount(array);
        String[] resultArray = new String[newArraySize];
        Integer resultArrayIndex = 0;

        for (Integer i = 0; i < array.length; i++) {
            if (i == 0 || !array[i].equals(array[i - 1])) {
                resultArray[resultArrayIndex] = array[i];
                resultArrayIndex++;
            }
        }

        return resultArray;
    }


    public static int duplicateCount(String[] array) {

        int duplicateCount = 0;

        for (Integer i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }



    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        Integer newArraySize = array.length - duplicateCount(array);
        String[] resultArray = new String[newArraySize];
        Integer resultArrayIndex = 0;
        String concatStr = array[0];
        String currentStr = array[0];

        for (Integer i = 1; i < array.length; i++) {
            if(array[i].equals(currentStr)) {
                concatStr += currentStr;
            } else {
                resultArray[resultArrayIndex] = concatStr;
                resultArrayIndex++;
                concatStr = array[i];
                currentStr = array[i];
            }
        }
        resultArray[resultArrayIndex] = concatStr;
        return resultArray;

    }


}
