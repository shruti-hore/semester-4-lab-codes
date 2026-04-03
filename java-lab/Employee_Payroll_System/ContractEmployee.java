package Employee_Payroll_System;

class ContractEmployee extends Employee {
    private float noOfHrs;
    private float hourlyRate;

    ContractEmployee(int empID, String name, String panNo, String dept,
                     String joiningDate, String designation,
                     float noOfHrs, float hourlyRate) {

        super(empID, name, panNo, dept, joiningDate, designation);
        this.noOfHrs = noOfHrs;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcCTC() {
        return noOfHrs * hourlyRate;
    }
}