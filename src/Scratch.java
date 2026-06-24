import java.util.ArrayList;

public class Scratch {
    public static void main(String[] args) {
        // Seed a few tasks to experiment with
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Buy groceries", "todo", "2026-06-22T14:30:45", "2026-06-22T14:30:45"));
        tasks.add(new Task(2, "Finish homework", "done", "2026-06-22T15:00:00", "2026-06-22T16:10:00"));

        TaskStorage storage = new TaskStorage();
        storage.writeFile(tasks);
        // See the whole list
//        System.out.println("Whole list:");
//        System.out.println(tasks);
//
//        // See one task
//        System.out.println("\nOne task:");
//        System.out.println(tasks.get(0));
//
//        // See individual fields
//        System.out.println("\nFields of task 0:");
//        System.out.println(tasks.get(0).getId());
//        System.out.println(tasks.get(0).getDescription());
//        System.out.println(tasks.get(0).getStatus());

//        System.out.println("{");
//        System.out.println("\"id\"" + " : " + tasks.get(0).getId());
//        System.out.println("\"description\"" + " : " + "\"" + tasks.get(0).getDescription() + "\"");
//        System.out.println("\"status\"" + " : " + "\"" + tasks.get(0).getStatus() + "\"");
//        System.out.println("\"createdAt\"" + " : " + "\"" + tasks.get(0).getCreatedAt() + "\"");
//        System.out.println("\"updatedAt\"" + " : " + "\"" + tasks.get(0).getUpdatedAt() + "\"");
//        System.out.println("}");

        StringBuilder resultString = new StringBuilder();
        resultString.append("[");

        for(int i = 0; i < tasks.size(); i++)
        {
            if(i == tasks.size() - 1)
            {
                resultString.append("{" + "\"id\"" + ":" + tasks.get(i).getId() + "," + "\"description\"" + ":" + "\"" + tasks.get(i).getDescription() + "\"" +","+ "\"status\"" + ":" + "\"" + tasks.get(i).getStatus() + "\"" + "," + "\"createdAt\"" + ":" + "\"" + tasks.get(i).getCreatedAt() + "\"" + "," + "\"updatedAt\"" + ":" + "\"" + tasks.get(i).getUpdatedAt() + "\"" + "}");

            }
            else
            {
                resultString.append("{" + "\"id\"" + ":" + tasks.get(i).getId() + "," + "\"description\"" + ":" + "\"" + tasks.get(i).getDescription() + "\"" +","+ "\"status\"" + ":" + "\"" + tasks.get(i).getStatus() + "\"" + "," + "\"createdAt\"" + ":" + "\"" + tasks.get(i).getCreatedAt() + "\"" + "," + "\"updatedAt\"" + ":" + "\"" + tasks.get(i).getUpdatedAt() + "\"" + "}" + ",");
            }
        }

        resultString.append("]");

        System.out.println(resultString);



        // --- Your experiment zone ---
        // Try building a JSON string for ONE task here and print it.
        // Compare what prints against the JSON format example.
        // e.g. String json = "{ ... }";  System.out.println(json);
    }
}
