import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		fun1(5);
	}
	static void fun1(int n)
	{
		if(n==0) return;
		
		System.out.print(n);
		fun2(n-2);
		System.out.print(n);

	}
	static void fun2(int n)
	{
		if(n==0) return;
		
		System.out.print(n);
		fun1(++n);
		System.out.print(n);

	}
}

// Output:-53423122233445