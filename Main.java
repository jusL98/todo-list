public class Main {
    public static void main(String[] args) {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();
        
        TaskList work = new TaskList();

        work.addTask(new Task("go to gym",2));
        work.addTask(new Task("do homework",0));
        work.addTask(new Task("do dishes",1));
        work.addTask(new Task("clean room",8));
        work.addTask(new Task("make dinner",5));
        work.addTask(new Task("go for jog", 0));
        work.addTask(new Task("submit application",0));
        work.addTask(new Task("do pushups", 0));
        work.addTask(new Task("read", 0));

        work.deleteTask(2);
        work.completeTask(2);

        work.orderTaskList();

        work.printTaskList();
    }
}