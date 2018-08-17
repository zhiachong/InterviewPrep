/**
 * Zhia's Interview Prep Course <Week 2>
 *
 * @author Chloe Kim (chloekim@cmu.edu)
 */
import java.util.*;
/**
 * [Question]
 * Given a string, generate all different permutations of the string.
 * Input: "ab", Output: "a", "b", "ab", "Ab", "aB", "AB"
 *
 * [Explanation]
 * I came up with two ideas once I've read this question.
 */
class PermutationInString {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Parameter is required.");
        }
        PermutationInString pis = new PermutationInString();
        for (String s : pis.generatePerms(args[0])) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public List<String> generatePerms(String str) {
        int len = str.length();
        int n = 1 << len; // the number of permutations = 2^len
         
        str = str.toLowerCase();
        List<String> res = new ArrayList<>();
         
        for (int i = 0; i < n; i++) {
            char combination[] = str.toCharArray();
             
            // When j-bit set to 1, convert that letter to upper case
            for (int j = 0; j < len; j++) {
                if (((i >> j) &  1) == 1) {
                    combination[j] = (char) (combination[j] - 32);
                }
            }
             
            // Store current combination
            res.add(String.valueOf(combination));
        }
        return res;
    }
}