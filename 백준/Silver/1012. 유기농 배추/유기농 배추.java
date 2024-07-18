import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	static int T; // 테스트 케이스
	static int M; // 세로 길이
	static int N; // 가로 길이
	static int K; // 배추가 심어져있는 개수

	static int[][] arr;
	static boolean[][] visit;
	static int[] dx =
	{ 0, 0, 1, -1 };
	static int[] dy =
	{ 1, -1, 0, 0 };
	static int result;

	static void dfs(int x, int y)
	{
		visit[x][y] = true;

		for (int i = 0; i < 4; i++)
		{
			int xx = x + dx[i];
			int yy = y + dy[i];

			if (xx >=0 && yy >= 0 && xx < M && yy < N)
			{
				if (!visit[xx][yy] && arr[xx][yy] == 1)
				{
					dfs(xx, yy);

				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;

		for (int t = 0; t < T; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visit = new boolean[M][N];

			for (int k = 0; k < K; k++)
			{
				StringTokenizer x_y = new StringTokenizer(br.readLine());
				x = Integer.parseInt(x_y.nextToken());
				y = Integer.parseInt(x_y.nextToken());
				arr[x][y] = 1;
				
			}
			result=0;
			for (int i = 0; i < M; i++)
			{
				for (int j = 0; j < N; j++)
				{
					if (arr[i][j] == 1 && !visit[i][j])
					{
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

}
