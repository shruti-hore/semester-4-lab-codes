package Employee_Payroll_System;

public class MAIN {
    public static void main(String[] args) {

        // Manager
        Employee m = new Manager(
                101, "ABC", "ABCDE1234F", "HR", "2020-01-10", "Manager",
                50000, 10000, 5000, 2000);

        // SWE Employee
        Employee e1 = new FullTimeEmployee(
                102, "DEF", "FGHIJ5678K", "IT", "2021-03-15", "SWE",
                45000, "SWE", 8000);

        // HR Employee
        Employee e2 = new FullTimeEmployee(
                103, "XYZ", "LMNOP1111Q", "HR", "2022-02-20", "HR Executive",
                40000, "HR", 6000);

        // Contract Employee
        Employee c = new ContractEmployee(
                104, "GHI", "KLMNO9012P", "Support", "2023-06-01", "Contractor",
                160, 500);

        Employee[] employees = {m, e1, e2, c};

        System.out.println("=== EMPLOYEE PAYROLL SYSTEM ===\n");

        for (Employee e : employees) {
            e.displayInfo();
            System.out.println("Total CTC   : " + e.calcCTC());
            System.out.println("--------------------------------");
        }
    }
}