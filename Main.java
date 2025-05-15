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

        Scanner scanner = new Scanner(System.in);

        File file = new File(userDataFile);
        if (file.exists()) {
            mainUser = User.loadUserData(userDataFile);
            System.out.println("Welcome back " + mainUser.getUsername() + "!");
        } else {
            System.out.println("Welcome new user!");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            mainUser = new User(name);
            mainUser.saveUserData(userDataFile);

            System.out.println("Welcome " + mainUser.getUsername() + "!");
        }

        boolean running = true;

        while (running) {
            int choice = mainMenu(scanner);

            switch (choice) {
                case -1:
                    break;
                
                case 1:
                    int taskListIndex = existingTaskListMenu(scanner, mainUser);
                    loadTaskList(scanner, taskListIndex, mainUser);
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

    public static int getValidatedSelection(Scanner scanner, int max) {
        int choice = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == -1){
                    System.out.println("Selection cancelled.");
                    break;
                }
                if (choice >= 1 && choice <= max) {
                    break;
                } else {
                    System.out.print("Please enter a number between 1 and " + max + ": ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static int mainMenu(Scanner scanner) {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("Choose an option:");
        System.out.println("  1. Load existing tasklist");
        System.out.println("  2. Create a new tasklist");
        System.out.println("  3. Exit");

        System.out.print("Your selection: ");
        int choice = getValidatedSelection(scanner, 3);

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
        }

        return choice;
    }

    public static int existingTaskListMenu(Scanner scanner, User mainUser) {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();

        if (mainUser.getUserTaskLists().isEmpty()) {
            System.out.println("No TaskLists available to load.");
            return -1;
        }

        System.out.println("Select a task list:");
        for (int i = 0; i < mainUser.getUserTaskLists().size(); i++) {
            System.out.println("  " + (i + 1) + ". " + mainUser.getUserTaskLists().get(i).getTaskListName());
        }

        System.out.print("Your selection: ");
        int taskListIndex = getValidatedSelection(scanner, mainUser.getUserTaskLists().size()) - 1;

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
        }

        if (taskListIndex == -2) {
            return -1;
        }

        return taskListIndex;
    }

    public static void loadTaskList(Scanner scanner, int taskListIndex, User mainUser) {
        if (taskListIndex == -1) {
            return;
        }

        String userDataFile = "userData.txt";
        TaskList selectedTaskList = mainUser.getUserTaskLists().get(taskListIndex);
        boolean inTaskListMenu = true;

        while (inTaskListMenu) {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println();
            String taskListName = selectedTaskList.getTaskListName();
            System.out.println(taskListName.toUpperCase() + " TASKLIST");
            System.out.println();

            if (selectedTaskList.getTaskList().isEmpty()) {
                System.out.println("The TaskList is empty.");
            } else {
                selectedTaskList.printTaskList();
            }

            int action = taskListActionMenu(scanner);
            if(action != -1){
                System.out.println();
            }

            switch (action) {
                case 1: // Add a new task
                    System.out.print("Enter task title: ");
                    String desc = scanner.nextLine();
                    if (desc.trim().isEmpty()) {
                        System.out.println("Task title cannot be empty. Task not added.");
                        break;
                    }

                    System.out.print("Enter deadline (ex. Jan 1, 2025): ");
                    String date = scanner.nextLine();
                    if (date.trim().toLowerCase().equals("n")) {
                        System.out.println("No deadline selected. Deadline defaulted to today.");
                        selectedTaskList.addTask(new Task(desc));
                        System.out.println("Task added.");
                        break;
                    } else {
                        java.util.Date parsedDate = Deadline.parseDate(date);
                        if (parsedDate == null) {
                            System.out.println("Invalid date format. Task not added.");
                            break;
                        } else {
                            selectedTaskList.addTask(new Task(desc, new Deadline(parsedDate)));
                            System.out.println("Task added.");
                        }
                    }
                    break;

                case 2: // Delete a task
                    if (selectedTaskList.getTaskList().isEmpty()) {
                        System.out.println("No tasks to delete.");
                        break;
                    }
                    System.out.println("Select task to delete:");
                    for (int i = 0; i < selectedTaskList.getTaskList().size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + selectedTaskList.getTaskList().get(i));
                    }

                    System.out.print("Task to delete: ");
                    int delIndex = getValidatedSelection(scanner, selectedTaskList.getTaskList().size()) - 1;
                    if(delIndex == -2) {
                        break;
                    }
                    selectedTaskList.deleteTask(delIndex);
                    System.out.println("Task deleted.");
                    break;

                case 3: // Complete a task
                    if (selectedTaskList.getTaskList().isEmpty()) {
                        System.out.println("No tasks to complete.");
                        break;
                    }
                    System.out.println("Select task to complete:");
                    for (int i = 0; i < selectedTaskList.getTaskList().size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + selectedTaskList.getTaskList().get(i));
                    }

                    System.out.print("Task to complete: ");
                    int compIndex = getValidatedSelection(scanner, selectedTaskList.getTaskList().size()) - 1;
                    selectedTaskList.completeTask(compIndex);
                    if (compIndex == -2) {
                        break;
                    }
                    System.out.println("Task marked as completed.");
                    break;

                case 4: // View completed tasks
                    if (selectedTaskList.getCompletedTaskList().isEmpty()) {
                        System.out.println("No completed tasks.");
                    } else {
                        System.out.println("Completed Tasks:");
                        for (Task t : selectedTaskList.getCompletedTaskList()) {
                            System.out.println("  - " + t);
                        }
                    }
                    break;

                case 5: // Delete TaskList
                    System.out.print("Are you sure you want to delete this tasklist? (y/n): ");
                    String confirm = scanner.nextLine();
                    if (confirm.trim().toLowerCase().equals("y")) {
                        mainUser.getUserTaskLists().remove(taskListIndex);
                        System.out.println("TaskList deleted.");
                        inTaskListMenu = false;
                    } else {
                        System.out.println("TaskList not deleted.");
                        mainUser.addTaskList(selectedTaskList);
                    }
                    break;

                case 6: // Return to main menu
                    inTaskListMenu = false;
                    break;
            }
            try {
                mainUser.saveUserData(userDataFile);
                Thread.sleep(700);
            } catch (IOException e) {
                System.out.println("Error saving user data: " + e.getMessage());
            } catch (InterruptedException e) {
            }
        }
    }

    public static int taskListActionMenu(Scanner scanner) {
        System.out.println();

        System.out.println("Choose an action:");
        System.out.println("  1. Add a new task");
        System.out.println("  2. Delete a task");
        System.out.println("  3. Complete a task");
        System.out.println("  4. View completed tasks");
        System.out.println("  5. DELETE TASKLIST");
        System.out.println("  6. RETURN TO MAIN MENU");

        System.out.print("Your selection: ");
        int choice = getValidatedSelection(scanner, 6);

        return choice;
    }
}