package Employee_Payroll_System;

class FullTimeEmployee extends Employee {
    protected double baseSalary;
    protected String role; // SWE / HR
    protected double extra; // perfBonus OR hiringCommission

    FullTimeEmployee(int empID, String name, String panNo, String dept,
                     String joiningDate, String designation,
                     double baseSalary, String role, double extra) {

        super(empID, name, panNo, dept, joiningDate, designation);
        this.baseSalary = baseSalary;
        this.role = role;
        this.extra = extra;
    }

    @Override
    public double calcCTC() {

        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + extra; // perfBonus
        }
        else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + extra; // hiringCommission
        }
        else {
            return baseSalary;
        }
    }
}