import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {

    private final LinkedList<Student> list;

    public LinkedList<Student> getList() {
        return list;
    }

    public StudentManagement() {
        list = new LinkedList<>();
    }

    public void addStudent() {
        //User input to create new student
        Scanner input = new Scanner(System.in);
        System.out.println("Add a new Student.");
        System.out.print("Firstname: ");
        String firstname = input.next();
        System.out.print("Lastname: ");
        String lastname = input.next();
        System.out.print("Course: ");
        String course = input.next();
        System.out.print("Age: ");
        int age = input.nextInt();
        System.out.print("Library Member (true/false): ");
        boolean member = input.nextBoolean();
        //saving the new student to the list
        list.add(new Student(firstname, lastname, course, age, member));
    }

    public void addStudentViaID() {
        //User input to create new student
        Scanner input = new Scanner(System.in);
        System.out.print("Type in an empty ID: ");
        int id = input.nextInt();
        int index = id - 100;

        System.out.println("Add a new Student.");
        System.out.print("Firstname: ");
        String firstname = input.next();
        System.out.print("Lastname: ");
        String lastname = input.next();
        System.out.print("Course: ");
        String course = input.next();
        System.out.print("Age: ");
        int age = input.nextInt();
        System.out.print("Library Member (true/false): ");
        boolean member = input.nextBoolean();
        Student s = new Student(firstname, lastname, course, age, member);
        //setting the ID manually in this method
        s.setID(id);
        //saving the new student to the list
        list.add(index, s);
    }

    public void delStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in Student ID: ");
        int choice = input.nextInt();
        int index = choice - 100;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                System.out.println("Student " + list.get(index).toString() + " will be deleted.");
                list.remove(index);
            }
        }
    }

    public void updateStudent() {
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Type in Student ID: ");
        int choice = input.nextInt();
        int index = choice - 100;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                System.out.println("Update Student information.");
                System.out.print("Firstname: ");
                String firstname = input.next();
                System.out.print("Lastname: ");
                String lastname = input.next();
                System.out.print("Course: ");
                String course = input.next();
                System.out.print("Age: ");
                int age = input.nextInt();
                System.out.print("Library Member (true/false): ");
                boolean member = input.nextBoolean();
                student.setID(choice);
                student.setFirst_Name(firstname);
                student.setLast_Name(lastname);
                student.setCourse(course);
                student.setAge(age);
                student.setHasAccess(member);

                list.set(index, student);
            }
        }
    }
    public void searchStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in Student ID: ");
        int choice = input.nextInt();
        int index = choice - 100;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                System.out.println("Student: " + list.get(index).toString());
            }
        }
    }
    public void readAll() {
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void addMembership() {
        Scanner input = new Scanner(System.in);
        Student s;
        System.out.print("Type in Student ID: ");
        int choice = input.nextInt();
        int index = choice - 100;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                s = list.get(index);
                System.out.println("Add or delete a Library Membership.");
                System.out.print("(1) Student can access Library    (2) Student can not access Library: ");
                int userInput = input.nextInt();

                switch (userInput) {
                    case 1 -> s.setHasAccess(true);
                    case 2 -> s.setHasAccess(false);

                    default -> System.out.println("Something went wrong please try again.");
                }
                list.set(index, s);
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    public void writeObjects(LinkedList<Student> ls) {
        File file = new File("output.txt");
        try(FileOutputStream output = new FileOutputStream(file);
                ObjectOutputStream objOut = new ObjectOutputStream(output)) {
            for (Student student : ls) {
                objOut.writeObject(new Student(student));
            }
            objOut.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    public void readObjects(File file) {
        try {
            FileInputStream input = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(input);
            while (true) {
                Student student = (Student) objIn.readObject();
                list.add(new Student(student));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }
    }

}