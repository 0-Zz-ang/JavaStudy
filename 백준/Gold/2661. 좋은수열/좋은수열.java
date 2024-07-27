import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        
        // 백트래킹 시작
        findSequence(N, "");
    }

    // 수열을 찾는 재귀 메서드
    public static boolean findSequence(int N, String sequence) {
        // 종료 조건: 수열의 길이가 N이면 출력하고 true 반환
        if (sequence.length() == N) {
            System.out.println(sequence);
            return true;
        }

        // 1, 2, 3을 순차적으로 수열에 추가하면서 백트래킹
        for (int i = 1; i <= 3; i++) {
            if (isGoodSequence(sequence + i)) {
                // 좋은 수열이면 다음 재귀 호출
                if (findSequence(N, sequence + i)) {
                    return true; // 수열을 찾았으면 true 반환
                }
            }
        }

        // 좋은 수열을 찾지 못했으면 false 반환
        return false;
    }

    // 수열이 좋은 수열인지 확인하는 메서드
    public static boolean isGoodSequence(String sequence) {
        int length = sequence.length();

        // 모든 가능한 부분 수열을 확인
        for (int i = 1; i <= length / 2; i++) {
            if (sequence.substring(length - i).equals(sequence.substring(length - 2 * i, length - i))) {
                return false; // 반복되는 부분 수열이 있으면 false 반환
            }
        }

        // 반복되는 부분 수열이 없으면 true 반환
        return true;
    }
}
