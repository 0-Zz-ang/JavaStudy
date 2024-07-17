import java.io.*;
import java.util.*;

public class Main 
{
    static ArrayList<Integer>[] graph;	
    static boolean[] visited;

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        graph = new ArrayList[N + 1];	
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 양방향 그래프이므로 양쪽에 모두 추가
        }

        visited = new boolean[N + 1];
        int count = 0;

        // 모든 정점에 대해 DFS/BFS를 수행하여 연결 요소 개수 세기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // 새로운 연결 요소 발견
                dfs(i);
                count++;
            }
        }

        // 연결 요소의 개수 출력
        System.out.println(count);
    }

    // DFS를 사용한 연결 요소 탐색
    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
