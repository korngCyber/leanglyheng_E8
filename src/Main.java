import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Schedule mondaySchedule = new Schedule("Monday");
        Schedule tuesdaySchedule = new Schedule("Tuesday");
        Schedule wednesdaySchedule = new Schedule("Wednesday");
        Schedule thursdaySchedule = new Schedule("Thursday");
        Schedule fridaySchedule = new Schedule("Friday");
        Schedule[] allSchedules = {mondaySchedule, tuesdaySchedule, wednesdaySchedule, thursdaySchedule, fridaySchedule};
        while (true) {
            System.out.println("===================================><=========================");
            System.out.println("Select an option:");
            System.out.println("1. Show all subjects");
            System.out.println("2. Add subject to a day");
            System.out.println("3. Show schedule for all days");
            System.out.println("4. Exit");
            System.out.print("Please chhose option above:");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("===================================><=========================");
                    System.out.println("All Subjects:");
                    System.out.println("1. JAVA");
                    System.out.println("2. Statistic");
                    System.out.println("3. Network");
                    System.out.println("4. C#");
                    System.out.println("5. ISAD");
                    System.out.println("===================================><=========================");
                    break;
                case 2:
                    System.out.print("Enter the day of the exam (Monday/Tuesday/Wednesday/Thursday/Friday):");
                    String day = scanner.nextLine();
                    Schedule selectedSchedule = null;
                    for (Schedule schedule : allSchedules) {
                        if (schedule.day.equalsIgnoreCase(day)) {
                            selectedSchedule = schedule;
                            break;
                        }
                    }
                    if (selectedSchedule == null) {
                        System.out.println("Invalid day entered.");
                    } else {
                        System.out.print("Enter the subject ID for the exam:");
                        int subId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Subject subject = null;
                        switch (subId) {
                            case 1:
                                subject = new Subject(1, "JAVA");
                                break;
                            case 2:
                                subject = new Subject(2, "Statistic");
                                break;
                            case 3:
                                subject = new Subject(3, "Network");
                                break;
                            case 4:
                                subject = new Subject(4, "C#");
                                break;
                            case 5:
                                subject = new Subject(5, "ISAD");
                                break;
                            default:
                                System.out.print("Invalid subject ID.");
                                continue;
                        }
                        if (selectedSchedule.hasSubject(subId)) {
                            System.out.println("Subject already added to the schedule for this day.");
                            System.out.println("===================================><=========================");
                        } else {
                            selectedSchedule.addSubject(subject);
                            System.out.println("Subject added successfully.");
                            System.out.println("===================================><=========================");
                        }
                    }
                    break;
                case 3:
                    for (Schedule schedule : allSchedules) {
                        schedule.printSchedule();
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
