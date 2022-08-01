package test.x4_1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.jar.Attributes.Name;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable{


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
     @FXML
    private Button Search;

    @FXML
    private Label Status;

    @FXML
    private Label resultAddress;

    @FXML
    private Label resultEmail;

    @FXML
    private Label resultName;

    @FXML
    private Label resultPhone;

    @FXML
    private Button secondaryButton;

    @FXML
    private TextField tID;
    
    
    @FXML
    private Label resultDept;

    

 Statement st;
    ResultSet rs;
    Connection con;
 
    
    String userName="root";
    String password="MiniSh03@";
    String dbMachine="localhost";
    String dbName="test34";
    String url="jdbc:mysql://" +dbMachine +  "/" + dbName;

    @FXML
    void doSearch(ActionEvent event) 
    {
       int ID = Integer.parseInt(tID.getText());
       
        String sql = "Select * from test34 where ID = " +ID;
        
    
          try{
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
             
            rs=st.executeQuery(sql);
            
            if(rs.next())
            {
                resultName.setText(rs.getString(2));
                resultAddress.setText(rs.getString(3));
                resultPhone.setText(rs.getString(4));
                resultEmail.setText(rs.getString(5));
                resultDept.setText(rs.getString(6));
            
                
                Status.setText("Found ...");
            }
            else
            {
                resultName.setText("");
                resultAddress.setText("");
                resultPhone.setText("");
                resultEmail.setText("");
                resultDept.setText("");
                Status.setText("ID Doesn't Exist ...");
            }
          
            
            //Status.setText("Successfully saved ...");
            // showInformationAlert();  
          }catch(Exception e)
        {
           // showInformation();
            Status.setText("" +e);
                  
        }
        
        

    }
    
    
    
    
    
    
    
    
    
}