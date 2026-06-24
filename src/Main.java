public class Main
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("Please enter in correct input");
            return;
        }

        String firstString = args[0];
        switch (firstString)
        {
            case "add":
            {
                if (args.length <= 1) {
                    System.out.println("Please use the correct format for adding eg. task-cli add \"Buy groceries\"\n");
                } else {
                    String taskDescription = args[1];
                    // call addTask method from TaskService.java
                }
                break;
            }
            case "update":
            {
                int id = -1;
                if(args.length != 3)
                {
                    System.out.println("Please use the correct format for updating eg. update 1 \"Buy groceries and cook dinner\"");
                    return;
                }
                try
                {
                    id = Integer.parseInt(args[1]);
                } catch(NumberFormatException e)
                {
                    System.out.println("Please use the correct format for updating eg. update 1 \"Buy groceries and cook dinner\"");
                    return;
                }
//                if(!taskService.existingId(id))
//                {
//                    System.out.println("id does not exist in files");
//                    return;
//                }
//                call taskService method updateTask(id, newDescription)
                break;
            }
            case "delete":
            {
                int id = -1;
                if(args.length != 2)
                {
                    System.out.println("Please use correct format for deletion eg. delete 1");
                    return;
                }
                try
                {
                    id = Integer.parseInt(args[1]);
                } catch(NumberFormatException e)
                {
                    System.out.println("Please use correct format for deletion eg. delete 1");
                    return;
                }
//                if(!taskService.existingId(id))
                {
                    System.out.println("id does not exist in files");
                    return;
                }
//                call deleteTask(id) from taskService
//                break;
            }
            case "mark-in-progress":
            {
                int id = -1;
                if(args.length != 2)
                {
                    System.out.println("Please use correct format eg. mark-in-progress 1");
                    return;
                }
                try
                {
                    id = Integer.parseInt(args[1]);
                } catch(NumberFormatException e)
                {
                    System.out.println("Please use correct format eg. mark-in-progress 1");
                    return;
                }
//                if(!taskService.existingId(id))
                {
                    System.out.println("id does not exist in files");
                    return;
                }
//                call statusChange("mark-in-progress",id) from taskService
//                break;
            }
            case "mark-done":
            {
                int id = -1;
                if(args.length != 2)
                {
                    System.out.println("Please use correct format eg. mark-done 1");
                    return;
                }
                try
                {
                    id = Integer.parseInt(args[1]);
                } catch(NumberFormatException e)
                {
                    System.out.println("Please use correct format eg. mark-done 1");
                    return;
                }
//                if(!taskService.existingId(id))
//                {
//                    System.out.println("id does not exist in files");
//                    return;
//                }
//                call statusChange("mark-done",id) from taskService
                break;
            }
            case "list":
            {
                if(args.length == 1)
                {
//                    call listAll() in taskService and return
                } else if (args.length == 2)
                {
                    if(args[1].equals("todo"))
                    {
//                    call listTodo() from taskService and return
                    } else if(args[1].equals("in-progress"))
                    {
//                    call listInProgress() from taskService and return
                    }else if(args[1].equals("done"))
                    {
//                    call listDone() from taskService and return
                    }
                    else
                    {
                        System.out.println("please use correct format for list eg. list or list done or list in-progress or list todo");
                        return;
                    }
                }
                else
                {
                    System.out.println("please use correct format for list eg. list or list done or list in-progress or list todo");
                    return;
                }
                break;
            }
            default:
            {
                System.out.println("Incorrect input please refer to the README guide for CLI format information");
                return;
            }
        }
    }
}