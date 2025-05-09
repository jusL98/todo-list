import java.util.ArrayList;

public class User {
    private ArrayList<TaskList> userTaskLists;

    public User() {
        this.userTaskLists = new ArrayList<TaskList>();
        ;
    }

    public User(ArrayList<TaskList> userTaskLists) {
        this.userTaskLists = userTaskLists;
    }

    public void addTaskList(ArrayList<TaskList> newTaskList) {

    }

}
