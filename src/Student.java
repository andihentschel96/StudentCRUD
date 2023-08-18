import java.io.Serializable;

public class Student implements Serializable {
    // Fields
    public static int count = 100;
    private int id;
    private String first_Name, last_Name, course;
    private int age;
    private boolean hasAccess;

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(String first_Name, String last_Name, String course, int age, boolean access) {
        setID(count++);
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.course = course;
        this.age = age;
        this.hasAccess = access;
    }
    public Student(Student student) {
        setID(count++);
        this.first_Name = student.first_Name;
        this.last_Name = student.last_Name;
        this.course = student.course;
        this.age = student.age;
        this.hasAccess = student.hasAccess;
    }

     // Getter and Setter
     public void setID(int id) {
         this.id = id;
     }
    public void setFirst_Name(String firstname) {
        this.first_Name = firstname;
    }
    public void setLast_Name(String lastname) {
        this.last_Name = lastname;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getHasAccess(Student s) {
        return s.hasAccess;
    }
    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

     // Methods
    @Override
    public String toString() {
        return "Student {" + "ID = " + id + ", Firstname = " + first_Name + ", Lastname = " + last_Name
                + ", Course = " + course + ", Age = " + age + ", Library Member: " + hasAccess + "}\n";
    }
}

