package leetcode.product_of_array_except_self;

// https://leetcode.com/problems/product-of-array-except-self/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(new int[]{1, 3, 5, 7});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    // You must write an algorithm that runs in O(n) time and without using the division operation.
    // 1, 3, 5, 7
    // 1,    1, 3, 15 => 자기자신을 제외한 왼쪽 곱의 결과를 가지고 있는 배열1
    // 105, 35, 7, 1  => 자기자신을 제외한 오른쪽 곱의 결과를 가지고 있는 배열2
    // 이 두 배열을 곱하면 됨
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
}
