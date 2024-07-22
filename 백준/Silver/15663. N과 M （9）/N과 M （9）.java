import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] output;
    static boolean[] visited;
    static LinkedHashSet<String> resultSet = new LinkedHashSet<>();

    public static void backtrack(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : output) {
                sb.append(num).append(' ');
            }
            resultSet.add(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        output = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers); // 숫자를 정렬

        backtrack(0);

        for (String s : resultSet) {
            System.out.println(s);
        }
    }
}
