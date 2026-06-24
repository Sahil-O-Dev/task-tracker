import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskService
{
    private ArrayList<Task> taskList;
    public TaskService (TaskStorage storage)
    {
        this.taskList = storage.readFile();
    }

    public boolean addTask(String description)
    {


        return false;
    }

    public boolean updateTask(String updatedDescription)
    {
        return false;
    }

    public boolean deleteTask(int id)
    {
        return false;
    }

    public void listTasks()
    {

    }

    public void listStatusTasks(String status)
    {

    }

    public boolean changeStatus(int id)
    {
        return false;
    }



    @Override
    public String toString() {
        return "TaskService{" +
                "taskList=" + taskList +
                '}';
    }

    public String testSetup()
    {
        Task task = new Task(1, "bro", "todo", "10", "10");
        taskList.add(task);
        return taskList.toString();

    }
}
