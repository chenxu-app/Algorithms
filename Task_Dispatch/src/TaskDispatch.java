import java.util.Arrays;

public class TaskDispatch {

    private Task[] tasks;
    private Task[] output;

    public TaskDispatch(Task[] tasks) {
        this.tasks = tasks;
        output = new Task[tasks.length];
    }

    private int greedy() {
        Arrays.sort(tasks);

        output[0] = tasks[0];
        int k = 1, i, j;
        int n = tasks.length;
        int[] record = new int[n];

        for (i = 0; i < n; i++) {
            if (i >= output[0].getDelay())
                record[i] = 1;
            else
                record[i] = 0;
        }

        for (i = 1; i < n; i++) {
            for (j = tasks[i].getDelay(); j < n; j++) {
                if (record[j] + 1 > j)
                    break;
            }
            if (j == n) {
                output[k] = tasks[i];
                k++;
                for (j = tasks[i].getDelay(); j < n; j++) {
                    record[j]++;
                }
            }
        }

        return k;
    }

    public void dispatch() {
        int k = greedy();
        int sum1 = 0, sum2 = 0;
        for (Task task : tasks) {
            sum1 += task.getPunish();
        }

        for (int i = 0; i < k; i++) {
            sum2 += output[i].getPunish();
        }

        for (int i = 0; i < k; i++) {
            System.out.println(output[i]);
        }
        System.out.println("punish: " + (sum1 - sum2));
    }
}
