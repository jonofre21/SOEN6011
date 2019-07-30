package sinh;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * User Interface Class that will provide the main window to the user.
 * @author Jesus Onofre Diaz
 * @version 1.0
 */

public class SinhUI extends JFrame implements ActionListener {
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 400;
  private static final int FRAME_X = 550;
  private static final int FRAME_Y = 550;
  private JPanel buttonPanel;
  private JPanel inputOutputPanel;
  private JPanel inputOutputPanel2;
  private JTextField value;
  private boolean editable = true;
  double valuex;
  double valueofx;
  String finalxvalue;
        
  /**
  * Class Default Constructor.
  */
  public SinhUI()
  {
    //Defining a Container object
    Container contentPane = getContentPane();
    contentPane.setLayout(new FlowLayout());
    
    //Defining a JPanel object for the button object
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(7,7,9,9));
    buttonPanel.setBorder(new EmptyBorder(12,12,12,12));
    
    //Defining a JPanel object for the TextField object
    inputOutputPanel = new JPanel();
    inputOutputPanel.setLayout(new FlowLayout());
    inputOutputPanel.setBorder(new EmptyBorder(40,40,40,40));
    
    //Defining a JPanel object for the Instruction label object
    inputOutputPanel2 = new JPanel();
    inputOutputPanel2.setLayout(new FlowLayout());
    inputOutputPanel2.setBorder(new EmptyBorder(10,10,10,10));
            
    //Defining dimensions for the main frame
    setTitle("SINH Calculator");
    setSize(FRAME_WIDTH,FRAME_HEIGHT);
    setResizable(false);
    setLocation(FRAME_X,FRAME_Y);
    
    //Difining a label linked to the TextField object
    JLabel label = new JLabel();        
    label.setText("SINH :");
    label.setBounds(40, 40, 200, 200);
    inputOutputPanel.add(label);
    
    //Defining a label object for showing the instructions.       
    JLabel label2 = new JLabel();        
    label2.setText("<html> INPUT INSTRUCTIONS FOR SINH FUNCTION : <br> Negative and Positive Real Numbers. <br> Use Backspace to clear and type another value.</html>");
    label2.setBounds(10, 10, 10, 10);
    inputOutputPanel2.add(label2);
    contentPane.add(inputOutputPanel2);
    label2.setFont(new Font("Arial", Font.BOLD, 12));
    
    //Defining a JTextField object for user input
    value = new JTextField();
    value.setFont(new Font("Arial", Font.PLAIN, 16));
    value.setBackground(Color.white);
    value.setBorder(BorderFactory.createLineBorder(Color.black));
    value.setPreferredSize(new Dimension(240, 40));
    value.addActionListener(this);
    inputOutputPanel.add(value);
    contentPane.add(inputOutputPanel);
    
    //Defining a button object for activate operations
    JButton button = new JButton("Calculate");
    button.addActionListener(this);
    buttonPanel.add(button);
    contentPane.add(buttonPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
        
  /**
   * Activates the user main action.
   * @param event user action an event when click on the button.
   */     
  public void actionPerformed(ActionEvent event)
  {
    
    /**
     * Button action performed event
     *
     * @throws NumberFormatException If an I/O error occurs.
     */
    try {
      if (event.getSource() instanceof JButton)
      {
        JButton clickedButton = (JButton) event.getSource();      
        if (value.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "System needs a value");
        }
                
        if (clickedButton.getText().equals("Calculate"))
        {
          showResult();            
        }
        else
        {
          addValue(clickedButton.getText());
        }
      }
      else
      {
        showResult();
      }
    }
    catch (NumberFormatException e)
    {
      System.out.println("System needs a value");
    }
  }

  /**
   * Method for setting values.
   * @param line captures user's input.
   */       
  public void addValue(String line)
  {
    if (editable)
    {
      value.setText(value.getText() + line);
    }
    else
    {
      value.setText(line);
      editable = true;
    }
  }
        
  /**
   * Method which pass the user input to the
   * logic methods to show the final result to the user
   * or a waring messages in case of wrong typos.
   */
  public void showResult()
  {
    
    /**
     * Show results event.
     *
     * @throws ScriptException If an script error occurs.
     */
    try
    {
      //Calling the main logic method to calculate the Sinh value
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine engine = mgr.getEngineByName("JavaScript");
      valuex = Double.parseDouble(value.getText());
      valueofx = SinhLogic.calculate_Sinh(valuex); 
      finalxvalue = String.valueOf(valueofx);
      value.setText(engine.eval(finalxvalue).toString());               
    }
    catch (ScriptException e)
    {
      value.setText("Syntax error");
    }
    editable = false;
  }
        

  /**
   * Program main method
   * which makes visible the user interface.
   * @param args arguments to be passed.     
   */
  public static void main(String [] args)
  {
    SinhUI sinh = new SinhUI();
    sinh.setVisible(true);
  }

}