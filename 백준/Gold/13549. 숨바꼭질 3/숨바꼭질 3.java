import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈이 위치 (0 ~ 100000)
        int K = sc.nextInt(); // 동생 위치 (0 ~ 100000)

        // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 -> bfs(queue)
        bfs(N, K);
    }

    public static void bfs(int N, int K) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(List.of(N, 0)); // position, time
        Set<Integer> visited = new HashSet<>();
        visited.add(N);

        while (!q.isEmpty()) {
            List<Integer> temp = q.poll();
            int position = temp.get(0);
            int time = temp.get(1);

            if(position == K) {
                System.out.println(time);
                return;
            }

            if (0 <= position * 2 && position * 2 <= 100000 &&  !visited.contains(position * 2)) {
                q.offer(List.of(position * 2, time));
                visited.add(position * 2);
            }
            if (0 <= position - 1 && position - 1 <= 100000 &&  !visited.contains(position - 1)) {
                q.offer(List.of(position - 1, time + 1));
                visited.add(position - 1);
            }
            if (0 <= position + 1 && position + 1 <= 100000 &&  !visited.contains(position + 1)) {
                q.offer(List.of(position + 1, time + 1));
                visited.add(position + 1);
            }
        }
    }
}
