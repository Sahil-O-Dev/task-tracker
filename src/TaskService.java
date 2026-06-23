import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskService
{
    private ArrayList<Task> taskList = new ArrayList<>();

    public boolean addTask(String description)
    {
        LocalDateTime dateTime = LocalDateTime.now();
        //Task task = new Task(id, description, "todo", dateTime.toString(), dateTime.toString());
        //taskList.add(task);
        return true;
    }
}
