import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CSVProcessor {
    public static Map<Integer, Course> loadCourses(String filePath) {
        Map<Integer, Course> courses = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip header

            while ((line = reader.readNext()) != null) {
                int courseID = Integer.parseInt(line[0]);
                String courseName = line[1];
                int term = Integer.parseInt(line[2]);
                int classYear = Integer.parseInt(line[3]);
                int sectionID = Integer.parseInt(line[4]);
                String day = line[5];
                String startTime = line[6];
                String endTime = line[7];

                // Create or retrieve Course object
                Course course = courses.computeIfAbsent(courseID, id -> new Course(courseID, courseName, term, classYear));

                // Check if section exists, else create it
                Section existingSection = course.getSections().stream()
                        .filter(sec -> sec.getSectionID() == sectionID && sec.getDay().equals(day))
                        .findFirst()
                        .orElse(null);

                if (existingSection == null) {
                    existingSection = new Section(sectionID, day, course);
                    course.addSection(existingSection);
                }

                // Add time slot to the section
                existingSection.addTimeSlot(startTime, endTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
}
