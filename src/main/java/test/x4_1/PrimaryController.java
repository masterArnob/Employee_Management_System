package test.x4_1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

    //@FXML
    //private TableColumn<?, ?> tAddress;
   // @FXML
   // private TableColumn<?, ?> tPhone;
    //@FXML
   // private TableColumn<?, ?> tEmail;
    @FXML
    private TextField tID;
    @FXML
    private TextField tName;
    @FXML
    private TextField tAddress;
    @FXML
    private TextField tPhone;
    @FXML
    private TextField tEmail;
    @FXML
    private TableColumn<?, ?> IDTable;
    @FXML
    private TableColumn<?, ?> NameTable;
    @FXML
    private TableColumn<?, ?> AddressTable;
    @FXML
    private TableColumn<?, ?> PhoneTable;
    @FXML
    private TableColumn<?, ?> EmailTable;


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    
    
    
    
    
    
    
    
    
     @FXML
    private Button Save;
    @FXML
    private Button Update;
    @FXML
    private Button Delete;
    @FXML
    private Button Clear;
    @FXML
    private Button primaryButton;
    @FXML
    private TableView<User> Table;
    private TableColumn<User, Integer> ID;
    private TableColumn<User, String> Name;
   private TableColumn<User, String> Address;
    private TableColumn<User, String> Phone;
    private TableColumn<User, String> Email;
    @FXML
    private Label Status;
    @FXML
    private ComboBox<String> comboBox;

    /**
     * Initializes the controller class.
     */
    
    
    
       
    Statement st;
    ResultSet rs;
    Connection con;
 
    
    String userName="root";
    String password="MiniSh03@";
    String dbMachine="localhost";
    String dbName="test34";
    String url="jdbc:mysql://" +dbMachine +  "/" + dbName;
    
    //ObservableList<User>List = FXCollections.observableArrayList();
     ObservableList<User>List = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         comboBox.setItems(FXCollections.observableArrayList("Accounts", "HR", "IT"));
         
         DatabaseConnection con = new DatabaseConnection();
        Connection connectDB = con.getDBConnection();
        
        
        
        
        
        String sql = "select * from test34";
        
        
        try{
            
            st = connectDB.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next())
            {
                Integer ID = rs.getInt("ID");
                String Name = rs.getString("Name");
                String Address = rs.getString("Address");
                String Phone = rs.getString("Phone");
                String Email = rs.getString("Email");
                String Dept = rs.getString("Dept");

                List.add(new User(ID, Name, Address, Phone, Email, Dept)  );
               
            }
            
            
            IDTable.setCellValueFactory((new PropertyValueFactory<>("ID")));
            NameTable.setCellValueFactory((new PropertyValueFactory<>("Name")));
            AddressTable.setCellValueFactory((new PropertyValueFactory<>("Address")));
            PhoneTable.setCellValueFactory((new PropertyValueFactory<>("Phone")));
            EmailTable.setCellValueFactory((new PropertyValueFactory<>("Email")));
            //DeptTable.setCellValueFactory((new PropertyValueFactory<>("Dept")));
            
            Table.setItems(List);
            
            
            
        }catch(Exception e)
        {
            Status.setText("" +e);
        }
             
     
         
         
        // TODO
    }    

    @FXML
    private void doSave(ActionEvent event) 
    {
        
        
            
        
           int ID = Integer.parseInt(tID.getText());
        String Name = tName.getText();
        String Address = tAddress.getText();
        String Phone = tPhone.getText();
        String Email = tEmail.getText();
        String Dept = comboBox.getSelectionModel().getSelectedItem().toString();
                
        String sql = "insert into test34 values(" +ID + ",'"+Name+"','"+Address+"','"+Phone+"','"+Email+"','"+Dept +"')";
        
    
          try{
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
             
            st.executeUpdate(sql);
            
            
            Status.setText("Successfully saved ...");
            // showInformationAlert();  
          }catch(Exception e)
        {
            showInformation();
            //Status.setText("" +e);
                  
        }
          
        
    
    }

    @FXML
    private void doUpdate(ActionEvent event) 
    {
        
         int ID = Integer.parseInt(tID.getText());
        String Name = tName.getText();
        String Address = tAddress.getText();
        String Phone = tPhone.getText();
        String Email = tEmail.getText();
        String Dept = comboBox.getSelectionModel().getSelectedItem().toString();
       
      
        //String sql = "update test34 set Name = '" +Name "', Address = '" +Address +"', Phone = '" +Phone +"', Email = '" +Email +"', Dept = '" +Dept +"' where ID = " +ID ;  
       
       String sql = "update test34 set Phone = '" +Phone +"' , Name ='" +Name +"' , Address = ' " +Address +"' , Dept = ' " +Dept +" ' ,  Email = '"+Email  +"' where ID = " +ID ; 
       
       try{
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
            
            st.executeUpdate(sql);
            Status.setText("Successfully updated ...");
        }catch(Exception e)
        {
            Status.setText("" +e);
        }
    }

    @FXML
    private void doDelete(ActionEvent event) 
    {
          int ID=Integer.parseInt(tID.getText());
       
       String sql = "delete from test34 where ID = " +ID ;
     
       
       try{
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
            
            st.executeUpdate(sql);
           
            Status.setText("Successfully deleted ...");
        }catch(Exception e)
        {
            Status.setText("" +e);
       
        }
    }

    @FXML
    private void doClear(ActionEvent event) 
    {
        tID.setText("");
        tName.setText("");
        tAddress.setText("");
        tPhone.setText("");
        tEmail.setText("");
        Status.setText("");
        comboBox.setValue("");
    }

    
    
    
    public void showInformation()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("ID Already Exist");
        alert.show();
    }
    
    
}
