import java.util.Scanner;
public class EmployeeExpertSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int attendance, workQuality, teamwork;
        System.out.print("Enter Attendance Percentage: ");
        attendance = sc.nextInt();
        System.out.print("Enter Work Quality Marks (out of 10): ");
        workQuality = sc.nextInt();

        System.out.print("Enter Teamwork Marks (out of 10): ");
        teamwork = sc.nextInt();

        // Expert System Rules

        if (attendance >= 90 && workQuality >= 8 && teamwork >= 8) {

            System.out.println("Performance: EXCELLENT");

        } else if (attendance >= 75 && workQuality >= 6 && teamwork >= 6) {

            System.out.println("Performance: GOOD");

        } else if (attendance >= 50 && workQuality >= 5) {

            System.out.println("Performance: AVERAGE");

        } else {

            System.out.println("Performance: POOR");
        }

        sc.close();
    }
}