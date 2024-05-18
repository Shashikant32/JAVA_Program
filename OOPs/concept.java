import java.util.*;
class person{
    String name;
    int age;
    String gender;
    public void sayHello()
    {
         System.out.println("Hi My name is "+ name);
    }
}

public class Main{
    
    public static void main(String args[]) {
        person p1=new person();
        p1.name = "Shashi";
        p1.age = 22;
        p1.gender ="Male";
        
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.gender);
        p1.sayHello();
   
    }
}