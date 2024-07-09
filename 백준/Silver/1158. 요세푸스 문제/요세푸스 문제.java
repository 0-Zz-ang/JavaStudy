import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
 
    	
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K= sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
	
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }
      
        StringBuffer sb = new StringBuffer();
        sb.append("<");
       
        while(queue.size() > 1 ) 
        {
            for(int i=1; i<K; i++) 
            {        
                queue.offer(queue.poll());
            }
         
            sb.append(queue.poll()).append(", ");
        }
        
        if(queue.size() == 1) 
        {
            sb.append(queue.poll()).append(">");
        }
        System.out.println(sb);
        sc.close();
        
    }
}