import java.util.*;
import java.util.HashSet;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		HashSet<Integer> set = new HashSet<>();
        set.add(20);
        set.add(40);
        set.add(30);
        set.add(50);
        set.add(20);
        set.add(10);
        set.add(200);
        System.out.println("size of "+set.size());
        set.remove(200);

        System.out.println("After remove then size of "+set.size());
     
	}
}