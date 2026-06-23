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
                    System.out.println("Please enter a task description after add in quotations");
                } else {
                    String taskDescription = args[1];
                    // call addTask method from TaskService.java
                }
                break;
            }
            case "update":
            {

            }
        }
    }
}