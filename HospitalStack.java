
import java.util.Scanner;

public class HospitalStack {

    // Node represents a patient record
    static class Node {
        int patientId;
        String patientName;
        Node next;

        Node(int patientId, String patientName) {
            this.patientId = patientId;
            this.patientName = patientName;
            this.next = null;
        }
    }

    static Node top = null;

    // Push: Add a patient record
    static void push(int id, String name) {
        Node newNode = new Node(id, name);
        newNode.next = top;
        top = newNode;

        System.out.println("Patient record added successfully.");
    }

    // Pop: Remove the top patient record
    static void pop() {
        if (top == null) {
            System.out.println("Stack is empty. No records to remove.");
            return;
        }

        System.out.println("Removed Patient ID: " + top.patientId);
        System.out.println("Removed Patient Name: " + top.patientName);

        top = top.next;
    }

    // Peek: View the top patient record
    static void peek() {
        if (top == null) {
            System.out.println("Stack is empty. No patient record available.");
            return;
        }

        System.out.println("Top Patient ID: " + top.patientId);
        System.out.println("Top Patient Name: " + top.patientName);
    }

    // Display all patient records
    static void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        Node current = top;

        System.out.println("\nPatient Records (Top to Bottom):");

        while (current != null) {
            System.out.println("Patient ID: " + current.patientId
                    + ", Name: " + current.patientName);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Patient Stack ---");
            System.out.println("1. Push Patient Record");
            System.out.println("2. Pop Patient Record");
            System.out.println("3. Peek Top Patient");
            System.out.println("4. Display All Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    push(id, name);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
