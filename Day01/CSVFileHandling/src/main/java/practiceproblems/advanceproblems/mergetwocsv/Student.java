package practiceproblems.advanceproblems.mergetwocsv;

public class Student {
    String id;
    String name;
    int age;
    int marks;
    String grade;

    // Constructor
    public Student(String id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}
