import java.io.Serializable;

public class Student implements Serializable {
    // Fields
    private static int count = 100;
    private int id;
    private String first_Name, last_Name, course;
    int age;

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(String first_Name, String last_Name, String course, int age) {
        setID(count++);
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.course = course;
        this.age = age;
    }

     // Getter and Setter
     public int getID() {
         return this.id;
     }
     private void setID(int id) {
         this.id = id;
     }

     // Methods
    @Override
    public String toString() {
        return "Student {" + "ID = " + id + ", Firstname = " + first_Name + ", Lastname = " + last_Name
                + ", Course = " + course + ", Age = " + age + "}\n";
    }
}

