public class Task {
    private String task;
    private int deadline;
    private String category;
    private boolean isCompleted;

    public Task(String task){
        this.task = task;
        this.deadline = 0;
        this.isCompleted = false;
    }

    public Task(String task, int deadline) {
        this.task = task;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    public String getTask(){
        return task;
    }

    public void setTask(String task){
        this.task = task;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean getCompletion(){
        return isCompleted;
    }

    public void setCompletion(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
    
    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
}