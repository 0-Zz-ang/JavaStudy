import java.util.Scanner;

public class Main {
    static int[][] matches = {
        {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
        {1, 2}, {1, 3}, {1, 4}, {1, 5},
        {2, 3}, {2, 4}, {2, 5},
        {3, 4}, {3, 5},
        {4, 5}
    };
    static int[][] results;
    static boolean isPossible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 4; t++) {
            results = new int[6][3];
            isPossible = false;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    results[i][j] = sc.nextInt();
                }
            }

            check(0);
            System.out.print(isPossible ? "1 " : "0 ");
        }
        sc.close();
    }

    public static void check(int matchIndex) {
        if (matchIndex == 15) {
            if (validateResults()) {
                isPossible = true;
            }
            return;
        }

        int team1 = matches[matchIndex][0];
        int team2 = matches[matchIndex][1];

        // team1이 승리, team2가 패배
        if (results[team1][0] > 0 && results[team2][2] > 0) {
            results[team1][0]--;
            results[team2][2]--;
            check(matchIndex + 1);
            results[team1][0]++;
            results[team2][2]++;
        }

        // team1과 team2가 무승부
        if (results[team1][1] > 0 && results[team2][1] > 0) {
            results[team1][1]--;
            results[team2][1]--;
            check(matchIndex + 1);
            results[team1][1]++;
            results[team2][1]++;
        }

        // team1이 패배, team2가 승리
        if (results[team1][2] > 0 && results[team2][0] > 0) {
            results[team1][2]--;
            results[team2][0]--;
            check(matchIndex + 1);
            results[team1][2]++;
            results[team2][0]++;
        }
    }

    public static boolean validateResults() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (results[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
