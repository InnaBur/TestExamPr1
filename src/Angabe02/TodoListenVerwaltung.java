package Angabe02;

public class TodoListenVerwaltung {
    private Task[] tasks;
    private int nextId;

    //ein Konstruktor, wo ein Array darstellen wird
    public TodoListenVerwaltung() {
        this.tasks = new Task[10];
    }


    // Diese Methode fuegen das Task im List hinzu
    public void addTask(String title) {
        for (int i = 0; i < tasks.length; i++) {

            //suchen freien Platz fuer neues Task
            if (tasks[i] == null) {
                nextId = i;
                tasks[i] = new Task(nextId, title, false);
                break;
            }

            //Bedienung, um zu ueberpruefen, ob das List gefuelt ist
            if (i == tasks.length - 1) {
                System.out.println("ToDo list ist schon gefuelt!");
            }
        }
    }


    //Diese Methode gibt das Task mit dem eingegebenen id zurueck
    // oder gibt keine Task, wenn es diese id nicht exist
    public Task getTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    //Diese Methode veraendert das boolean 'isComplete des Tasks mit eingegebenen id
    public void markTaskComplete(int id) {
        for (Task task : tasks) {
            if (task != null && task.getId() == id) {
                task.setComplete(true);
            }
        }
    }

    //Diese Methode loescht das Task von dem List
    public void deleteTask(int id) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getId() == id) {
                tasks[i] = null;

                //hier werden die Elemente nach links verschoben, um richtig anzuzeigen
                // platzieren wir die naechsten Element auf dem Platz des loeschenden Elements
                for (int j = i; j < tasks.length - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }

                //laetztes Element wird geloescht, weil wir schon das haben auf dem vorletzten Position
                tasks[tasks.length - 1] = null;
            }
        }
    }


    //Diese Methode gibt Tasks in Konsole aus
    public void displayTask() {

        //diese Variable brauchen wir fuer zusaetsliche Ausgabe
        String isComplete;

        System.out.println("ID     Title      Status");
        for (Task task : tasks) {

            //ueberpruefen, ob es das Task gibt und dann ob es erledigt ist
            if (task != null) {
                if (task.isComplete()) {
                    isComplete = "Erledigt";
                } else {
                    isComplete = "Offen";
                }
                System.out.println(task.getId() + "     " + task.getTitle() + "     " + isComplete);
            } else {
                break;
            }
        }
        //fuer bessere Ausgabe
        System.out.println("\n");
    }
}

