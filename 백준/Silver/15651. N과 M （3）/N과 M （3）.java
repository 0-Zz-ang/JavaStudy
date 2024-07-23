import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main 
{
   static int N,M;
   static int[] arr;   // 입력받은 수 넣을 배열
   static int[] temp;
   static boolean[] visit; // 방문여부 
   static LinkedHashSet<String> result = new LinkedHashSet<>();
   
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      
      // System.out.println(M);
      
      arr  = new int[N];   //N개의 자연수를 입력받을 배열 선언
      temp = new int[M];   // 조합된 배열을 임시로 담아놓을 배열 선언 
      visit = new boolean[N];
      
      for(int i =0 ; i<N; i++)
      {
         arr[i]=i+1;
      }
      
      back(0);
      
      
       for(String s : result) 
       { 
          //System.out.println(s);
          bw.write(s);
          bw.write("\n");
       }
       bw.flush();
      
      
         
   }
   //1 2 3
   public static void back(int m)
   {
      if(m==M)
      {
         StringBuilder sb = new StringBuilder();
         for(int num : temp)
         {
            sb.append(num).append(" ");
         }
         result.add(sb.toString());
         return;
      }
      
      for(int i =0 ; i< N; i++)
      {   
            temp[m] = arr[i];
            back(m+1);
      
      }
   }

   
}