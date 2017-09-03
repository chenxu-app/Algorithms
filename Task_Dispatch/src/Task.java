public class Task implements Comparable<Task> {
    private int id;
    private int delay;
    private int punish;

    public Task(int id, int delay, int punish) {
        this.id = id;
        this.delay = delay;
        this.punish = punish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPunish() {
        return punish;
    }

    public void setPunish(int punish) {
        this.punish = punish;
    }

    @Override
    public String toString() {
        return "id: " + id + ", delay: " + delay + ", punish: " + punish;
    }

    @Override
    public int compareTo(Task o) {
        return punish >= o.punish ? -1 : 1;
    }
}
