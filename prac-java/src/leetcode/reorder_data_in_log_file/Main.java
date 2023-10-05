package leetcode.reorder_data_in_log_file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/reorder-data-in-log-files/
public class Main {
    public static void main(String[] args) {
            /*
    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     */
        Solution solution = new Solution();
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] result = solution.reorderLogFiles(logs);
        Arrays.stream(result).forEach(System.out::println);
    }
}

class Solution {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            char firstContentChar = log.split(" ")[1].charAt(0);
            if (Character.isDigit(firstContentChar)) {
                digitLogs.add(log);

            } else if (Character.isLetter(firstContentChar)) {
                letterLogs.add(log);

            } else {
                throw new RuntimeException("invalid input");
            }
        }

        letterLogs.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterLogs.addAll(digitLogs);

        /*
        new String[0]는 길이가 0인 String 배열을 생성합니다. 그런데 여기서 list.toArray(new String[0])에 전달될 때 특별한 의미를 가집니다.
        List의 toArray 메서드는 인수로 전달된 배열의 타입으로 새 배열을 반환하려고 시도합니다.
        만약 전달된 배열의 길이가 리스트의 크기보다 같거나 크다면, 해당 배열은 리스트의 요소로 채워지게 됩니다. 그러나 이 경우에는 배열의 길이가 0이므로 리스트의 요소로 채울 수 없습니다.
        만약 전달된 배열의 길이가 리스트의 크기보다 작다면 (이 경우에는 0이므로 항상 작습니다), toArray 메서드는 새 배열을 생성하고 해당 배열을 적절한 크기로 반환합니다.
        즉, new String[0]을 사용하면 toArray 메서드에게 "String 타입의 배열을 원하지만, 적절한 크기의 배열을 직접 생성하도록 해라"라고 알려주는 것입니다.
        이 접근 방식의 장점은 특히 Java 8 이후로 JVM이 최적화되어 있어서 new String[0]을 사용하는 것이 new String[list.size()]보다 더 빠르거나 효율적이라는 것이 연구와 벤치마크를 통해 나타났기 때문입니다.
         */
        return letterLogs.toArray(new String[0]);
    }
}