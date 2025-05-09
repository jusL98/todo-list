import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<Task>();
    }

    // Action #1 - Get Task List
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    // Action #2 - Add New Task
    public void addTask(Task newTask) {
        taskList.add(newTask);
    }

    // Action #3 - Delete Task
    public void deleteTask(int index) {
        taskList.remove(index);
    }

    // Action #4 - Complete Task
    public void completeTask(int index) {
        taskList.get(index).setCompletion(true);
    }

}
