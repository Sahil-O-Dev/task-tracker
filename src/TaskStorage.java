import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TaskStorage
{


    public ArrayList<Task> readFile()
    {
        return null;
    }
    public void writeFile(ArrayList<Task> tasks)
    {
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

        try
        {
            Path p = Paths.get("tasks.json");

            Files.writeString(p, resultString.toString());
        }
        catch (Exception e)
        {
            System.out.println("Failed to write file: " + e.getMessage());
        }
    }
}