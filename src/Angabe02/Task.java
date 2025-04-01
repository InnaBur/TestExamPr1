package Angabe02;

class Task {

    private int id;
    private String title;
    private boolean isComplete;

    public Task(String title) {
        this.title = title;
    }

    public Task(int id, String title, boolean isComplete) {
        this.id = id;
        this.title = title;
        this.isComplete = isComplete;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
