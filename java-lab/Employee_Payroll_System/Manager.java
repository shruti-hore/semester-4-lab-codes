package Employee_Payroll_System;

class Manager extends FullTimeEmployee {
    private double ta;
    private double eduAllowance;

    Manager(int empID, String name, String panNo, String dept,
            String joiningDate, String designation,
            double baseSalary, double perfBonus,
            double ta, double eduAllowance) {

        super(empID, name, panNo, dept, joiningDate, designation,
              baseSalary, "SWE", perfBonus);

        this.ta = ta;
        this.eduAllowance = eduAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + extra + ta + eduAllowance;
    }
}