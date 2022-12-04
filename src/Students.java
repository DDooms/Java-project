import java.util.Scanner;

public class Students {
    private String first_name;
    private String last_name;
    private int grade_year;
    private String student_id;
    private String courses = "";
    private int tuition_balance = 0;
    private static int cost_of_course = 300;
    private static int id = 10000;

    public Students(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first name of the student");
        this.first_name = in.nextLine();

        System.out.println("Enter last name of the student");
        this.last_name = in.nextLine();

        System.out.println("Enter a number for the subject");
        System.out.print("1 - Computer science\n2 - Information systems\n3 - Software engineering\n4 - Informatics\n5 - Mathematics and informatics");
        this.grade_year = in.nextInt();

        set_student_id();
    }

    private void set_student_id() {
        // Subject number + id
        id++;
        this.student_id = grade_year + "" + id;
    }

    public void enroll(){
        do {
            System.out.print("Enter subject to enroll (q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("q")){
                course = courses + "\n " + course;
                tuition_balance = tuition_balance + cost_of_course;
            } else break;
        } while (true);
    }

    public void view_balance(){
        System.out.printf("Your balance is: %dlv", tuition_balance);
    }

    public void pay_tuition(){
        view_balance();
        System.out.print("Enter your payment: ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuition_balance -= payment;
        System.out.printf("Thank you for your payment of %dlv", payment);
        view_balance();
    }

    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", grade_year=" + grade_year +
                ", student_id='" + student_id + '\'' +
                ", courses='" + courses + '\'' +
                ", tuition_balance=" + tuition_balance +
                '}';
    }
}
