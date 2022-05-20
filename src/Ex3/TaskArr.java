package Ex3;

public class TaskArr {
	Task[] taskArr = new Task[1];
	private int nextEmpty = 0;
	private int arrSize = 1;

	private boolean isFull() {
		return (this.nextEmpty == this.arrSize);
	}

	public void addTask(Task t) {
		if (isFull()) {
			Task[] newTaskArr = new Task[arrSize * 2];
			for (int i = 0; i < arrSize; i++) {
				newTaskArr[i] = taskArr[i];
			}
			taskArr = newTaskArr;
		}
		taskArr[nextEmpty] = t;
		nextEmpty++;
		arrSize *= 2;
	}
}
