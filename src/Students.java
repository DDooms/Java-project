import java.util.Arrays;
import java.util.Scanner;

public class Students {
    private final String first_name;
    private final String last_name;
    private String major;
    private int student_id;
    private final String[] courses = new String[3];
    private int tuition_balance;
    private static final int cost_of_course = 300;
    private static int total = 0;
    private static int counter = 0;
    private static int id_1 = 10000;
    private static int id_2 = 20000;
    private static int id_3 = 30000;
    private static int id_4 = 40000;
    private static int id_5 = 50000;

    public Students() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first name of the student: ");
        this.first_name = in.nextLine();

        System.out.print("Enter last name of the student: ");
        this.last_name = in.nextLine();

        System.out.print("Set the students budget: ");
        tuition_balance = in.nextInt();

        System.out.println("Enter a number for the major");
        System.out.print("1 - Computer science\n2 - Information systems\n3 - Software engineering\n4 - Informatics\n5 - Mathematics and informatics\n");

        int number;
        do {
            number = in.nextInt();
            set_student_major(number);
        } while (number > 5 || number < 1);

        set_student_id();
    }

    private void set_student_major(int number) {
        switch (number) {
            case 1 -> {
                System.out.printf("Congrats, you chose %s\n", Majors.valueOf("Computer_science"));
                major = String.valueOf(Majors.valueOf("Computer_science"));
            }
            case 2 -> {
                System.out.printf("Congrats, you chose %s\n", Majors.valueOf("Information_systems"));
                major = String.valueOf(Majors.valueOf("Information_systems"));
            }
            case 3 -> {
                System.out.printf("Congrats, you chose %s\n", Majors.valueOf("Software_engineering"));
                major = String.valueOf(Majors.valueOf("Software_engineering"));
            }
            case 4 -> {
                System.out.printf("Congrats, you chose %s\n", Majors.valueOf("Informatics"));
                major = String.valueOf(Majors.valueOf("Informatics"));
            }
            case 5 -> {
                System.out.printf("Congrats, you chose %s\n", Majors.valueOf("Mathematics_and_informatics"));
                major = String.valueOf(Majors.valueOf("Mathematics_and_informatics"));
            }
            default -> System.out.println("There is no such major! Please try again");
        }
    }

    private void set_student_id() {
        // Major number + id
        if (major.equals("Computer_science"))
            this.student_id = ++id_1;
        if (major.equals("Information_systems"))
            this.student_id = ++id_2;
        if (major.equals("Software_engineering"))
            this.student_id = ++id_3;
        if (major.equals("Informatics"))
            this.student_id = ++id_4;
        if (major.equals("Mathematics_and_informatics"))
            this.student_id = ++id_5;
    }

    private void set_student_course(int number, int i){
        switch (number) {
            case 1 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Game_theory"));
                courses[i] = String.valueOf(Courses.valueOf("Game_theory"));
            }
            case 2 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Solitaire"));
                courses[i] = String.valueOf(Courses.valueOf("Solitaire"));
            }
            case 3 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Linear_algebra"));
                courses[i] = String.valueOf(Courses.valueOf("Linear_algebra"));
            }
            case 4 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Geometry"));
                courses[i] = String.valueOf(Courses.valueOf("Geometry"));
            }
            case 5 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Graphic_design"));
                courses[i] = String.valueOf(Courses.valueOf("Graphic_design"));
            }
            case 6 -> {
                System.out.printf("Enrolling student to %s\n", Courses.valueOf("Discrete_maths"));
                courses[i] = String.valueOf(Courses.valueOf("Discrete_maths"));
            }
            default -> System.out.println("There is no such course! Please try again");
        }
    }

    public void enroll(){
        int number, i = 0;
        do {
            System.out.println("You can choose maximum 3 subjects");
            System.out.println("Enter a number for a subject to enroll (0 to quit): ");
            System.out.print("1 - Game theory\n2 - Solitaire\n3 - Linear algebra\n4 - Geometry\n5 - Graphic design\n6 - Discrete maths\n");
            Scanner in = new Scanner(System.in);

            number = in.nextInt();
            if (number == 0)
                break;

            set_student_course(number, i++);
            total += cost_of_course;
            counter++;
            if (counter == 3) break;
        } while (number < 6 && number > -1);
    }

    public void view_balance(){
        System.out.printf("Your balance is: %dlv\n", tuition_balance);
    }

    public void pay_tuition(){
        view_balance();
        Scanner in = new Scanner(System.in);
        int payment;
        do {
            System.out.printf("In order for you to study here, you have to pay: %dlv, because you selected: %d courses!\n", total, counter);
            System.out.print("Enter your payment: ");
            payment = in.nextInt();
        }while (payment != total);

        if (payment > tuition_balance){
            throw new IllegalArgumentException("You cant pay, you dont have money! Start working");
        }
        tuition_balance -= payment;
        System.out.printf("Thank you for your payment of %dlv\n", payment);
        System.out.println("You are officially in this university. Have fun!");
        view_balance();
    }

    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", major=" + major +
                ", student_id='" + student_id + '\'' +
                ", courses='" + Arrays.toString(courses) + '\'' +
                ", tuition_balance=" + tuition_balance +
                '}';
    }
}
