public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();


        TaskList tl = new TaskList("dog");

        tl.addTask(new Task("go to gym", new Deadline(05, 30, 2025)));
        tl.addTask(new Task("do homework"));
        tl.addTask(new Task("do dishes"));
        tl.addTask(new Task("clean room"));
        tl.addTask(new Task("make dinner"));

        tl.printTaskList();
    }
}