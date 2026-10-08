import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Method to check eligibility
    public boolean checkEligibility() {
        if (marks >= 50) {
            return true;
        } else {
            return false;
        }
    }

    // Method to calculate scholarship amount
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (marks >= 70 && marks <= 84) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display all student and fee details
    public void displayDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligible: Yes");
        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
        System.out.println("Final Fee to Pay: Rs. " + calculateFinalFee());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create object using parameterized constructor
        Student s = new Student(name, roll, marks, course, credits);

        // Check eligibility and proceed
        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("\nStudent is not eligible for course registration (Marks are below 50).");
        }

        sc.close();
    }
}