import java.util.Scanner;
public class TaxTime {
    //-----Input Incomes & Deductions--------------------------------
    public static void input(double arr[]) {
        Scanner sc = new Scanner(System.in);
        String str;
        double amount;
        while (true) {
            try {
                System.out.print("Enter next amount :");
                str = sc.nextLine();
                amount = Double.parseDouble(str);
                if (amount == 0)
                    break;
                if (amount > 0)
                    arr[0] = arr[0] + amount;
                if (amount < 0)
                    arr[1] = arr[1] + (-1 * amount);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
        sc.close();
    }
    //-------Compute Taxable Income----------------------------------------
    public static double computeTaxableIncome(double income, double deduction) {
        if (income >= deduction)
            return income - deduction;
        return 0.0;
    }
    //-----Choose Tax Group-------------------------------------------
    public static String computeTaxGroup(double taxable) {
        if (taxable >= 500000)
            return "S";
        if (taxable >= 200000)
            return "Q";
        if (taxable >= 100000)
            return "M";
        if (taxable >= 50000)
            return "A";
        if (taxable >= 20000)
            return "R";
        return "P";
    }
    //----Compute Tax-----------------------------------
    public static double computeTax(String taxGroup, double taxable) {
        if (taxGroup.equals("S") || taxGroup.equals("Q"))
            return taxable * 0.25;
        if (taxGroup.equals("M"))
            return taxable * 0.10;
        if (taxGroup.equals("A") || taxGroup.equals("R"))
            return taxable * 0.03;
        if (taxGroup.equals("P"))
            return 0;
        //for error return -1
        return -1;
    }
    //-----Display Output-----------------------------------
    public static void main(String args[]) {
        double incomeDeduction[] = new double[2];
        input(incomeDeduction);
        double income = incomeDeduction[0];
        double deduction = incomeDeduction[1];
        double taxableIncome = computeTaxableIncome(income, deduction);
        String taxGroup = computeTaxGroup(taxableIncome);
        System.out.println("Income = $" + income);
        System.out.println("Deduction = $" + deduction);
        System.out.println("Taxable income = $" + taxableIncome);
        System.out.println("Tax group = " + taxGroup);
        System.out.println("Tax owed = $" + computeTax(taxGroup, taxableIncome));
    }
}