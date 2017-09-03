public class Test {

    public static void main(String[] args) {
        Task[] tasks = {
                new Task(1, 4, 70),
                new Task(2, 2, 60),
                new Task(3, 4, 50),
                new Task(4, 3, 40),
                new Task(5, 1, 30),
                new Task(6, 4, 20),
                new Task(7, 6, 10)
        };

        System.out.println("wi: ");
        TaskDispatch2 dispatch2 = new TaskDispatch2(tasks);
        dispatch2.dispatch();

        System.out.println("\nwi = max - wi: ");
        TaskDispatch3 dispatch3 = new TaskDispatch3(tasks);
        dispatch3.dispatch();
    }

}
