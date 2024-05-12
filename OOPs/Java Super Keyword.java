class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return this.name; }

    public int getAge() { return this.age; }

    public String toString() {
        return getName() + " " + getAge();
    }
}

class Teacher extends Person {
    private String qualification;

    public Teacher(String name, int age, String qualification) {
        super(name, age);
        this.qualification = qualification;
    }

    public String toString() {
        return super.getName() + " " + super.getAge() + " " + this.qualification;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Destini", 20);
        System.out.println(p);
        Teacher p2 = new Teacher("Erica", 55, "Masters in Teaching");
        System.out.println(p2);
    }
}
