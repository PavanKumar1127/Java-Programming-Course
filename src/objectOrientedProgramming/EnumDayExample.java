package objectOrientedProgramming;
// Define an enum named Day
enum Day {
    SUNDAY("Relax"), MONDAY("Work"), TUESDAY("Work"), WEDNESDAY("Work"),
    THURSDAY("Work"), FRIDAY("Work"), SATURDAY("Relax");

    // Additional fields and constructor
    private String activity;

    // Constructor to associate an activity with each day
    Day(String activity) {
        this.activity = activity;
    }

    // Getter method for the activity
    public String getActivity() {
        return activity;
    }
}

public class EnumDayExample {
    public static void main(String[] args) {
        // Using enum values and associated activities
        for (Day day : Day.values()) {
            System.out.println(day + ": " + day.getActivity());
        }

        // Accessing a specific enum constant
        Day myDay = Day.FRIDAY;
        System.out.println("On " + myDay + ", I should: " + myDay.getActivity());
    }
}
