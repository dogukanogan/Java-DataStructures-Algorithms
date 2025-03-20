import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static Map<Integer, Course> courses;

    public static void main(String[] args) {
        // Load courses from CSV
        String csvPath = "src/NEWcourses_full.csv"; // Kullanıcı belirttiği sabit yol
        courses = CSVProcessor.loadCourses(csvPath);

        // Add a test student
        students.add(new Student("c2228036@student.cankaya.edu.tr", "123456")); // Test için varsayılan kullanıcı

        // Login ve devam
        Student currentStudent = login();
        if (currentStudent != null) {
            getClassAndTerm(currentStudent);

            boolean programConfirmed = false;

            while (!programConfirmed) {
                // Ders seçimi ve program oluşturma
                displayAndSelectCourses(currentStudent);

                // Programı tablo şeklinde göster
                ScheduleManager.printScheduleTable();

                // Onay sorusu
                System.out.println("Do you confirm this schedule? (yes/no): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();

                if (confirmation.equals("yes")) {
                    programConfirmed = true;
                    System.out.println("Finalized schedule:");
                    ScheduleManager.printScheduleTable();
                    System.out.println("Thank you for using the system. Goodbye!");
                } else if (confirmation.equals("no")) {
                    System.out.println("You can reselect your courses.");
                    ScheduleManager.clearSchedule(); // Mevcut programı sıfırla
                } else {
                    System.out.println("Invalid input. Please type 'yes' or 'no'.");
                }
            }
        }
    }

    private static Student login() {
        System.out.println("Welcome to the Course Registration System!");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + email + "!");
                return student;
            }
        }

        System.out.println("Invalid email or password.");
        return null;
    }

    private static void getClassAndTerm(Student student) {
        System.out.print("Enter your class year (1-4): ");
        student.setClassYear(scanner.nextInt());
        System.out.print("Enter your term (1 for Güz, 2 for Bahar): ");
        student.setTerm(scanner.nextInt());
        scanner.nextLine(); // Consume newline
    }

    private static void displayAndSelectCourses(Student student) {
        System.out.println("Available courses for your class and term:");

        // Filter courses based on class year and term
        List<Course> filteredCourses = new ArrayList<>();
        for (Course course : courses.values()) {
            if (course.getClassYear() == student.getClassYear() && course.getTerm() == student.getTerm()) {
                filteredCourses.add(course);
            }
        }

        // Dersleri listele
        for (int i = 0; i < filteredCourses.size(); i++) {
            System.out.println((i + 1) + ". " + filteredCourses.get(i).getCourseName());
        }

        // Ders seçimi
        System.out.println("Select the courses by entering their numbers (comma-separated): ");
        String[] selected = scanner.nextLine().split(",");
        List<Course> selectedCourses = new ArrayList<>();

        for (String s : selected) {
            try {
                int index = Integer.parseInt(s.trim()) - 1;
                if (index >= 0 && index < filteredCourses.size()) {
                    selectedCourses.add(filteredCourses.get(index));
                } else {
                    System.out.println("Invalid selection: " + s);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + s);
            }
        }

        // Seçilen derslere uygun section'ları ata
        ScheduleManager.assignSections(selectedCourses);
    }
}
