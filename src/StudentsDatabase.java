import java.util.Scanner;

public class StudentsDatabase {
    public static void main(String[] args) {
        System.out.print("Enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int num_of_students = in.nextInt();
        Students[] students = new Students[num_of_students];

        for (int i = 0; i < num_of_students; i++) {
            students[i] = new Students();
            students[i].enroll();
            students[i].pay_tuition();
        }

        for (int i = 0; i < num_of_students; i++) {
            System.out.println(students[i].toString());
        }
    }
}
