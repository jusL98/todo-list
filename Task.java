public class Task {
    private String task;
    private String desc;
    private String category;
    private boolean isCompleted;

    public Task(String task){
        this.task = task;
        this.isCompleted = false;
    }

    public Task(String task, String desc){
        this.task = task;
        this.desc = desc;
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

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public boolean getCompletion(){
        return isCompleted;
    }

    public void setCompletion(boolean isCompleted){
        this.isCompleted = isCompleted;
    }
}