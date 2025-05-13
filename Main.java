public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();

        TaskList work = new TaskList();

        work.addTask(new Task("go to gym", new Deadline(05, 30, 2025)));
        work.addTask(new Task("do homework"));
        work.addTask(new Task("do dishes"));
        work.addTask(new Task("clean room"));
        work.addTask(new Task("make dinner"));
        work.addTask(new Task("go for jog"));

        work.printTaskList();
    }
}