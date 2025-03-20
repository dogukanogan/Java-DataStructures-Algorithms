import java.util.ArrayList;
import java.util.List;

public class Section {
    private int sectionID;
    private String day;
    private List<TimeSlot> timeSlots; // Multiple time slots for the section
    private Course course; // Reference to the parent Course

    public Section(int sectionID, String day, Course course) {
        this.sectionID = sectionID;
        this.day = day;
        this.timeSlots = new ArrayList<>();
        this.course = course;
    }

    public int getSectionID() {
        return sectionID;
    }

    public String getDay() {
        return day;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public Course getCourse() {
        return course;
    }

    public void addTimeSlot(String startTime, String endTime) {
        this.timeSlots.add(new TimeSlot(startTime, endTime));
    }
}
