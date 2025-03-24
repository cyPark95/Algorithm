import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int index = 0;
        int endTime = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        while (index < jobs.length || !pq.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= endTime) {
                pq.offer(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
            }

            if (pq.isEmpty()) {
                endTime = jobs[index][0];
                pq.offer(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
                continue;
            }
            
            Job job = pq.poll();
            endTime += job.time;
            answer += endTime - job.requestTime;
        }

        answer /= jobs.length;
        return answer;
    }

    static class Job implements Comparable<Job> {

        int index;
        int requestTime;
        int time;

        public Job(int index, int requestTime, int time) {
            this.index = index;
            this.requestTime = requestTime;
            this.time = time;
        }

        @Override
        public int compareTo(Job job) {
            if (this.time == job.time) {
                if (this.requestTime == job.requestTime) {
                    return this.index - job.index;
                }

                return this.requestTime - job.requestTime;
            }

            return this.time - job.time;
        }
    }
}