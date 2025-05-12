import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();
        
        TaskList work = new TaskList();

        work.addTask(new Task("run"));
        work.addTask(new Task("run2"));
        work.addTask(new Task("run3"));
        work.addTask(new Task("run4"));
        work.addTask(new Task("run5"));

        work.deleteTask(2);
        work.completeTask(2);

        ArrayList<Task> testList = work.getTaskList();

        for(Task task : testList){ 
            System.out.println(task.getTask() + " " + task.getCompletion());
        }
    }
}