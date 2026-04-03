package Employee_Payroll_System;

abstract class Employee {
    protected int empID;
    protected String name;
    protected String panNo;
    protected String dept;
    protected String joiningDate;
    protected String designation;

    Employee(int empID, String name, String panNo, String dept, String joiningDate, String designation) {
        this.empID = empID;
        this.name = name;
        this.panNo = panNo;
        this.dept = dept;
        this.joiningDate = joiningDate;
        this.designation = designation;
    }

    public abstract double calcCTC();

    public void displayInfo() {
        System.out.println("Employee ID : " + empID);
        System.out.println("Name        : " + name);
        System.out.println("PAN No.     : " + panNo);
        System.out.println("Department  : " + dept);
        System.out.println("Designation : " + designation);
    }
}