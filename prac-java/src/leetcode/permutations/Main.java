package leetcode.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations/description/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> s : result) {
            for (Integer e : s) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> listNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(new ArrayList<>(), listNums, result);
        return result;
    }

    private void dfs(List<Integer> generatedElements, List<Integer> remainingElements, List<List<Integer>> result) {
        if (remainingElements.isEmpty()) {
            result.add(new ArrayList<>(generatedElements));
            return;
        }

        for (Integer element : remainingElements) {
            List<Integer> elementToPermute = new ArrayList<>(remainingElements);
            elementToPermute.remove(element);
            generatedElements.add(element);
            dfs(generatedElements, elementToPermute, result);
            generatedElements.remove(element);
        }
    }
}