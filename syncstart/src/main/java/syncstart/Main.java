package syncstart;

public class Main {

    public static void main(String[] args) {
        TaskSyncExecutor executor = new TaskSyncExecutor(4, new TaskFabric());
        executor.execute();
    }
}
