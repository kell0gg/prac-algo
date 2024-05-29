package leetcode.largest_number;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/largest-number/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // String result = solution.largestNumber(new int[]{3, 30, 34, 5, 9});
        // String result = solution.largestNumber(new int[]{0, 0});
        String result = solution.largestNumber(new int[]{0, 0});
        System.out.println(result);
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        List<String> stringNums = new ArrayList<>(nums.length);
        StringBuilder stringBuilder = new StringBuilder();

        for (int num : nums) {
            stringNums.add(String.valueOf(num));
        }

        stringNums.sort((a, b) -> {
            BigInteger sum1 = new BigInteger(b + a);
            BigInteger sum2 = new BigInteger(a + b);
            return sum1.compareTo(sum2);
        });

        stringNums.forEach(stringBuilder::append);
        String result = stringBuilder.toString();
        if (result.charAt(0) == '0') return "0";
        else return result;
    }
}