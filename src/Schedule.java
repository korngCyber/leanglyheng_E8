import java.util.HashMap;

public class Schedule {
    String day;
    HashMap<Integer, Subject> subjects;

    public Schedule(String day) {
        this.day = day;
        this.subjects = new HashMap<>();
    }

    public void addSubject(Subject subject) {
        subjects.put(subject.subId, subject);
    }

    public void printSchedule() {
        System.out.println("===================================><=========================");
        System.out.println("Timetable for " + day + ":");
        for (Subject subject : subjects.values()) {
            System.out.println("Subject ID: " + subject.subId + ", Subject Name: " + subject.subName);
        }
    }

    public boolean hasSubject(int subId) {
        return subjects.containsKey(subId);
    }
}