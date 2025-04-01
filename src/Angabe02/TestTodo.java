package Angabe02;

public class TestTodo {
    public static void main(String[] args) {

        TodoListenVerwaltung todo = new TodoListenVerwaltung();

        todo.addTask("Einkaufen");
        todo.addTask("Ueben");
        todo.addTask("Lesen");

        todo.displayTask();

        todo.markTaskComplete(1);
        todo.displayTask();

        todo.deleteTask(2);
        todo.displayTask();
    }
}
