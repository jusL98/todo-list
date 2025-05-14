import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable {
    private String taskListName;
    private ArrayList<Task> taskList;
    private ArrayList<Task> completedTasks;

    public TaskList(String taskListName) {
        this.taskListName = taskListName;
        taskList = new ArrayList<Task>();
        completedTasks = new ArrayList<Task>();
    }

    public String getTaskListName(){
        return taskListName;
    }

    // Action #1 - Get Task List
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    // Action #2 - Add New Task
    public void addTask(Task newTask) {
        taskList.add(newTask);
        orderTaskList();
    }

    // Action #3 - Delete Task
    public void deleteTask(int index) {
        taskList.remove(index);
    }

    // Action #4 - Complete Task
    public void completeTask(int index) {
        taskList.get(index).setCompletion(true);
        completedTasks.add(taskList.get(index)); // ordered by first completed to last completed
        taskList.remove(index);
    }

    // Action #5 - Get Completed TaskList
    public ArrayList<Task> getCompletedTaskList() {
        return completedTasks;
    }

    public void orderTaskList() {
        for (int i = 0; i < taskList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < taskList.size(); j++) {
                if (taskList.get(j).getDeadline().before(taskList.get(minIndex).getDeadline())){
                    minIndex = j;
                }
            }
            Task temp = taskList.get(i);
            taskList.set(i, taskList.get(minIndex));
            taskList.set(minIndex, temp);
        }
    }

    public void printTaskList() {
        orderTaskList();
        
        System.out.println(Deadline.getFormattedDate(taskList.get(0).getDeadline()));
        System.out.println("  - " + taskList.get(0));

        for(int i = 1; i < taskList.size(); i++){
            if(taskList.get(i).getDeadline() != taskList.get(i-1).getDeadline() && taskList.get(i).getDeadline().compareTo(taskList.get(i-1).getDeadline()) != 0){
                System.out.println();
                System.out.println(Deadline.getFormattedDate(taskList.get(i).getDeadline()));
            }
            System.out.println("  - " + taskList.get(i));
        }
    }
}
