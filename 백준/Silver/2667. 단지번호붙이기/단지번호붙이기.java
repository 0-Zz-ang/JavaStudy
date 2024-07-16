import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
	static int N;
	static char g[][] = new char[25][25];

	static int d[][] = new int[25][25];
	static int num;
	
	static int list[] = new int[625];
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.valueOf(br.readLine());

		String input = null;
		for (int i = 0; i < N; i++)
		{
			input = br.readLine();
			for (int j = 0; j < N; j++)
			{
				g[i][j] = input.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (g[i][j] == '1' && d[i][j] == 0)
				{
					num++;
					bfs(i, j);
				}
			}
		}
		
//		System.out.println(Arrays.toString(list));
		
		Arrays.sort(list, 1, num+1);	// 1번 인덱스부터 단지수만큼 범위를 지정하여 오름차순으로 정렬
		
		System.out.println(num);
		for (int i = 1; i <= num; i++)
		{
			System.out.println(list[i]);
		}
		
		// 단지번호를 저장한 배열 출력
//		for (int i = 0; i < N; i++)
//		{
//			System.out.println(Arrays.toString(d[i]));
//		}
	}

	private static void bfs(int i, int j)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(i*100 + j);
		
		int pos = 0;
		int count = 0;
		while (queue.isEmpty() == false)
		{
			pos = queue.poll();
			i = pos / 100;
			j = pos % 100;
			
			if (d[i][j] != 0) continue;
			
			d[i][j] = num;
			count++;
			
			if (i > 0 && g[i-1][j] == '1' && d[i-1][j] == 0) queue.offer((i-1)*100 + j);	// 상
			if (i < N-1 && g[i+1][j] == '1' && d[i+1][j] == 0) queue.offer((i+1)*100 + j);	// 하
			if (j > 0 && g[i][j-1] == '1' && d[i][j-1] == 0) queue.offer(i*100 + (j-1));	// 좌
			if (j < N-1 && g[i][j+1] == '1' && d[i][j+1] == 0) queue.offer(i*100 + (j+1));	// 우
		}
		list[num] = count;
	}
}
