import java.util.Scanner;

public class Consumer {

    public static void main(String[] args) {

        Organization o=Organization.CreateInstance();

        String name,desig;
        int sal,choice,n,EmpCount=0;

        Scanner sc=new Scanner(System.in);

        do
        {
            System.out.println("1:Add an employee record");
            System.out.println("2:Display all employee record details");
            System.out.println("3:Search for an employee record");
            System.out.println("4:Delete an employee record");
            System.out.println("enter your choice");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    o.AddEmployeeRecord();
                    break;

                case 2:
                    o.dispEmployeeRecord();
                    break;

                case 3:
                    o.searchEmployeeRecord();
                    break;

                case 4:
                    o.deleteEmployeeRecord();
                    break;

                default:
                    System.out.println("invalid choice");

            }
            System.out.println("enter 1 to continue");
            choice=sc.nextInt();

        } while(choice==1);
    }
}
