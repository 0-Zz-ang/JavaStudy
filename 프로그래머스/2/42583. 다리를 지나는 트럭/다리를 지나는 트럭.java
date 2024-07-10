import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int n : truck_weights) 
        {
            while(true) {
                if(q.isEmpty()) 
                {
                    q.add(n);
                    answer++;
                    sum += n; // 무게 더함 
                    break;
                }
                else if(q.size() == bridge_length) 
                {
                   sum -= q.poll(); //q 사이즈와 길이가 같으면 풀 상태 sum에 하나 뺴줌 
                }else {
                    // 다음 트럭 더했는데 최대 무게 초과
                    if(n + sum > weight) {
                        q.add(0);
                        answer++;
                    }else{ //무게 초과 아닐떄 q 에 넣고 answer ++
                        sum+=n;
                        q.add(n);
                        answer++;
                        break;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}
