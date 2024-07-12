import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        while (testNum-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{i, sc.nextInt()});
            }

            int count = 0;

            while (!queue.isEmpty()) {

                int[] front = queue.poll();
                boolean isMax = true;

                for (int k = 0; k < queue.size(); k++) {
                    if (front[1] < queue.get(k)[1]) {
                        queue.offer(front);
                        for (int j = 0; j < k; j++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    continue;
                }
                count++;
                if (front[0] == M) {
                    break;
                }
            }
            stringBuilder.append(count).append('\n');
        }
        System.out.println(stringBuilder);
    }
}