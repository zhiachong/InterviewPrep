/**
 * Zhia's Interview Prep Course <Week 2>
 *
 * @author Chloe Kim (chloekim@cmu.edu)
 */
import java.util.*;
/**
 * [Question 3]
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Assume you have R, B, W, R, B, return a sorted array with R, R, W, B, B
 *
 * [Explanation]
 * I would use three int variables to count each characters.
 * After first iteration, I would know how much 'R', 'W', and 'B' in the given array.
 * Then I can easily fill the array using the counters.
 */
class SortColors {

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        char[] colors = new char[]{'R', 'B', 'W', 'B', 'W', 'R', 'R'};
        System.out.println("before: "+Arrays.toString(colors));
        sc.sortColors(colors);
        System.out.println("after: "+Arrays.toString(colors));
    }

    public void sortColors(char[] colors) {
        int countR = 0, countW = 0, countB = 0;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 'R') countR++;
            else if (colors[i] == 'W') countW++;
            else countB++;
        }
        int i = 0;
        while (i < countR) colors[i++] = 'R';
        while (i < countR + countW) colors[i++] = 'W';
        while (i < colors.length) colors[i++] = 'B';
    }
}