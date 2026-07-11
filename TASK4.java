# -------------------------------
# ONLINE EXAMINATION 
# -------------------------------

import java.util.Scanner;

public class OnlineExam {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String username = "admin";
        String password = "1234";
        String name = "Student";

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        // Login
        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!user.equals(username) || !pass.equals(password)) {
            System.out.println("Invalid Login!");
            return;
        }

        int choice;

        do {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.println("Profile Updated Successfully.");
                    break;

                case 2:
                    System.out.print("Enter New Password: ");
                    password = sc.nextLine();
                    System.out.println("Password Changed Successfully.");
                    break;

                case 3:

                    int score = 0;

                    System.out.println("\nExam Started");
                    System.out.println("Time: 30 Seconds");
                    System.out.println("(Simple Timer Demo)");

                    long start = System.currentTimeMillis();

                    // Question 1
                    System.out.println("\n1. Java is developed by?");
                    System.out.println("A. Microsoft");
                    System.out.println("B. Sun Microsystems");
                    System.out.println("C. Google");
                    System.out.println("D. Apple");
                    System.out.print("Answer: ");
                    String ans1 = sc.nextLine();

                    if (ans1.equalsIgnoreCase("B"))
                        score++;

                    // Question 2
                    System.out.println("\n2. Size of int in Java?");
                    System.out.println("A. 2 Bytes");
                    System.out.println("B. 8 Bytes");
                    System.out.println("C. 4 Bytes");
                    System.out.println("D. 16 Bytes");
                    System.out.print("Answer: ");
                    String ans2 = sc.nextLine();

                    if (ans2.equalsIgnoreCase("C"))
                        score++;

                    // Question 3
                    System.out.println("\n3. Which keyword is used to create an object?");
                    System.out.println("A. create");
                    System.out.println("B. object");
                    System.out.println("C. new");
                    System.out.println("D. class");
                    System.out.print("Answer: ");
                    String ans3 = sc.nextLine();

                    if (ans3.equalsIgnoreCase("C"))
                        score++;

                    long end = System.currentTimeMillis();

                    if ((end - start) > 30000) {
                        System.out.println("\nTime Over!");
                        System.out.println("Exam Auto Submitted.");
                    } else {
                        System.out.println("\nExam Submitted Successfully.");
                    }

                    System.out.println("Student: " + name);
                    System.out.println("Score: " + score + "/3");

                    break;

                case 4:
                    System.out.println("Logged Out Successfully.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
