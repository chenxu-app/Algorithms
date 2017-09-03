/**
 * Created by cx on 16/5/30.
 */
public class Test {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(0, 0),
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
        };

        ActivityChosen activityChosen = new ActivityChosen(activities);
        activityChosen.chosen();

    }
}
