package my.samples.sync;

public class SyncHolder {
	
	public Integer COUNT = 100;
	private String taskName = null;
	
	
	public SyncHolder(String taskName) {
		super();
		this.taskName = taskName;
	}


	public void doSomething() {
		System.out.println("taskName = " + this.taskName + " not entered sync block yet");
		synchronized (COUNT) {
			System.out.println("taskName = " + this.taskName + " entered sync block");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("taskName = " + this.taskName + " before ending of sync block");
		}
		System.out.println("taskName = " + this.taskName + " out of sync block");
	}

}
