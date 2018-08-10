/**
 * Zhia's Interview Prep Course WarmUpQuestion1.
 *
 * @author Chloe Kim (chloekim@cmu.edu)
 */
import java.util.*;
/**
 * [Question]
 * Given an array of numbers, find the top K largest numbers in the array.
 * ex) [5,1,2,9,1], K = 3, return [5,9,2].
 *
 * [Explanation]
 * I came up with two ideas once I've read this question.
 *
 * First way is (1) sort the given array first (2) create a new array before index k. 
 * It would take O(NlogN) time complexity due to the Arrays.sort().
 *
 * Second way is using quickselect.
 * I learned quickselect when I solve 'top K frequent ~ top K largest ~' problems.
 * It would take O(N) time since quickselect only deals with one side from the pivot.
 * But if I should return the answer array as sorted, (ex, [2,5,9]) it would not work or I would add more codes for that.
 */
class WarmUpQuestion1{

    /**
     * The function which is called.
     * @param arr int array (not sorted)
     * @param k an integer index 
     */
    public int[] topKlargestNumbers(int[] arr, int k) {
        // if the input is invalid, throw a runtime exception
        if (arr == null || k > arr.length) throw new RuntimeException("Input is invalid.");
        return quickselect(arr, 0, arr.length - 1, k);
    }

    /**
     * Recursive function.
     * @param arr int array
     * @param startIndex int index to be used as the start point
     * @param endIndex int index to be used as the end point
     * @param k an integer index 
     */
    private int[] quickselect(int[] arr, int startIndex, int endIndex, int k) {
        int pivotIndex = partition(arr, startIndex, endIndex);
        if (pivotIndex < k) return quickselect(arr, pivotIndex + 1, endIndex, k);
        else if (pivotIndex > k) return quickselect(arr, startIndex, pivotIndex - 1, k);
        else { // pivotIndex == k
            System.out.println("pivotIndex: "+pivotIndex+", k: "+k+", arr: "+Arrays.toString(arr));
            int[] res = new int[k];
            for (int i = 0; i < k; i++)
                res[i] = arr[i];
            return res;
        }
    }

    /**
     * Partition function.
     * @param arr int array
     * @param startIndex int index to be used as the start point
     * @param endIndex int index to be used as the end point
     */
    private int partition(int[] arr, int startIndex, int endIndex) {
        int pivotIndex = new Random().nextInt(endIndex - startIndex + 1) + startIndex;
        swap(arr, pivotIndex, endIndex); // send the pivot Index to the end of the array

        // send an element larger than pivot (currently at the arr[endIndex]) to ahead of the index
        // pivot will be sent to the proper location (the last startIndex after the loop)
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] > arr[endIndex]) {
                swap(arr, i, startIndex);
                startIndex++; // increase the startIndex to get another element larger than pivot
            }
        }
        swap(arr, startIndex, endIndex); // change the pivot which is located in the endIdnex to the startIndex

        return startIndex; // return the final pivot location
    }

    /**
     * Simple swap function.
     * @param arr
     */
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Main driver.
     */
    public static void main(String[] args) {
        WarmUpQuestion1 w1 = new WarmUpQuestion1();
        int[] arr = new int[]{5,1,2,9,0};
        System.out.println(Arrays.toString(w1.topKlargestNumbers(arr, 3)));
    }
}