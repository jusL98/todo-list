import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;

    public TaskManager(){
        taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }

    public void addTask(Task newTask){
        taskList.add(newTask);
    }
}
