import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++){
            Stack<Character> stk = new Stack<>();
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            
            
            
            for(int j=0;j<str.length();j++)
            {
            	if(str.charAt(j) == ' ') 		// str.chartAt(j)가 공백이라면 
            	{
            		while(!stk.empty()) 		// stk가 비어있으면 false 비어있지않으면 true
            		{							
            			sb.append(stk.pop());	
            		}
            		sb.append(" ");				
            	}
            	else // 공백이 아니면
            	{							
                    stk.push(str.charAt(j)); 
            	}
            }
    		while(!stk.empty()) 
    		{
    			sb.append(stk.pop());		
    		}
    		System.out.println(sb);
        }
    }
}