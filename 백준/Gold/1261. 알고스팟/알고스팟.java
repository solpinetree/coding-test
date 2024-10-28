import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        distance = new int[N][M];
        
        // 맵 정보 입력
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                distance[i][j] = Integer.MAX_VALUE; // 초기 거리 무한대로 설정
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            Point current = pq.poll();

            // 목적지 도달 시 최소 비용 반환
            if (current.x == N - 1 && current.y == M - 1) {
                return current.walls;
            }

            // 4방향 탐색
            for (int[] direction : directions) {
                int nx = current.x + direction[0];
                int ny = current.y + direction[1];

                // 맵의 범위를 벗어나지 않도록 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int newWalls = current.walls + map[nx][ny];
                    
                    // 더 적은 벽을 부수고 방문할 수 있다면 업데이트
                    if (newWalls < distance[nx][ny]) {
                        distance[nx][ny] = newWalls;
                        pq.offer(new Point(nx, ny, newWalls));
                    }
                }
            }
        }
        return -1; // 경로가 없을 경우 (문제에서는 항상 경로가 존재한다고 가정)
    }

    static class Point implements Comparable<Point> {
        int x, y, walls;

        Point(int x, int y, int walls) {
            this.x = x;
            this.y = y;
            this.walls = walls;
        }

        @Override
        public int compareTo(Point other) {
            return this.walls - other.walls; // 벽을 적게 부순 순서로 정렬
        }
    }
}
