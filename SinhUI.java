package sinh;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/*****************************************************************
User Interface Class that will provide the main window to the user.

@author Jesus Onofre Diaz
@version 1.0
*****************************************************************/

public class SinhUI extends JFrame implements ActionListener {
        private static final int FRAME_WIDTH = 400;
        private static final int FRAME_HEIGHT = 400;
        private static final int FRAME_X = 550;
        private static final int FRAME_Y = 550;
        private JPanel buttonPanel;
        private JPanel inputOutputPanel;
        private JTextField value;
        private boolean editable = true;
        double value_of_x;
        double x;
        String val_of_x;
        //SinhLogic logic = new SinhLogic();
        
        /*****************************************************************
        Default Constructor constructs the frame of the program
        *****************************************************************/
        
        public SinhUI()
        {
            
          /*
           * Creates Program Frame
           */
            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(7,7,9,9));
            buttonPanel.setBorder(new EmptyBorder(12,12,12,12));

            inputOutputPanel = new JPanel();
            inputOutputPanel.setLayout(new FlowLayout());
            inputOutputPanel.setBorder(new EmptyBorder(12,12,12,12));

            setTitle("SINH Calculator");
            setSize(FRAME_WIDTH,FRAME_HEIGHT);
            setResizable(false);
            setLocation(FRAME_X,FRAME_Y);
            
            /*
             * Creates user input and 
             * indication labels
             */
            
            JLabel label = new JLabel();        
            label.setText("SINH :");
            label.setBounds(10, 10, 100, 100);
            inputOutputPanel.add(label);
            
            /*
             * Creates the Frame format
             * for the text input
             */
            
            value = new JTextField();
            value.setFont(new Font("Arial", Font.PLAIN, 16));
            value.setBackground(Color.white);
            value.setBorder(BorderFactory.createLineBorder(Color.black));
            value.setPreferredSize(new Dimension(240, 40));
            value.addActionListener(this);
            inputOutputPanel.add(value);
            contentPane.add(inputOutputPanel);
                
            /*
             * Creates and formats the Calculate button
             */
            
            JButton button = new JButton("Calculate");
            button.addActionListener(this);
            buttonPanel.add(button);
            contentPane.add(buttonPanel);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        
        /*****************************************************************
        Activates the user main action
        @param event user action an event when click on the button
        *****************************************************************/
        
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() instanceof JButton)
            {
                JButton clickedButton = (JButton) event.getSource();
                if(clickedButton.getText().equals("Calculate"))
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
        
        /*****************************************************************
        Method for setting values
        @param line captures user's input
        *****************************************************************/
        
        public void addValue(String line)
        {
            if(editable)
            {
                value.setText(value.getText()+line);
            }
            else
            {
                value.setText(line);
                editable = true;
            }
        }
        
        /*****************************************************************
        Method which pass the user input to the
        logic methods to show the final result to the user
        or a waring messages in case of wrong typos
        *****************************************************************/
        
        public void showResult()
        {
            double output = 0;
            try
            {
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                value_of_x = Double.parseDouble(value.getText());
                x = SinhLogic.calculate_Sinh(value_of_x); 
                val_of_x =String.valueOf(x);
                value.setText(engine.eval(val_of_x).toString());               
            }
            catch(ScriptException e)
            {
                value.setText("Syntax error");
            }
            editable = false;
        }
        
        /*****************************************************************
        Program main method
        which makes visible the user interface
        @param args arguments to be passed
        *****************************************************************/
        
        public static void main (String [] args)
        {
            SinhUI sinh = new SinhUI();
            sinh.setVisible(true);
        }

}