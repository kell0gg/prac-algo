package leetcode.array_partition;

import java.util.Arrays;

// https://leetcode.com/problems/array-partition/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.arrayPairSum(new int[]{1, 4, 3, 2});
        System.out.println(result);
    }
}

class Solution {
    public int arrayPairSum(int[] nums) {
        // 2n 사이즈의 배열이 주어짐
        // n 개의 페어를 만듦
        // 이때 최대가 되려면 정렬하고 => 두 개씩 묶는 방법으로 해야 함
        // 제일 작은 값과, 그 다음 작은 값을 묶어야 전체 합이 가장 클 수 있음
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            // sum += Math.min(nums[i], nums[i + 1]);
            // 항상 앞에 있는 애가 더 작음
            sum += nums[i];
        }
        return sum;
    }
}