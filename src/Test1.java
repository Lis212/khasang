/**
 * Created by ????????????? on 02.01.2018.
 */
public class Test1 {
    public static void main(String[] args) {
        double bmi = bodyMassIndex(66, 1.86);
        System.out.println(bmi);
    }

    static double bodyMassIndex(int weight, double inch) {
        double bmi = (double) weight / (inch * inch);
        return bmi;
    }


}
