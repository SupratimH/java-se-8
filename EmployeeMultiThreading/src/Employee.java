import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


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
    private int EmployeeSal;
    private String Designation;
    private String EmployeeName;
    public String getEmployeeName() {
        return EmployeeName;
    }

    private final int EmployeeID;
    private String DeptName;

    public String getDeptName() {
        return DeptName;
    }

    public String getDesignation() {
        return Designation;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public int getEmployeeSal() {
        return EmployeeSal;
    }

    public Employee(String EmployeeName,String Designation,int EmployeeSal,int id,String deptname)
    {
        this.EmployeeSal = EmployeeSal;
        this.Designation = Designation;
        this.EmployeeName = EmployeeName;
        this.EmployeeID = id;
        this.DeptName = deptname;

    }


}
class TEmployee extends Employee
{
    int Duration;
    public int getDuration() {
        return Duration;
    }
    public TEmployee(int EmpID,String EmpName,String Designation,int EmpSal,int Duration,String deptname)
    {
        super(EmpName,Designation,EmpSal,EmpID,deptname);
        this.Duration = Duration;
    }


}

class PEmployee extends Employee
{
    int HRA;
    public int getHRA() {
        return HRA;
    }
    public PEmployee(int EmpID,String EmpName,String Designation,int EmpSal,int HRA,String deptname)
    {
        super(EmpName,Designation,EmpSal,EmpID,deptname);
        this.HRA = HRA;
    }

}

class Organization {
    TreeMap<String, LinkedList<Employee>> tm ;
    static Organization o;

    static
    {
        o=null;
    }

    private Organization()
    {
        tm= new TreeMap<String, LinkedList<Employee>>();
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
        Scanner sc = new Scanner(System.in);
        String dept="",dept1="";
        String Name;
        String Designation;
        int Sal,choice;
        int duration,hra;

        LinkedList<Employee> l1 = null;
        boolean status=false;
        do
        {
            System.out.println("1:Finance 2:Admin 3:Research");
            System.out.println("enter your choice");
            choice = sc.nextInt();
            if(choice==1)
                dept = "Finance";
            else if(choice==2)
                dept = "Admin";
            else if(choice==3)
                dept = "Research";


            System.out.println("enter name, designation and sal");
            Name = sc.next();
            Designation = sc.next();
            Sal = sc.nextInt();
            System.out.println("1:TEmployee 2:PEmployee enter your choice");
            choice=sc.nextInt();

            Employee e=null;
            if(choice==1)
            {
                System.out.println("enter the duration");
                duration =  sc.nextInt();
                e = new TEmployee(IDGenerator.getID(),Name,Designation,Sal,duration,dept);

            }
            else if(choice==2)
            {
                System.out.println("enter the hra");
                hra =  sc.nextInt();
                e=new PEmployee(IDGenerator.getID(),Name,Designation,Sal,hra,dept);
            }

            if(tm.containsKey(dept))
            {
                l1 = tm.get(dept);
                l1.add(e);

            }
            else
            {
                l1 = new LinkedList<Employee>();
                l1.add(e);
                tm.put(dept, l1);
            }
            System.out.println("enter 1 to add one more record");
            choice=sc.nextInt();
        }while(choice==1);

    }

    private void display(Employee e)
    {
        System.out.println("EmpID: "+e.getEmployeeID());
        System.out.println("Designation: "+e.getDesignation());
        System.out.println("EmployeeSal: "+e.getEmployeeSal());
        System.out.println("EmployeeName: "+e.getEmployeeName());
        System.out.println("DeptName:"+e.getDeptName());
        if(e instanceof PEmployee)
        {
            System.out.println("Employee Type: Permanent");
            System.out.println("hra: "+((PEmployee)e).getHRA());
        }
        else
        {	System.out.println("Employee Type: Temporary");
            System.out.println("Duration: "+((TEmployee)e).getDuration());
        }
        System.out.println("-------------------------");
    }

    private void dispAllEmployeeDetails()
    {
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        while(t.hasNext())
        {
            String dept = t.next();
            LinkedList<Employee> l = tm.get(dept);
            for(int i=0;i<l.size();i++)
            {
                Employee e = l.get(i);
                display(e);
            }
        }
    }

    private void dispDepartmentWise()
    {
        LinkedList<Employee> l1=null;
        Scanner sc = new Scanner(System.in);
        String dept="";
        System.out.println("enter the department");
        System.out.println("1:Finance 2:Admin 3:Research");
        System.out.println("enter your choice");
        int choice = sc.nextInt();
        if(choice==1)
            dept = "Finance";
        else if(choice==2)
            dept = "Admin";
        else if(choice==3)
            dept = "Research";
        else
            System.out.println("invalid choice");
        if(tm.containsKey(dept))
        {
            l1 = tm.get(dept);
            System.out.println("--------------------------------------------------");
            System.out.println("Employees belonging to department "+dept+" are:");
            System.out.println("--------------------------------------------------");
            for(int i=0;i<l1.size();i++)
            {
                Employee e = l1.get(i);
                display(e);
            }
        }
        else
            System.out.println("The department "+dept +" does not exists");

    }

    private void dispPermanentEmployeeDetails()
    {
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        while(t.hasNext())
        {
            String dept = t.next();
            LinkedList<Employee> l = tm.get(dept);
            for(int i=0;i<l.size();i++)
            {
                Employee e = l.get(i);
                if(e instanceof PEmployee)
                    display(e);
            }
        }
    }
    private void dispTemporaryEmployeeDetails()
    {
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        while(t.hasNext())
        {
            String dept = t.next();
            LinkedList<Employee> l = tm.get(dept);
            for(int i=0;i<l.size();i++)
            {
                Employee e = l.get(i);
                if(e instanceof TEmployee)
                    display(e);
            }
        }
    }

    public void dispEmployeeRecord()
    {
        if(tm.size()==0)
            System.out.println("no records to display");
        else
        {
            Scanner s = new Scanner(System.in);
            int choice;
            System.out.println("1:Display all employee details");
            System.out.println("2:Display only permanent employee details");
            System.out.println("3:Display only temporary employee details");
            System.out.println("4:Display Department-Wise");
            System.out.println("enter your choice");
            choice=s.nextInt();
            if(choice==1)
                dispAllEmployeeDetails();
            else if(choice==2)
                dispPermanentEmployeeDetails();
            else if(choice==3)
                dispTemporaryEmployeeDetails();
            else if(choice==4)
                dispDepartmentWise();
        }

    }



    public void searchEmployeeRecord()
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        if(tm.size()==0)
            System.out.println("no records to search");
        else
        {
            System.out.println("1:search by designation");
            System.out.println("2:search by empid");
            System.out.println("3:search by department");
            System.out.println("enter the choice");
            choice = sc.nextInt();

            if(choice==1)
            {
                String desig;
                System.out.println("enter the designation");
                desig = sc.next();
                search(desig);
            }
            else if(choice==2)
            {
                int id;
                System.out.println("enter the empid");
                id = sc.nextInt();
                search(id);
            }
            else if(choice==3)
            {
                searchDepartmentWise();
            }
            else
                System.out.println("invalid choice");

        }

    }

    private void search(String desig)
    {
        boolean status=false;
        int recordcount=0;
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        while(t.hasNext())
        {
            String dept = t.next();
            LinkedList<Employee> l=tm.get(dept);

            for(int i=0;i<l.size();i++)
            {
                Employee e = l.get(i);
                if(e.getDesignation().equalsIgnoreCase(desig))
                {
                    status=true;
                    recordcount++;
                }
            }

        }
        if(status==false)
            System.out.println("records with the designation "+desig+" not found");
        else
            System.out.println(recordcount+" records with the designation "+desig+" found");

    }

    private void search(int id)
    {
        boolean status=false;
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        outer:
        while(t.hasNext())
        {
            String dept = t.next();
            LinkedList<Employee> l=tm.get(dept);
            inner:
            for(int i=0;i<l.size();i++)
            {
                Employee e = l.get(i);
                if(e.getEmployeeID()==id)
                {
                    status=true;
                    break outer;
                }
            }

        }
        if(status==false)
            System.out.println("records with the EmpID "+id+" not found");
        else
            System.out.println("records with the EmpID "+id+" was found");


    }

    public void searchDepartmentWise()
    {
        boolean status=false;
        int recordcount=0;
        String dept;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the department");
        dept = sc.next();
        Set<String> k = tm.keySet();
        Iterator<String> t = k.iterator();
        while(t.hasNext())
        {
            if(t.next().equalsIgnoreCase(dept))
            {
                status=true;
                break;
            }
        }

        if(status==false)
            System.out.println("department "+dept+" not found");
        else
            System.out.println("department "+dept+"  found");

    }


    public void deleteEmployeeRecord()
    {
        if(tm.size()==0)
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

            Set<String> k = tm.keySet();
            Iterator<String> t = k.iterator();
            outer:
            while(t.hasNext())
            {
                String dept = t.next();
                LinkedList<Employee> l=tm.get(dept);
                inner:
                for(int i=0;i<l.size();i++)
                {
                    Employee e = l.get(i);
                    if(e.getEmployeeID()==id)
                    {
                        status=true;
                        l.remove(e);
                        if(l.size()==0)
                            tm.remove(dept);
                        break outer;
                    }
                }

            }

            if(status==false)
                System.out.println("id not found");
            else
                System.out.println("id found and record is deleted");

        }
    }

}
