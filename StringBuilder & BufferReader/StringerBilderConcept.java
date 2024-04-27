public class Main {
    public static void main(String args[]) {
    //  String s = "Hello";
    //  StringBuilder s1 =new StringBuilder();
    //  System.out.println(" Before hello s1 ki value="+s1);
    //  s1.append("hello");
    // //  s2.append("abc");
    // //  s3.append("xyz");
    //  System.out.println(s1);
     
     StringBuilder s2 =new StringBuilder("ABC");
     s2.append(" 123");
     System.out.println(s2);
     
     System.out.println(s2.length());// finding the length
     s2.delete(2,5);
     System.out.println(s2);
     
     System.out.println(s2.charAt(2));
     //System.out.println(s2.charAt(6));// index out of bounds
     
     s2.replace(2,5,"Hello");
     System.out.println(s2);
     
    }
}