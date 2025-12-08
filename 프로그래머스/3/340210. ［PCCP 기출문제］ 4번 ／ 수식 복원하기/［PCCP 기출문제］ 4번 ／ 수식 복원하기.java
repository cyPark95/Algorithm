import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        String[] answer = {};
        List<String> problemExpressions = new ArrayList<>();
        List<String> validExpressions = new ArrayList<>();

        int minBase = 2;
        for (String expression : expressions) {
            if (expression.contains("X")) {
                problemExpressions.add(expression);
            } else {
                validExpressions.add(expression);
            }

            String[] parts = expression.split(" ");

            for (int i = 0; i < parts.length; i += 2) {
                for (char c : parts[i].toCharArray()) {
                    if (c == 'X') {
                        continue;
                    }

                    int num = c - '0';
                    minBase = Math.max(minBase, num + 1);
                }
            }
        }

        boolean[] checkedBase = new boolean[10];

        for (String expression : validExpressions) {
            String[] parts = expression.split(" ");

            for (int base = minBase; base <= 9; base++) {
                int result = evaluateExpression(parts, base);
                checkedBase[base] = result == convertToDecimal(parts[4], base);
            }
        }

        String[] answers = new String[problemExpressions.size()];
        for (int i = 0; i < problemExpressions.size(); i++) {
            String[] parts = problemExpressions.get(i).split(" ");
            Set<String> resultSet = new HashSet<>();

            for (int base = minBase; base <= 9; base++) {
                if (checkedBase[base]) {
                    int result = evaluateExpression(parts, base);

                    if (result == 0) {
                        resultSet.add("0");
                    } else if (result > 0) {
                        StringBuilder sb = new StringBuilder();
                        while (result > 0) {
                            sb.append(result % base);
                            result /= base;
                        }
                        resultSet.add(sb.reverse().toString());
                    }
                }
            }

            answers[i] = problemExpressions.get(i).replace("X", resultSet.size() == 1 ? resultSet.iterator().next() : "?");
        }

        return answers;
    }

    private int convertToDecimal(String numberString, int base) {
        int value = 0;
        for (char c : numberString.toCharArray()) {
            int digit = c - '0';
            value = value * base + digit;
        }
        return value;
    }

    private int evaluateExpression(String[] parts, int base) {
        int number1 = convertToDecimal(parts[0], base);
        int number2 = convertToDecimal(parts[2], base);

        if (parts[1].equals("+")) {
            return number1 + number2;
        }
        return number1 - number2;
    }
}