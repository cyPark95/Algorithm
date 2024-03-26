class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int index = 0;
        
        for (int i = 0; i < len; i++) {
            char max = '\0';
            for (int j = index; j <= i + k; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }

            sb.append(max);
        }

        return sb.toString();
    }
}