import java.util.Arrays;

public class ActivityChosen {

    Activity[] activities;
    boolean flags[];

    public ActivityChosen(Activity[] activities) {
        this.activities = activities;
        flags = new boolean[activities.length];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = false;
        }
    }

    public void chosen() {
        Arrays.sort(activities);
        int end = 0;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].getStart() >= end) {
                flags[i] = true;
                end = activities[i].getFinish();
            }
        }
        showActivity();
    }

    public void showActivity() {
        for (int i = 1; i < flags.length; i++) {
            if (flags[i] == true) {
                System.out.println("Activity " + i + ": " + activities[i]);
            }
        }
    }
}
