
import java.util.Scanner;
import java.util.Stack;

public class Main
{
	public static void main(String[] args)
	{
		StringBuffer str = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<Character>();
		int T = sc.nextInt();
		
		for(int i=1; i<=T; i++)
		{
			s.clear();
			str.delete(0,str.length());
			str.append(sc.next());
			
			for(int j = 0 ;j<str.length(); j++)
			{
				if(str.charAt(j)==')'&&s.isEmpty())
				{
					s.add(str.charAt(j));
					break;
				}
				else
				{
					if(str.charAt(j)=='(')
						s.add(str.charAt(j));
					else if(str.charAt(j)==')')
						s.pop();
				}
			}
			
			if(s.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
