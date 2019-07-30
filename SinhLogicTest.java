package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import sinh.SinhLogic;

/**
 * Unit Test for the Business Logic Class and its dependent 
 * methods.
 * @author Jesus Onofre Diaz
 * @version 1.0
 *
 */
class SinhLogicTest {
  
  /**
   * JUnit test for the Power function.
   */
  @Test
  void test_Power() {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.power_X(2,3);
    
    assertEquals(8.0,res,0);
  }
  
  /**
   * JUnit test for the e value elevated to an exponent.
   */
  @Test
  void test_Calculate_E_to_X()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.calculate_E_to_X(1);

    assertEquals(2.7182818284590455,res,0);
  }
  
  /**
   * JUnit test to calculate the factorial of a given number.
   */
  @Test
  void test_Factorial()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.factorial(5);
    
    assertEquals(120.0,res,0);
  }
  
  /**
   * JUnit test to calculate the absolute value of a given number 
   */
  @Test
  void test_Absolute()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.absolute_value(-1);
    assertEquals(1.0,res,0);
  }
  
  /**
   * JUnit test for calculating the Sinh value.
   */
  @Test
  void test_Sinh()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.calculate_Sinh(1);
    
    assertEquals(1.1752011936438016,res,0);
  }
}
