class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = toSeconds(video_len);
        int position = toSeconds(pos);
        int openingStart = toSeconds(op_start);
        int openingEnd = toSeconds(op_end);

        for (String command : commands) {
            position = skipOpening(position, openingStart, openingEnd);
            
            if ("prev".equals(command)) {
                position = Math.max(0, position - 10);
            } else if ("next".equals(command)) {
                position = Math.min(video, position + 10);
            }
        }
        
        position = skipOpening(position, openingStart, openingEnd);

        int m = position / 60;
        int s = position % 60;
        
        return String.format("%02d:%02d", m, s);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private int skipOpening(int pos, int start, int end) {
        return (pos >= start && pos < end) ? end : pos;
    }
}