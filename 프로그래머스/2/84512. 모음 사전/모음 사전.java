class Solution {
    
    private static int answer;
    private static final String[] VOWELS = new String[]{"A", "E", "I", "O", "U"};

    public int solution(String word) {
        answer = 0;
        dfs(word, "");
        return answer;
    }

    private boolean dfs(String word, String current) {
        if (current.equals(word)) {
            return true;
        }

        if(current.length() == 5) {
            return false;
        }

        for (String vowel : VOWELS) {
            answer++;
            if(dfs(word, current + vowel)) {
                return true;
            }
        }

        return false;
    }
}