import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		
		
		int n =sc.nextInt(); // 명령의 수 
		
		String comm="";
		
		for(int i=0; i< n ; i++)
		{
			
			comm=sc.next();
			
			switch(comm)
			{
			case"push" : 
				st.push(sc.nextInt());
				break;
			case"pop" : 
				if (!st.empty())
					System.out.println(st.pop());
				else
					System.out.println(-1);
				break;
			case"size":
				System.out.println(st.size());
				break;
			case"empty":
				if(st.empty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case"top":
				if(!st.empty())
					System.out.println(st.peek());
				else
					System.out.println(-1);
				break;
			}
		}
		
		
	}

}
