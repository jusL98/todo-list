public class Main {
    public static void main(String[] args) {
        TaskManager user1 = new TaskManager();

        user1.addTask(new Task("run"));

        System.out.println(user1.getTaskList().get(0).getTask());
    }
}