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
	
	//static methods
	public static void sort_by_title(Task[] tasks) { // sort in place
       Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second)
            {
                return first.getTitle().compareTo(second.getTitle());
            }
        }
       );
	}
	public static void sort_by_date_started(Task[] tasks) { // sort in place
	       Arrays.sort(tasks, new Comparator<Task>() {
	            @Override
	            public int compare(Task first, Task second)
	            {
	                return first.getCreateDate().compareTo(second.getCreateDate());
	            }
	        }
	       );
		}
	public static void sort_by_date_target(Task[] tasks) { // sort in place
	       Arrays.sort(tasks, new Comparator<Task>() {
	            @Override
	            public int compare(Task first, Task second)
	            {
	                return first.getTargetDate().compareTo(second.getTargetDate());
	            }
	        }
	       );
		}
}
