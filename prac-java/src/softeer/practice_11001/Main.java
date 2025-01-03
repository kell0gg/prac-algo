package softeer.practice_11001;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<GptNumber> gptNums = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] temp = st.nextToken().split("\\.");
            if (temp.length == 1) {
                GptNumber gptNumber = new GptNumber(Integer.parseInt(temp[0]), -1);
                gptNums.add(gptNumber);
            } else {
                GptNumber gptNumber = new GptNumber(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
                gptNums.add(gptNumber);
            }
        }

        gptNums.sort((a, b) -> {
            if (a.integerPart == b.integerPart) return a.fractionPart - b.fractionPart;
            else return a.integerPart - b.integerPart;
        });

        for (GptNumber gptNum : gptNums) {
            if (gptNum.fractionPart < 0) {
                System.out.printf("%s\n", gptNum.integerPart);
            } else {
                System.out.printf("%s.%s\n", gptNum.integerPart, gptNum.fractionPart);
            }
        }
    }
}

class GptNumber {
    int integerPart;
    int fractionPart;

    public GptNumber(int integerPart, int fractionPart) {
        this.integerPart = integerPart;
        this.fractionPart = fractionPart;
    }
}