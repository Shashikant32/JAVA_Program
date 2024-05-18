import java.util.*;
class person{
    String name;
    int age;
    String gender;
    public person(String n,int a)//1 paramitar const
    {
        name=n;
        age=a;
    }
    public person(String n,int a,String g)//2 paramitar const
    {
        name=n;
        age=a;
        gender=g;
    }
}

public class Main{
    
    public static void main(String args[]) {
        person p1=new person("shashi", 22);
        
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.gender);
   
    }
}