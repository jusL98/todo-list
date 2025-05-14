import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("*******************************");
        System.out.println("          TODO - LIST          ");
        System.out.println("*******************************");
        System.out.println();

        String userDataFile = "userData.txt";
        User mainUser;

        File file = new File(userDataFile);
        if (file.exists()) {
            mainUser = User.loadUserData(userDataFile);
            System.out.println("Welcome back " + mainUser.getUsername() + "!");
        } else {
            mainUser = new User("Justin");
            System.out.println("Welcome " + mainUser.getUsername() + "!");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println();

        while (running) {
            int choice = mainMenu(scanner);

            switch (choice) {
                case 1:
                    if (mainUser.getUserTaskLists().isEmpty()) {
                        System.out.println("No TaskLists available to load.");
                        break;
                    }

                    System.out.println("Available TaskLists:");
                    for (int i = 0; i < mainUser.getUserTaskLists().size(); i++) {
                        System.out.println((i + 1) + ". " + mainUser.getUserTaskLists().get(i).getTaskListName());
                    }

                    System.out.print("Enter the number of the TaskList to load: ");
                    int taskListIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (taskListIndex >= 0 && taskListIndex < mainUser.getUserTaskLists().size()) {
                        TaskList selectedTaskList = mainUser.getUserTaskLists().get(taskListIndex);
                        System.out.println("Loaded TaskList: " + selectedTaskList.getTaskListName());

                        // Check if the TaskList is empty before printing
                        if (selectedTaskList.getTaskList().isEmpty()) {
                            System.out.println("The TaskList is empty.");
                        } else {
                            selectedTaskList.printTaskList();
                        }
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the name of the new TaskList: ");
                    String newTaskListName = scanner.nextLine();
                    TaskList newTaskList = new TaskList(newTaskListName);
                    mainUser.addTaskList(newTaskList);
                    System.out.println("TaskList '" + newTaskListName + "' created.");
                    mainUser.saveUserData(userDataFile);

                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static int mainMenu(Scanner scanner){
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("Choose an option:");
        System.out.println("  1. Load existing TaskList");
        System.out.println("  2. Create a new TaskList");
        System.out.println("  3. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        System.out.println("--------------------------------");

        return choice;
    }
}