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
    public Student(String first_Name, String last_Name, String course, int age) {
        setID(count++);
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.course = course;
        this.age = age;
    }
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
    }

     // Getter and Setter
    public int getID(Student s) {
        return s.id;
    }
     public void setID(int id) {
         this.id = id;
     }
    public String getFirst_Name(Student s) {
        return s.first_Name;
    }
    public void setFirst_Name(String firstname) {
        this.first_Name = firstname;
    }
    public String getLast_Name(Student s) {
        return s.last_Name;
    }
    public void setLast_Name(String lastname) {
        this.last_Name = lastname;
    }
    public String getCourse(Student s) {
        return s.course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getAge(Student s) {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

     // Methods
    @Override
    public String toString() {
        return "Student {" + "ID = " + id + ", Firstname = " + first_Name + ", Lastname = " + last_Name
                + ", Course = " + course + ", Age = " + age + "}\n";
    }
}

