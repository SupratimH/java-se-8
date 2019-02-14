import java.util.Scanner;

class IDGenerator
{
    static int id;
    static
    {
        id=0;
    }
    static int getID()
    {
        return ++id;
    }
}

abstract class Employee
{
    private String Designation;
    private String EmployeeName;
    private final int EmployeeID;
    private int EmployeeSal;

    public int getEmployeeSal() {
        return EmployeeSal;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public Employee(String EmployeeName,String Designation,int EmployeeSal,int id)
    {
        this.EmployeeSal = EmployeeSal;
        this.Designation = Designation;
        this.EmployeeName = EmployeeName;
        this.EmployeeID = id;
    }
}

class TEmployee extends Employee
{
    int Duration;
    public int getDuration() {
        return Duration;
    }
    public TEmployee(int EmpID,String EmpName,String Designation,int EmpSal,int Duration)
    {
        super(EmpName,Designation,EmpSal,EmpID);
        this.Duration = Duration;
    }

}

class PEmployee extends Employee
{
    int HRA;
    public int getHRA() {
        return HRA;
    }
    public PEmployee(int EmpID,String EmpName,String Designation,int EmpSal,int HRA)
    {
        super(EmpName,Designation,EmpSal,EmpID);
        this.HRA = HRA;
    }

}

class Organization {
    Employee [] e;
    static int EmpCount,MaxEmpCount;
    static Organization o;

    static
    {
        o=null;
        EmpCount=0;
        MaxEmpCount=0;
    }

    private Organization()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the max number of employee records to be considered");
        MaxEmpCount = sc.nextInt();
        e=new Employee[MaxEmpCount];
    }

    public static Organization CreateInstance()
    {
        if(o==null)
        {
            o=new Organization();
        }
        return o;
    }

    public void AddEmployeeRecord()
    {

        if(EmpCount<MaxEmpCount)
        {
            Scanner sc = new Scanner(System.in);
            String Name;
            String Designation;
            int Sal,choice;
            System.out.println("enter name, designation and sal");
            Name = sc.next();
            Designation = sc.next();
            Sal = sc.nextInt();
            System.out.println("1:TEmployee 2:PEmployee enter your choice");
            choice=sc.nextInt();
            int duration,hra;
            if(choice==1)
            {
                System.out.println("enter the duration");
                duration =  sc.nextInt();
                e[EmpCount++] = new TEmployee(IDGenerator.getID(),Name,Designation,Sal,duration);
            }
            else if(choice==2)
            {
                System.out.println("enter the hra");
                hra =  sc.nextInt();
                e[EmpCount++] = new PEmployee(IDGenerator.getID(),Name,Designation,Sal,hra);
            }

            //EmpCount++;

        }
        else
            System.out.println("no more records can be added");

    }
    public void dispEmployeeRecord()
    {
        if(EmpCount==0)
            System.out.println("no records to display");
        else
        {
            Scanner s = new Scanner(System.in);
            int choice;
            System.out.println("1:Display all employee details");
            System.out.println("2:Display only permanent employee details");
            System.out.println("3:Display only temporary employee details");
            System.out.println("enter your choice");
            choice=s.nextInt();
            if(choice==1)
            {
                for(int i=0;i<EmpCount;i++)
                {
                    System.out.println("ID:"+e[i].getEmployeeID());
                    System.out.println("Name:"+e[i].getEmployeeName());
                    System.out.println("Designation:"+e[i].getDesignation());
                    System.out.println("Sal:"+e[i].getEmployeeSal());

                    if(e[i] instanceof PEmployee )
                        System.out.println("HRA:"+((PEmployee)e[i]).getHRA());
                    else if(e[i] instanceof TEmployee )
                        System.out.println("Duration:"+((TEmployee)e[i]).getDuration());
                    System.out.println("------------------------------------");
                }

            }
            else if(choice==2)
            {
                System.out.println();
                for(int i=0;i<EmpCount;i++)
                {
                    if(e[i] instanceof PEmployee)
                    {
                        PEmployee p = (PEmployee)e[i];
                        System.out.println("ID:"+p.getEmployeeID());
                        System.out.println("Name:"+p.getEmployeeName());
                        System.out.println("Designation:"+p.getDesignation());
                        System.out.println("Sal:"+p.getEmployeeSal());
                        System.out.println("HRA:"+p.getHRA());
                        System.out.println("------------------------------------");
                    }
                }
            }
            else if(choice==3)
            {
                System.out.println();
                for(int i=0;i<EmpCount;i++)
                {
                    if(e[i] instanceof TEmployee)
                    {
                        TEmployee p = (TEmployee)e[i];
                        System.out.println("ID:"+p.getEmployeeID());
                        System.out.println("Name:"+p.getEmployeeName());
                        System.out.println("Designation:"+p.getDesignation());
                        System.out.println("Sal:"+p.getEmployeeSal());
                        System.out.println("Duration:"+p.getDuration());
                        System.out.println("------------------------------------");
                    }
                }
            }

        }

    }
    private void display(Employee e)
    {
        System.out.println("EmpID: "+e.getEmployeeID());
        System.out.println("Designation: "+e.getDesignation());
        System.out.println("EmployeeSal: "+e.getEmployeeSal());
        System.out.println("EmployeeName: "+e.getEmployeeName());
        System.out.println("-------------------------");
    }
    public void searchEmployeeRecord()
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        if(EmpCount==0)
            System.out.println("no records to search");
        else
        {
            System.out.println("1:search by designation");
            System.out.println("2:search by empid");
            System.out.println("enter the choice");
            choice = sc.nextInt();

            if(choice==1)
            {
                String desig;
                System.out.println("enter the designation");
                desig = sc.next();
                search(desig);
            }
            else
            {
                int id;
                System.out.println("enter the empid");
                id = sc.nextInt();
                search(id);
            }
        }


    }
    private void search(String desig)
    {
        int recordcount=0;
        boolean status=false;
        for(int i=0;i<EmpCount;i++)
        {
            if(e[i].getDesignation().equalsIgnoreCase(desig))
            {
                status=true;
                recordcount++;
            }
        }
        if(status==false)
            System.out.println("records with the designation "+desig+" not found");
        else
            System.out.println(recordcount+" records with the designation "+desig+" was found");

    }

    private void search(int id)
    {
        boolean status=false;
        for(int i=0;i<EmpCount;i++)
        {
            if(e[i].getEmployeeID()==id)
            {
                status=true;
                break;
            }
        }
        if(status==false)
            System.out.println("records with the EmpID "+id+" not found");
        else
            System.out.println("records with the EmpID "+id+" was found");

    }

    public void deleteEmployeeRecord()
    {
        if(EmpCount==0)
        {
            System.out.println("records are not available");
            return;
        }
        else
        {
            Scanner s = new Scanner(System.in);
            boolean status=false;
            System.out.println("enter the id to delete");
            int id = s.nextInt();
            for(int i=0;i<EmpCount;i++)
            {
                if(e[i].getEmployeeID()==id)
                {
                    status=true;
                    e[i]=e[EmpCount-1];
                    e[EmpCount-1]=null;
                    EmpCount--;
                    System.out.println("id found and record is deleted");
                    break;
                }
            }
            if(status==false)
                System.out.println("id not found");
        }
    }

}
