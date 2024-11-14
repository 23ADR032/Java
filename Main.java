import java.util.HashMap;
import java.util.Scanner;

class Faculty {
    private String facultyID, name, department, email, phoneNumber;

    public Faculty(String facultyID, String name, String department, String email, String phoneNumber) {
        this.facultyID = facultyID;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFacultyID() { return facultyID; }

    @Override
    public String toString() {
        return "FacultyID: " + facultyID + ", Name: " + name + ", Dept: " + department +
               ", Email: " + email + ", Phone: " + phoneNumber;
    }
}

class FacultyManagement {
    private HashMap<String, Faculty> facultyList = new HashMap<>();

    public void addFaculty(Faculty faculty) {
        facultyList.put(faculty.getFacultyID(), faculty);
        System.out.println("Faculty added.");
    }

    public void viewFaculty(String facultyID) {
        Faculty faculty = facultyList.get(facultyID);
        System.out.println(faculty != null ? faculty : "Faculty not found.");
    }

    public void listAllFaculty() {
        if (facultyList.isEmpty()) {
            System.out.println("No faculty members found.");
        } else {
            facultyList.values().forEach(System.out::println);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FacultyManagement management = new FacultyManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Faculty Management System ---");
            System.out.println("1. Add Faculty");
            System.out.println("2. View Faculty");
            System.out.println("3. List All Faculty");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Faculty ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    management.addFaculty(new Faculty(id, name, department, email, phone));
                    break;

                case 2:
                    System.out.print("Enter Faculty ID: ");
                    String viewID = scanner.nextLine();
                    management.viewFaculty(viewID);
                    break;

                case 3:
                    management.listAllFaculty();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
