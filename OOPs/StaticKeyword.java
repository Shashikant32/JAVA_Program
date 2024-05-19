class Student{
    int marks;
    static String collegeName="ABC";
    static int count=0;
    // public Student(int marks)
    // {
    //     this.marks=marks;
    // }
    public void increment()
    {
        count++;
    }
}

public class Main {
    public static void main(String args[]) {
    Student s1=new Student();
    Student s2=new Student();
    
    s1.increment();
    s1.increment();
    s2.increment();
    
    System.out.println(s1.count);
    System.out.println(s2.count);
    }
}