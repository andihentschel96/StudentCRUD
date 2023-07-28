import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {
    LinkedList<Student> list;

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
        //saving the new student to the list
        list.add(new Student(firstname, lastname, course, age));
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
        Student s;
        System.out.print("Type in Student ID: ");
        int choice = input.nextInt();
        int index = choice - 100;
        for (int i = 0; i < list.size(); i++) {
            if (index == i) {
                System.out.println("Add a new Student.");
                System.out.print("Firstname: ");
                String firstname = input.next();
                System.out.print("Lastname: ");
                String lastname = input.next();
                System.out.print("Course: ");
                String course = input.next();
                System.out.print("Age: ");
                int age = input.nextInt();
                s = new Student(firstname, lastname, course, age);
                list.set(index, s);
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public void writeFile(LinkedList<Student> ls) {
        File file = new File("output.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            for (Student l : ls) {
                writer.write(String.valueOf(l));
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}
