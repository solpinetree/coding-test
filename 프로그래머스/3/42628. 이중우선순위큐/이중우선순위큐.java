import java.util.*;

class Solution {
    private int remove(PriorityQueue<Integer> targetPq, HashMap<Integer, Integer> targetMap) {
        int remove = 0;
        while (!targetPq.isEmpty()) {
            remove = targetPq.poll();
            if (targetMap.get(remove) > 0) { // 유효한 값인지 확인
                targetMap.put(remove, targetMap.get(remove) - 1);
                return remove;
            }
        }
        return 0;
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int data = Integer.parseInt(parts[1]);

            if (command.equals("D")) {
                if (data == 1 && !pqMax.isEmpty()) { // 최댓값 삭제
                    remove(pqMax, countMap);
                } else if (data == -1 && !pqMin.isEmpty()) { // 최솟값 삭제
                    remove(pqMin, countMap);
                }
            } else { // 삽입 연산
                pqMin.add(data);
                pqMax.add(data);
                countMap.put(data, countMap.getOrDefault(data, 0) + 1);
            }
        }

        // 남은 값을 정리하여 결과 반환
        while (!pqMin.isEmpty() && countMap.get(pqMin.peek()) == 0) {
            pqMin.poll();
        }
        while (!pqMax.isEmpty() && countMap.get(pqMax.peek()) == 0) {
            pqMax.poll();
        }

        if (pqMin.isEmpty() || pqMax.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{pqMax.peek(), pqMin.peek()};
    }
}
