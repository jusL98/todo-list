import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
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

        // Writing the TaskList object to a file
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(work);
        objectOutputStream.close();
        fileOutputStream.close();

        // Reading the TaskList object from the file
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TaskList readWork = (TaskList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println("\n\nRead TaskList from file:");
        readWork.printTaskList();
    }
}