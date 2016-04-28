package tasks.second;

import java.util.Random;

public class Main {

    public static int partition(int[] array, int left, int right) {
        int firstIndex = left;
        int secondIndex = right;

        int pivotElement = array[(left + right) / 2];

        while (firstIndex <= secondIndex) {
            while (array[firstIndex] < pivotElement) {
                firstIndex++;
            }
            while (array[secondIndex] > pivotElement) {
                secondIndex--;
            }

            if (firstIndex <= secondIndex) {
                int temporaryValue = array[firstIndex];
                array[firstIndex] = array[secondIndex];
                array[secondIndex] = temporaryValue;
                firstIndex++;
                secondIndex--;
            }

        }
        return firstIndex;

    }

    public static void quickSort(int[] array, int left, int right) {
        if (array == null || array.length == 0) {
            return;
        }
        int pivotIndex = partition(array, left, right);

        if (left < pivotIndex - 1) {
            quickSort(array, left, pivotIndex - 1);
        }
        if (pivotIndex < right) {
            quickSort(array, pivotIndex, right);
        }
    }

    public static int binarySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int lowerIndex = 0;
        int higherIndex = array.length - 1;

        while (lowerIndex <= higherIndex) {
            int middleIndex = (lowerIndex + higherIndex) / 2;
            if (key < array[middleIndex]) {
                higherIndex = middleIndex - 1;
            } else
            if (key > array[middleIndex]) {
                lowerIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array[" + i + "]" + " = " + array[i]);
        }
    }

    public static void initArray(int[] array) {
        Random randomGenerator = new Random();
        int arrayLength = array.length;
        for (int index = 0; index < arrayLength; index++) {
            array[index] = randomGenerator.nextInt(2 * arrayLength) - arrayLength;
        }
    }
    public static void initArrayWithTheSameElement(int[] array, int element) {
        for (int index = 0; index < array.length; index++) {
            array[index] = element;
        }
    }

    public static void testSorting(int[] array) {
        System.out.println("Before sorting");
        printArray(array);
        quickSort(array, 0, array.length - 1);
        System.out.println("After sorting");
        printArray(array);
    }

    public static void testBinarySearch(int[] array) {
        System.out.println("Tests of finding different elements");
        Random randomGenerator = new Random();
        int numOfTests = 10;
        int arrayLength = array.length;
        for (int index = 0; index < numOfTests; index++) {
            int keyToFind = randomGenerator.nextInt(2 * arrayLength + 1) - arrayLength;
            printMessage(array, keyToFind, binarySearch(array, keyToFind));
        }
    }

    public static void printMessage(int[] array, int keyToFind, int resultIndex) {
        if (resultIndex == -1) {
            System.out.println("Key to find is " + keyToFind + ", binarySearch result index is " + resultIndex + ", Array["
                    + resultIndex + "] = undefined");
        } else {
            System.out.println("Key to find is " + keyToFind + ", binarySearch result index is " + resultIndex + ", Array["
                    + resultIndex + "] = " + array[resultIndex]);
        }
    }

    public static void testingFunctions(int[] array, String message) {
        System.out.println("Testing " + message + " sorting");
        testSorting(array);
        System.out.println("Testing " + message + " binary search");
        testBinarySearch(array);
        System.out.println();
    }

    public static void main(String[] args) {


        int[] zeroLengthArray = new int[]{};
        initArray(zeroLengthArray);
        testingFunctions(zeroLengthArray, "a zero length array");

        int[] oneElementArray = new int[1];
        initArray(oneElementArray);
        testingFunctions(oneElementArray, "a one element array");

        int length = 15;
        int[] manyElementsArray = new int[length];
        initArray(manyElementsArray);
        testingFunctions(manyElementsArray, "many elements array");

        int[] sameElementsArray = new int[length];
        initArrayWithTheSameElement(sameElementsArray, length / 2);
        testingFunctions(sameElementsArray, "same elements array");



    }
}
