import java.util.*;
// 우선순위 : 소요시간 짧 > 요청 시각 빠른 > 작업의 번호가 작은 것 순
class Solution {
    // jobs : [작업이 요청되는 시점, 작업의 소요시간]
    // return : 모든 요청 작업의 반환 시간의 평균의 정수부분
    class Job {
        int num; int request; int duration;
        
        public Job(int num, int request, int duration) {
            this.num = num; this.request = request; this.duration = duration;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.duration != b.duration) return a.duration - b.duration;    
                else if(a.request != b.request) return a.request - b.request;
                else return a.num - b.num;
            });
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int time = 0;
        int idx = 0;
        
        while(idx < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            } 
            if(pq.isEmpty()) time++;
            else {
                Job job = pq.poll();
                time += job.duration;
                answer += time - job.request;
            }
        }
        
        while(!pq.isEmpty()) {
            Job job = pq.poll();
            time += job.duration;
            answer += time - job.request;
        }
        
        return answer / jobs.length;
    }
}