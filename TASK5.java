# -------------------------------
# DIGITAL LIBRARY MANAGEMENT 
# -------------------------------

  import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] books = new String[20];
        boolean[] issued = new boolean[20];
        int count = 3;

        books[0] = "Java Programming";
        books[1] = "Python Basics";
        books[2] = "Data Structures";

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");
            int mainChoice = sc.nextInt();
            sc.nextLine();

            // ---------------- ADMIN ----------------

            if (mainChoice == 1) {

                System.out.print("Username: ");
                String user = sc.nextLine();

                System.out.print("Password: ");
                String pass = sc.nextLine();

                if (!user.equals("admin") || !pass.equals("1234")) {
                    System.out.println("Invalid Login!");
                    continue;
                }

                int choice;

                do {

                    System.out.println("\n----- ADMIN MENU -----");
                    System.out.println("1. Add Book");
                    System.out.println("2. View Books");
                    System.out.println("3. Delete Book");
                    System.out.println("4. Logout");

                    System.out.print("Choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.print("Enter Book Name: ");
                            books[count] = sc.nextLine();
                            issued[count] = false;
                            count++;
                            System.out.println("Book Added Successfully.");
                            break;

                        case 2:
                            for (int i = 0; i < count; i++) {
                                System.out.println((i + 1) + ". " + books[i] +
                                        (issued[i] ? " (Issued)" : " (Available)"));
                            }
                            break;

                        case 3:
                            System.out.print("Enter Book Number to Delete: ");
                            int d = sc.nextInt();

                            if (d >= 1 && d <= count) {
                                books[d - 1] = "Deleted";
                                issued[d - 1] = false;
                                System.out.println("Book Deleted.");
                            } else {
                                System.out.println("Invalid Book Number.");
                            }
                            break;

                    }

                } while (choice != 4);

            }

            // ---------------- USER ----------------

            else if (mainChoice == 2) {

                int choice;

                do {

                    System.out.println("\n----- USER MENU -----");
                    System.out.println("1. View Books");
                    System.out.println("2. Search Book");
                    System.out.println("3. Issue Book");
                    System.out.println("4. Return Book");
                    System.out.println("5. Contact Library");
                    System.out.println("6. Logout");

                    System.out.print("Choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {

                        case 1:

                            for (int i = 0; i < count; i++) {
                                System.out.println((i + 1) + ". " + books[i] +
                                        (issued[i] ? " (Issued)" : " (Available)"));
                            }

                            break;

                        case 2:

                            System.out.print("Enter Book Name: ");
                            String search = sc.nextLine();

                            boolean found = false;

                            for (int i = 0; i < count; i++) {
                                if (books[i].equalsIgnoreCase(search)) {
                                    System.out.println("Book Found.");
                                    found = true;
                                }
                            }

                            if (!found)
                                System.out.println("Book Not Found.");

                            break;

                        case 3:

                            System.out.print("Enter Book Number: ");
                            int issue = sc.nextInt();

                            if (issue >= 1 && issue <= count && !issued[issue - 1]) {
                                issued[issue - 1] = true;
                                System.out.println("Book Issued Successfully.");
                            } else {
                                System.out.println("Book Not Available.");
                            }

                            break;

                        case 4:

                            System.out.print("Enter Book Number: ");
                            int ret = sc.nextInt();

                            if (ret >= 1 && ret <= count && issued[ret - 1]) {
                                issued[ret - 1] = false;
                                System.out.println("Book Returned Successfully.");
                            } else {
                                System.out.println("Invalid Book.");
                            }

                            break;

                        case 5:

                            System.out.println("Email: library@gmail.com");

                            break;

                    }

                } while (choice != 6);

            }

            else if (mainChoice == 3) {
                System.out.println("Thank You!");
                break;
            }

            else {
                System.out.println("Invalid Choice.");
            }

        }

        sc.close();
    }
}
