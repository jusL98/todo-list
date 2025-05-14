import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        File taskListDirs = new File("taskListDirectories.txt");
        try {
            taskListDirs.createNewFile();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());

        }


        System.out.println("Hello! Welcome to your Todo List.");
        System.out.println("Choose an option:");
        System.out.println("1. Load task list");
        System.out.println("2. Create new task list");
        int option = scanner.nextInt();

        if(option == 1){
            System.out.println("Choose task list: ");
            int index = 0;
            String selectedFileName = "";
            try {
                Scanner myReader = new Scanner(taskListDirs);
                index = 1;
                while (myReader.hasNextLine()) {
                    System.out.println(index + ". " + myReader.nextLine());
                    index++;
                }
                myReader.close();
                
                int selectedList = scanner.nextInt();
                Scanner myReader2 = new Scanner(taskListDirs);

                for (int i = 1; i <= selectedList; i++) {
                    selectedFileName = myReader2.nextLine();
                }
                System.out.println(selectedFileName);

                myReader2.close();
            } catch (IOException e) {
                System.out.println("Error with file: " + e.getMessage());
            }   

            FileInputStream fileInputStream = new FileInputStream("TaskListData/" + selectedFileName + ".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TaskList readWork = (TaskList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            System.out.println("\n\nRead TaskList from file:");
            readWork.printTaskList();
        }

        




        /*
        TaskList tl = new TaskList("dog");

        try {
            taskListDirs.createNewFile();
            Scanner myReader = new Scanner(taskListDirs);
            boolean doesNotExist = true;
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.equals(tl.getTaskListName())){
                    doesNotExist = false;
                    break;
                }
            }

            if(doesNotExist){ // later need to throw error if trying to make a tasklist of same name.
                FileWriter myWriter = new FileWriter("taskListDirectories.txt", true);
                myWriter.write(tl.getTaskListName() + "\n");
                myWriter.close();
            }
            
            myReader.close();
        } catch (IOException e) {
            System.out.println("Error with file: " + e.getMessage());
        }

        tl.addTask(new Task("go to gym", new Deadline(05, 30, 2025)));
        tl.addTask(new Task("do homework"));
        tl.addTask(new Task("do dishes"));
        tl.addTask(new Task("clean room"));
        tl.addTask(new Task("make dinner"));

        tl.printTaskList();

        // Writing the TaskList object to a file
        FileOutputStream fileOutputStream = new FileOutputStream("TaskListData/" + tl.getTaskListName() + ".txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(tl);
        objectOutputStream.close();
        fileOutputStream.close();

        // Reading the TaskList object from the file
        FileInputStream fileInputStream = new FileInputStream("TaskListData/" + tl.getTaskListName() + ".txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TaskList readWork = (TaskList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println("\n\nRead TaskList from file:");
        readWork.printTaskList();
        */
        scanner.close();
    }
}