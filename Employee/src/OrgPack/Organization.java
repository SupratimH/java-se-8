package OrgPack;

import UtilityPack.IDGenerator;

public class Organization {

    private Organization() {}
    private static Organization orgInst = null;
    public static Organization createOrganization() {
        if (orgInst == null)
            orgInst = new Organization();
        return orgInst;
    }

    private Employee[] employees = new Employee[10];
    private int empCount = 0;

    public void addEmployeeRecord(String empName, float empSalary, String empDesignation) {
        employees[empCount++] = new Employee(IDGenerator.generateID(), empName, empSalary, empDesignation);
    }

    public void displayEmployeeRecord() {
        for(int i = 0; i < empCount; i++) {
            if (employees[i] == null) continue;
            System.out.println("ID: " + employees[i].empId);
            System.out.println("Name: " + employees[i].empName);
            System.out.println("Salary: " + employees[i].empSalary);
            System.out.println("Designation: " + employees[i].empDesignation);
            System.out.println();
        }
    }

    public void searchEmployeeRecord(String empDesignation) {
        for(int i = 0; i < empCount; i++) {
            if (employees[i] == null) continue;
            if(employees[i].empDesignation.equalsIgnoreCase(empDesignation)) {
                System.out.println("Name: " + employees[i].empName);
                System.out.println("Salary: " + employees[i].empSalary);
                System.out.println("Designation: " + employees[i].empDesignation);
                System.out.println();
            }
        }
    }

    public void deleteEmployeeRecord(int empId) {
        for(int i = 0; i < empCount; i++) {
            if (employees[i] == null) continue;
            if(employees[i].empId == empId) {
                employees[i] = null;
            }
        }
    }

    private class Employee {
        private int empId;
        private String empName;
        private float empSalary;
        private String empDesignation;

        private Employee(int empId, String empName, float empSalary, String empDesignation) {
            setEmpId(empId);
            setEmpName(empName);
            setEmpSalary(empSalary);
            setEmpDesignation(empDesignation);
        }

        private int getEmpId() {
            return empId;
        }

        private void setEmpId(int empId) {
            this.empId = empId;
        }

        private String getEmpName() {
            return empName;
        }

        private void setEmpName(String empName) {
            this.empName = empName;
        }

        private float getEmpSalary() {
            return empSalary;
        }

        private void setEmpSalary(float empSalary) {
            this.empSalary = empSalary;
        }

        private String getEmpDesignation() {
            return empDesignation;
        }

        private void setEmpDesignation(String empDesignation) {
            this.empDesignation = empDesignation;
        }
    }
}
