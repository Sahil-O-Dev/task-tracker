import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage
{

    private String parseField(String taskString, String fieldName)
    {
        if(fieldName.equals("id"))
        {
            int startIndex = taskString.indexOf("\"id\":") + ("\"id\":".length());
            int endIndex = taskString.indexOf(",");
            return taskString.substring(startIndex, endIndex);
        }
        int startIndex = taskString.indexOf(fieldName) + (fieldName.length()) + 3;
        int endIndex = taskString.indexOf("\"", startIndex + 1);
        return taskString.substring(startIndex, endIndex);
    }


    public ArrayList<Task> readFile()
    {
        ArrayList<Task> tasks = new ArrayList<>();
        Path path = Paths.get("tasks.json");
        String str = "";
        try
        {
            str = Files.readString(path);

        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
        String[] strArray = str.split("},\\{");

        for(int i = 0; i < strArray.length; i++)
        {
            String currentStr = strArray[i];
            int id = Integer.parseInt(parseField(currentStr, "id"));
            String description = parseField(currentStr, "description");
            String status = parseField(currentStr, "status");
            String createdAt = parseField(currentStr, "createdAt");
            String updatedAt = parseField(currentStr, "updatedAt");

            tasks.add(new Task(id, description, status, createdAt, updatedAt));
        }

        return tasks;
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