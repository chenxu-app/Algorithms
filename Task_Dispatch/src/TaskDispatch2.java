import java.util.Arrays;

public class TaskDispatch2 {

    private Task[] tasks;
    private Task[] record;

    public TaskDispatch2(Task[] tasks) {
        this.tasks = tasks;
        record = new Task[tasks.length + 1];
    }

    private void greedy() {
        Arrays.sort(tasks);

        int i, j;
        int n = tasks.length;

        for (i = 0; i < n; i++) {
            for (j = tasks[i].getDelay(); j > 0; j--) {
                if (record[j] == null) {
                    record[j] = tasks[i];
                    break;
                }
            }
        }
    }

    public void dispatch() {
        greedy();
        int sum = 0, totalSum = 0;

        for (int i = 0; i < tasks.length; i++) {
            totalSum += tasks[i].getPunish();
            if (record[i + 1] != null) {
                System.out.println(record[i + 1]);
                sum += record[i + 1].getPunish();
            }
        }

        System.out.println("total punish: " + (totalSum - sum));
    }
}
