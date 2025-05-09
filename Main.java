import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskList user1 = new TaskList();

        user1.addTask(new Task("run"));
        user1.addTask(new Task("run2"));
        user1.addTask(new Task("run3"));
        user1.addTask(new Task("run4"));
        user1.addTask(new Task("run5"));

        user1.deleteTask(2);
        user1.completeTask(2);

        ArrayList<Task> testList = user1.getTaskList();

        for(Task task : testList){ 
            System.out.println(task.getTask() + " " + task.getCompletion());
        }
    }
}