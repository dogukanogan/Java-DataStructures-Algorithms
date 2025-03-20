import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleManager {
    private static Map<String, List<Section>> studentSchedule = new HashMap<>();

    public static void clearSchedule() {
        studentSchedule.clear();
        System.out.println("Schedule cleared. You can start over.");
    }

    public static void assignSections(List<Course> selectedCourses) {
        for (Course course : selectedCourses) {
            boolean assigned = false;

            for (Section section : course.getSections()) {
                // Eğer bu section zaten programa eklenmişse, devam et
                if (isSectionInSchedule(section)) {
                    continue;
                }

                // Section'ı ekle
                studentSchedule.computeIfAbsent(course.getCourseName(), k -> new ArrayList<>()).add(section);
                assigned = true;

                // Aynı section'a ait tüm zamanları programa dahil et
                for (Section otherSection : course.getSections()) {
                    if (otherSection.getSectionID() == section.getSectionID() && !isSectionInSchedule(otherSection)) {
                        studentSchedule.get(course.getCourseName()).add(otherSection);
                    }
                }
                break; // Bir section atandıysa diğerlerini kontrol etmeye gerek yok
            }

            if (!assigned) {
                // Eğer hiçbir uygun section atanamadıysa, alternatif section ara
                Section alternative = findAlternativeSection(course);
                if (alternative != null) {
                    studentSchedule.computeIfAbsent(course.getCourseName(), k -> new ArrayList<>()).add(alternative);
                    System.out.println("Conflict resolved: Assigned alternative section for " + course.getCourseName());
                } else {
                    System.out.println("Unable to assign any section for " + course.getCourseName() + " due to conflicts.");
                }
            }
        }
    }


    private static boolean isSectionInSchedule(Section section) {
        for (List<Section> sections : studentSchedule.values()) {
            for (Section scheduled : sections) {
                if (scheduled.getDay().equals(section.getDay())) {
                    for (TimeSlot slot1 : scheduled.getTimeSlots()) {
                        for (TimeSlot slot2 : section.getTimeSlots()) {
                            if (timeOverlaps(slot1.getStartTime(), slot1.getEndTime(), slot2.getStartTime(), slot2.getEndTime())) {
                                return true; // Çakışma bulundu
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    private static boolean timeOverlaps(String start1, String end1, String start2, String end2) {
        return !(end1.compareTo(start2) <= 0 || start1.compareTo(end2) >= 0);
    }

    private static Section findAlternativeSection(Course course) {
        for (Section section : course.getSections()) {
            if (!isSectionInSchedule(section)) {
                return section; // Return the first non-conflicting section
            }
        }
        return null; // No alternative found
    }

    public static void printScheduleTable() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] timeSlots = {
                "09:20-10:10", "10:20-11:10", "11:20-12:10",
                "12:20-13:10", "13:20-14:10", "14:20-15:10",
                "15:20-16:10", "16:20-17:10"
        };

        String[][] table = new String[timeSlots.length][days.length];

        for (int i = 0; i < timeSlots.length; i++) {
            for (int j = 0; j < days.length; j++) {
                table[i][j] = "";
            }
        }

        for (List<Section> sections : studentSchedule.values()) {
            for (Section section : sections) {
                String day = section.getDay();
                int dayIndex = Arrays.asList(days).indexOf(day);
                if (dayIndex != -1) {
                    for (TimeSlot slot : section.getTimeSlots()) {
                        for (int i = 0; i < timeSlots.length; i++) {
                            String[] slotRange = timeSlots[i].split("-");
                            if (timeOverlaps(slotRange[0], slotRange[1], slot.getStartTime(), slot.getEndTime())) {
                                table[i][dayIndex] = section.getCourse().getCourseName();
                            }
                        }
                    }
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%10s", "Time");
        for (String day : days) {
            System.out.printf("%15s", day);
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < timeSlots.length; i++) {
            System.out.printf("%10s", timeSlots[i]);
            for (int j = 0; j < days.length; j++) {
                System.out.printf("%15s", table[i][j].isEmpty() ? "-" : table[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
