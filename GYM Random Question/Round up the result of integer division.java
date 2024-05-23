import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scr = new Scanner(System.in);
        int marks1 = scr.nextInt();
        int marks2 = scr.nextInt();
        int totalMarks =scr.nextInt();

        int percentage = ((marks1+marks2)*100)/totalMarks;

        if(((marks1+marks2)*100)%totalMarks >0)
        {
            percentage++;
        }
        System.out.println(percentage+"%");
	}
}