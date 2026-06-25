import java.time.LocalDate;
import java.util.ArrayList;

public class TaskService
{
    private ArrayList<Task> taskList;
    private TaskStorage storage;


    public TaskService (TaskStorage storage)
    {
        this.taskList = storage.readFile();
        this.storage = storage;
    }

    public void addTask(String description)
    {
        int largestId = 0;
        String date = LocalDate.now().toString();

        for(Task t: taskList)
        {
            if(largestId < t.getId())
            {
                largestId = t.getId();
            }
        }
        largestId++;
        taskList.add(new Task(largestId, description, "todo", date, date));
        storage.writeFile(taskList);

        System.out.println("Task Added! " + "(ID: " + largestId + ")");
    }

    public void updateTask(int id, String updatedDescription)
    {
        if(taskList.isEmpty())
        {
            System.out.println("No tasks exist to update!");
            return;
        }
        int index = -1;
        for(int i = 0; i < taskList.size(); i++)
        {
            if(taskList.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            System.out.println("Id does not exist");
            return;
        }
        String updatedDate = LocalDate.now().toString();
        taskList.get(index).setDescription(updatedDescription);
        taskList.get(index).setUpdatedAt(updatedDate);
        storage.writeFile(taskList);
        System.out.println("Task Id " + id + " updated!");
    }

    public void deleteTask(int id)
    {
        int index = -1;
        for(int i = 0; i < taskList.size(); i++)
        {
            if(taskList.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            System.out.println("Id does not exist");
            return;
        }

        taskList.remove(index);
        System.out.println("Task Id " + id + " removed!");
        storage.writeFile(taskList);
    }

    public void listTasks()
    {
        if(taskList.isEmpty())
        {
            System.out.println("No tasks exist to list!");
            return;
        }
        for(Task t: taskList)
        {
            System.out.println("(ID " + t.getId() + ") " + "Task: " + t.getDescription());
        }
    }

    public void listStatusTasks(String status)
    {
        if(taskList.isEmpty())
        {
            System.out.println("No tasks exist to list!");
            return;
        }
        for(Task t: taskList)
        {
            if(t.getStatus().equals(status))
            {
                System.out.println("(ID " + t.getId() + ") " + "Task: " + t.getDescription());
            }
        }
    }

    public void changeStatus(int id, String updatedStatus)
    {
        int index = -1;
        for(int i = 0; i < taskList.size(); i++)
        {
            if(taskList.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            System.out.println("Task with Id " + id + " does not exist");
            return;
        }
        System.out.println("Task Id " + id + " updated!");
        taskList.get(index).setStatus(updatedStatus);
        storage.writeFile(taskList);
    }



    @Override
    public String toString() {
        return "TaskService{" +
                "taskList=" + taskList +
                '}';
    }

}
