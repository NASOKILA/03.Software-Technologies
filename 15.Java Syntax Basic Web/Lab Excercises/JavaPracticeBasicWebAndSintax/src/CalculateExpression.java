/**
 * Created by user on 03/08/2017.
 */
public class CalculateExpression {
    public static void main(String[] args) {
        double val = ((30 + 21) * (Double.parseDouble("1") /2)) * (35 - 12 - (Double.parseDouble("1") /2));
        double result = Math.pow(val, 2);
        System.out.println(result);
    }
}
