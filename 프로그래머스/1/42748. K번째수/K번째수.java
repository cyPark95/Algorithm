
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++) {
            int start = commands[i][0] - 1;
            int size = commands[i][1] - start;
            
            int[] newArray = new int[size];
            for(int j = 0; j < size; j++) {
                newArray[j] = array[start + j];
            }
            
            Arrays.sort(newArray);
            int index = commands[i][2] - 1;
            answer[i] = newArray[index];
        }
        
        return answer;
    }
}