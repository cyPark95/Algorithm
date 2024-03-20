class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;

        for (int i = 1; i <= len / 2; i++) {
            int cnt = 1;
            String prev = s.substring(0, i);

            StringBuilder compressed = new StringBuilder();
            for (int j = i; j <= len; j += i) {
                int idx = Math.min(j + i, len);

                String cur = s.substring(j, idx);
                if (prev.equals(cur)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        compressed.append(cnt);
                    }
                    compressed.append(prev);

                    prev = cur;
                    cnt = 1;
                }
            }

            compressed.append(prev);
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}