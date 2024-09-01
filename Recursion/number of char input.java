import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		char[]s={'1','2','3','4','\0'};
		a(s,0);
	}
	static void a(char[]s , int ind)
	{
		if(s[ind]=='\0') return;
		a(s,ind+1);
		a(s,ind+1);
		System.out.print(s[ind]);
	}
}

// Output:- 443443244344321
// char:-15