package my.samples.sync;

import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    public String taskName;
 
    public Task(String taskName) {
        this.taskName = taskName;
    }
     
    @Override
    public void run() {
        SyncHolder syncHolder = new SyncHolder(taskName);
        syncHolder.doSomething();
    }
}
