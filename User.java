import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private ArrayList<TaskList> userTaskLists;

    public User(String username) {
        this.username = username;
        userTaskLists = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public TaskList getTaskList(int index) {
        return userTaskLists.get(index);
    }

    public void addTaskList(TaskList taskList) {
        userTaskLists.add(taskList);
    }

    public void removeTaskList(TaskList taskList) {
        userTaskLists.remove(taskList);
    }

    public ArrayList<TaskList> getUserTaskLists() {
        return userTaskLists;
    }

    public void saveUserData(String filePath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static User loadUserData(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return user;
    }
}
