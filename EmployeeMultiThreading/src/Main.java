import java.util.Scanner;

class InvalidChoiceException extends Exception
{
    private String msg;
    public InvalidChoiceException(String m)
    {
        msg=m;
    }
    public String toString()
    {
        return msg;
    }
}
class EmployeeAddThread extends Thread
{
    Organization o;
    EmployeeAddThread(Organization o)
    {
        this.o = o;
        start();
    }
    public void run()
    {
        System.out.println("Child Thread performng the task of adding employees");
        o.AddEmployeeRecord();
    }
}

public class Main {

    public static void main(String[] args) {

        Organization o=Organization.CreateInstance();
        String name,desig;
        int sal,choice,n,EmpCount=0;

        Scanner sc=new Scanner(System.in);

        EmployeeAddThread t = new EmployeeAddThread(o);

        Thread mt = Thread.currentThread();
        try
        {
            System.out.println("Main thread waiting till child thread completes the task");
            t.join();


        }
        catch(Exception e)
        {
            System.out.println(e);
        }


        do
        {
            try
            {
                System.out.println("1:Display all employee record details");
                System.out.println("2:Search for an employee record");
                System.out.println("enter your choice");
                choice = sc.nextInt();
                switch(choice)
                {
                    case 1:
                        o.dispEmployeeRecord();
                        break;

                    case 2:
                        o.searchEmployeeRecord();
                        break;

                    default:
                        throw new InvalidChoiceException("invalid choice,please reneter");

                }
            }
            catch(InvalidChoiceException e)
            {

                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println("here"+e);
            }
            System.out.println("enter 1 to continue");
            choice=sc.nextInt();
        }while(choice==1);

    }
}
