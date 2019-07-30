package sinh;

/**
 * Business Logic Class, which implements the different procedures
 * to calculate the Sinh of a number.
 * @author JOnofre
 * @version 1.0
 */
public class SinhLogic {

  /**
   * Method to calculate the power of of a passed number and power passed.
   * @param     base    number to be calculated the power
   * @param     power   power to be calculated
   * @return    sum
   */
  public static double power_X(double base, double power)
  {
    double sum = 1;
    for (int i = 0; i < power; i++) {
      sum = sum * base;
    }
      
    return sum;
  }
  
  /**
   * Calculate the value of e.
   * @param x number to be calculated
   * @return
   */
  public static double calculate_E_to_X(double x)
  {
    double sum = 0;
    for (int i = 0; i < 99; i++) {
      sum += power_X(x,i) / factorial(i);
    }
    return sum;
  }

  /**
   * Function to calculate the factorial of a number,
   * this function will collaborate with the calculate_E.
   * @param     pow numerical value for getting a factorial.
   * @return    sum
   */
  public static double factorial(double pow)
  {
    if (pow == 0)
    {
      return 1;
    }
    return pow * factorial(pow - 1);
  }
  
  /**
   * 
   * @param n receives the number to be get the absolute value
   * @return
   */
  public static double absolute_value(double n)
  {
      double a= n*-1;
      return a;
  }
  
  /**
   * Function responsible to calculate the final value that will be
   * passed to the user.
   * @param  x   user input
   * @return sum   final output
   */
  public static double calculate_Sinh(double x)
  {
    double result;
    double r1 = calculate_E_to_X(x);
    double r2 = calculate_E_to_X(-x);
    result = (r1 - r2) / 2;
    return result;
  }
}
