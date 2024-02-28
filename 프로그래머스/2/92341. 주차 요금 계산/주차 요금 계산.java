import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int maxTime = (24 * 60) - 1;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String number = split[1];
            String type = split[2];

            if (type.equals("IN")) {
                map.put(number, parseMin(time));
                continue;
            }

            int inMin = map.get(number);
            int outMin = parseMin(time);
            timeMap.put(number, timeMap.getOrDefault(number, 0) + (outMin - inMin));
            map.remove(number);
        }

        for (String number : map.keySet()) {
            int inMin = map.get(number);
            timeMap.put(number, timeMap.getOrDefault(number, 0) + (maxTime - inMin));
        }

        return timeMap.keySet().stream()
                .sorted()
                .mapToInt(t -> getPrice(fees, timeMap.get(t)))
                .toArray();
    }

    private int parseMin(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return (hour * 60) + min;
    }

    private int getPrice(int[] fees, int time) {
        time -= fees[0];
        if (time <= 0) {
            return fees[1];
        }

        int n = time / fees[2];
        if (time % fees[2] > 0) {
            n++;
        }

        return fees[1] + (n * fees[3]);
    }
}