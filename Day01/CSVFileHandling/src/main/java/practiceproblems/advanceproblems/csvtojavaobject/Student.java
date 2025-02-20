package practiceproblems.advanceproblems.csvtojavaobject;

public class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    // Constructor
    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks=marks;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    // toString() method for printing
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age='" + age + "', marks='" + marks + "'}";
    }
}
