package leetcode._3sum;

import java.util.*;

// https://leetcode.com/problems/3sum/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 단순히 반복하면 n * n * n
        // two pointer 를 쓰면 n * n
        int left = 0, right = 0, sum = 0;

        // 중복제거를 하지 않고 Set 으로 저장한 뒤, 반환해도 동일한 결과를 얻을 수 있음
        // Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // i, i+1 (left), nums.length - 1 (right)
        for (int i = 0; i < nums.length - 2; i++) {

            // 중복제거
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // i 다음 것 부터 처리함
            left = i + 1;
            right = nums.length - 1;


            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    // 합이 0이 되는 경우
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복제거
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return result;
        // return new ArrayList<>(result);
    }
}