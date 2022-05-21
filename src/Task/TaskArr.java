package Task;

import java.util.Arrays;
import java.util.Comparator;

public class TaskArr {
	Task[] taskArr = new Task[1];
	private int nextEmpty = 0;
	private int arrSize = 1;

	private boolean isFull() {
		return (this.nextEmpty == this.arrSize);
	}

	public void addTask(Task t) {
		if (isFull()) {
			Task[] newTaskArr = new Task[this.arrSize * 2];
			for (int i = 0; i < this.arrSize; i++) {
				newTaskArr[i] = this.taskArr[i];
			}
			this.taskArr = newTaskArr;
		}
		this.taskArr[nextEmpty] = t;
		this.nextEmpty++;
		this.arrSize *= 2;
	}

	public void deleteTask(Task t) {
		int i = 0;
		for (; i < this.arrSize; i++) {
			if (this.taskArr[i].getTaskID() == t.getTaskID()) {
				this.taskArr[i] = null;
				break;
			}
		}
		for (; i < this.arrSize - 1; i++) {
			this.taskArr[i] = this.taskArr[i + 1];

		}
	}

	// static methods
	public static void sort_by_title(Task[] tasks) { // sort in place
		Arrays.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task first, Task second) {
				return first.getTitle().compareTo(second.getTitle());
			}
		});
	}

	public static void sort_by_date_started(Task[] tasks) { // sort in place
		Arrays.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task first, Task second) {
				return first.getCreateDate().compareTo(second.getCreateDate());
			}
		});
	}

	public static void sort_by_date_target(Task[] tasks) { // sort in place
		Arrays.sort(tasks, new Comparator<Task>() {
			@Override
			public int compare(Task first, Task second) {
				return first.getTargetDate().compareTo(second.getTargetDate());
			}
		});
	}
}
