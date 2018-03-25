package syncstart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskSyncExecutor {
    private ExecutorService exec;
    private Integer count;
    private TaskFabric fabric;

    public TaskSyncExecutor(Integer countToSync, TaskFabric fabric){
        count = countToSync;
        this.fabric = fabric;
        exec = Executors.newFixedThreadPool(countToSync, new SyncByCyclicBarrier(countToSync));
    }

    public void execute(){
        for (int i=0; i < count; i++){
            exec.execute(fabric.newTask());
        }
        exec.shutdown();
    }
}
