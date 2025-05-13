import java.util.Date;

public class Task {
    private String task;
    private Date deadline;
    private boolean isCompleted;

    public Task(String task) {
        this.task = task;
        this.deadline = new Deadline().getDate();
        this.isCompleted = false;
    }

    public Task(String task, Deadline deadline) {
        this.task = task;
        this.deadline = deadline.getDate();
        this.isCompleted = false;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean getCompletion() {
        return isCompleted;
    }

    public void setCompletion(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String toString() {
        return task + " | " + Deadline.getFormattedDate(deadline) + " | " + isCompleted;
    }
}