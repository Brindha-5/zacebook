import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

//$Id$

public class ZaseBookMainPage {
	public static int countArray[]=new int[26];
	   public static int  countofZero=0;
	public static void main(String args[])
	{
		String username;
		String posttext;
		int result=0;
		try(Scanner input=new Scanner(System.in);)
		{
		Map<String,Queue<String>>zacebook=new HashMap<>();
		System.out.println("Enter User name");
		username=input.next();
		
		for (int i = 0; i < username.length(); i++) {
			int ascii = username.charAt(i);
			result += count(ascii);
		}
		System.out.println("The hash of the Username :"+result);
		int choice=0;
		Queue<String> post=new LinkedList<String>();
		do
		{
		System.out.println("Post your text");
		input.nextLine();
		posttext=input.nextLine();
		System.out.println("Check Sum:");
		String result1=posttext.toLowerCase();
		for(int i=0;i<result1.length();i++)
		{
    if(result1.charAt(i)==' ')
    {
        continue;
    }
    countArray[result1.charAt(i)-'a']++;
		}
    for(int i=0;i<26;i++)
    {
        if(countArray[i]==0)
        {
            countofZero++;
        }
    }
    int condi=(26-countofZero)< 5 ? 26-countofZero : 5;
    for(int i=0;i<condi;i++)
    {
        max();
    }
		
		
		if(post.size()<10)
		{
		post.add(result+posttext);	
		}
		else
		{
			post.poll();
			post.add(result+posttext);
		}
		
		System.out.println("Do you want to continue yes -1");
		choice=input.nextInt();
		}while(choice==1);
zacebook.put(username,post);
		
		System.out.println(zacebook.get(username));
		}
		
	
	}
	public static void max()
	{
    int max=-1;
    int index=0;
    //System.out.println("Check Sum :");
    
    for(int i=0;i<countArray.length;i++)
    {
        if(countArray[i]>max)
        {
            max=countArray[i];
            index=i;
        }
    }
    
    System.out.print((char)(index+'a'));
    countArray[index]=0;
	}

	public static int count(int num) {
		int sumOfOnes = 0;
		while (num != 0) {
			int rem = num % 2;
			if (rem == 1) {
				sumOfOnes++;
			}
			num = num / 2;
		}
		return sumOfOnes;
	}
		
		
	}


