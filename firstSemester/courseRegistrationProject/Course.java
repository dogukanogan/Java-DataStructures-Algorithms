import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseID;
    private String courseName;
    private int term; // 1 for Güz, 2 for Bahar
    private int classYear;
    private List<Section> sections;

    // Constructor
    public Course(int courseID, String courseName, int term, int classYear) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.term = term;
        this.classYear = classYear;
        this.sections = new ArrayList<>();
    }

    // Getters and Setters
    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public List<Section> getSections() {
        return sections;
    }

    // Add a section to the course
    public void addSection(Section section) {
        this.sections.add(section);
    }

    // For printing course details (Optional)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(courseName).append(" (ID: ").append(courseID).append(")\n");
        for (Section section : sections) {
            sb.append("  ").append(section).append("\n");
        }
        return sb.toString();
    }
}
