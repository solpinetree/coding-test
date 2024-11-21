import java.util.*;

class Solution { 
    private int remove(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map) {
        while(!pq.isEmpty()) {
            int remove = pq.poll();
            if (map.get(remove) > 0) {
                map.put(remove, map.get(remove) - 1);
                return remove;
            }
        }
        return 0;
    }
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for(String op : operations) {
            String command = op.split(" ")[0];
            int data = Integer.parseInt(op.split(" ")[1]);
            
            if(command.equals("I")) {
                countMap.put(data, countMap.getOrDefault(data, 0) + 1);
                minQ.add(data); maxQ.add(data);
            } else {
                if(data == 1) remove(maxQ, countMap);
                else remove(minQ, countMap);
            }
        }
        
        int max = 0; int min = 0;
        while(!maxQ.isEmpty() && countMap.get(maxQ.peek()) <= 0) maxQ.poll();
        if(!maxQ.isEmpty()) max = maxQ.poll();
        while(!minQ.isEmpty() && countMap.get(minQ.peek()) <= 0) minQ.poll();
        if(!minQ.isEmpty()) min = minQ.poll();
        
        return new int[]{max, min};
    }
}
