package leetcode.group_anagrams;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. 애너그램을 이루는 단어들을 정렬하면 같은 값을 가지므로 정렬한 값을 key 로 사용
        // 2. value 로는 단어를 담고있는 리스트
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            map.computeIfAbsent(key, it -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
