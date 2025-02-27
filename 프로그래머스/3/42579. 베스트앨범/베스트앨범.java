import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreSong = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            List<Song> songs = genreSong.getOrDefault(genres[i], new ArrayList<>());
            songs.add(new Song(i, plays[i]));
            genreSong.put(genres[i], songs);
        }

        List<String> keys = new ArrayList<>(genrePlayCount.keySet());
        keys.sort((o1, o2) -> genrePlayCount.get(o2) - genrePlayCount.get(o1));

        List<Integer> answer = new ArrayList<>();
        for(String key : keys) {
            List<Song> songs = genreSong.get(key);
            Collections.sort(songs);

            for(int i=0; i<Math.min(songs.size(), 2); i++) {
                Song song = songs.get(i);
                answer.add(song.index);
            }
        }

        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }

    static class Song implements Comparable<Song> {

        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if(this.play == o.play) {
                return this.index - o.index;
            }

            return o.play - this.play;
        }
    }
}