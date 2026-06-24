import java.util.ArrayList;

public class Scratch {
    public static void main(String[] args) {
        // Seed a few tasks to experiment with
        ArrayList<Task> tasks = new ArrayList<>();
        TaskStorage storage = new TaskStorage();

        tasks.add(new Task(1, "Buy groceries", "todo", "2026-06-22T14:30:45", "2026-06-22T14:30:45"));
        tasks.add(new Task(2, "Finish homework", "done", "2026-06-22T15:00:00", "2026-06-22T16:10:00"));
        tasks.add(new Task(3, "Walk the dog", "in-progress", "2026-06-22T09:15:00", "2026-06-22T09:15:00"));
        tasks.add(new Task(4, "Call dentist", "todo", "2026-06-22T10:00:00", "2026-06-22T10:00:00"));
        tasks.add(new Task(5, "Wash the car", "done", "2026-06-22T11:30:00", "2026-06-22T12:00:00"));
        tasks.add(new Task(66, "Read a chapter", "in-progress", "2026-06-22T13:45:00", "2026-06-22T14:00:00"));


        storage.writeFile(tasks);
        System.out.println(storage.readFile());

        // --- Your experiment zone ---
        // Try building a JSON string for ONE task here and print it.
        // Compare what prints against the JSON format example.
        // e.g. String json = "{ ... }";  System.out.println(json);
    }
}
