import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        String[] answer = {};

        List<String[]> complete = new ArrayList<>();
        List<String[]> problem = new ArrayList<>();

        int minBase = 2;

        for (String expression : expressions) {
            String[] parts = expression.split(" ");

            if (parts[4].contains("X")) {
                problem.add(parts);
            } else {
                complete.add(parts);
            }

            for (int i = 0; i < parts.length; i += 2) {
                if (parts[i].contains("X")) {
                    continue;
                }

                for (char c : parts[i].toCharArray()) {
                    minBase = Math.max(minBase, (c - '0') + 1);
                }
            }
        }

        boolean[] possibleBase = new boolean[10];
        Arrays.fill(possibleBase, true);

        for (int base = minBase; base <= 9; base++) {
            for (String[] expression : complete) {
                if (!isValidNumber(expression[0], base) || !isValidNumber(expression[2], base) || !isValidNumber(expression[4], base)) {
                    possibleBase[base] = false;
                    break;
                }

                int result = calc(expression, base);
                int expected = toDecimal(expression[4], base);

                if (result != expected) {
                    possibleBase[base] = false;
                    break;
                }
            }
        }

        answer = new String[problem.size()];
        for (int i = 0; i < problem.size(); i++) {
            String[] expression = problem.get(i);
            Set<String> resultSet = new HashSet<>();

            for (int base = minBase; base <= 9; base++) {
                if (!possibleBase[base]) {
                    continue;
                }

                if (!isValidNumber(expression[0], base) || !isValidNumber(expression[2], base)) {
                    continue;
                }

                int result = calc(expression, base);
                String baseStr = toBase(result, base);

                resultSet.add(baseStr);
            }

            String finalValue = (resultSet.size() == 1)
                    ? resultSet.iterator().next()
                    : "?";

            answer[i] = String.format("%s %s %s = %s", expression[0], expression[1], expression[2], finalValue);
        }

        return answer;
    }

    private boolean isValidNumber(String num, int base) {
        for (char ch : num.toCharArray()) {
            int d = ch - '0';
            if (d < 0 || d >= base) {
                return false;
            }
        }
        return true;
    }

    private int toDecimal(String num, int base) {
        int val = 0;
        for (char ch : num.toCharArray()) {
            val = val * base + (ch - '0');
        }
        return val;
    }
    
    private int calc(String[] expression, int base) {
        int num1 = toDecimal(expression[0], base);
        int num2 = toDecimal(expression[2], base);

        if (expression[1].equals("+")) {
            return num1 + num2;
        }
        return num1 - num2;
    }

    private String toBase(int value, int base) {
        if (value == 0) {
            return "0";
        }

        if (value < 0) {
            value = -value;
        }

        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(value % base);
            value /= base;
        }

        if (value < 0) {
            sb.append('-');
        }
        
        return sb.reverse().toString();
    }
}