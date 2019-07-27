package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sinh.SinhLogic;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertThat;

/*****************************************************************
Unit Test for the Business Logic Class and its dependent 
methods.
@author Jesus Onofre Diaz
@version 1.0
*****************************************************************/
class SinhLogicTest {
  
 

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void test_Power() {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.power_X(2,3);
    
    assertEquals(8.0,res,0);
  }
  
  @Test
  void test_Calculate_E_to_X()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.calculate_E_to_X(1);
    
    assertEquals(2.7182818284590455,res,0);
  }
  
  @Test
  void test_Factorial()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.factorial(5);
    assertEquals(120.0,res,0);
  }
  
  @Test
  void test_Sinh()
  {
    double res;
    SinhLogic logic = new SinhLogic();
    res = logic.calculate_Sinh(1);
    assertEquals(1.1752011936438016,res,0);
  }
}
