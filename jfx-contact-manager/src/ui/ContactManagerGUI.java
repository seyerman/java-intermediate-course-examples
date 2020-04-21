package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Contact;
import model.ContactManager;

public class ContactManagerGUI {
    @FXML
    private BorderPane mainPanel;
	
    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableView<Contact> tvContactList;
    
    @FXML
    private TableColumn<Contact, String> tcName;

    @FXML
    private TableColumn<Contact, String> tcEmail;
    
    @FXML
    private Label labMsg;
    
    private ContactManager contactManager;
    
    public ContactManagerGUI(ContactManager cm) {
    	contactManager = cm;    	
	}
    
    /**
     * This method is called each time when a fxml file associated with this object/class is loaded
     */
    public void initialize() {
    	
    	//this condition is cause this method (initilize) is called several times by diferents fxml file loads 
    	if(tvContactList!=null) {
    		initilizeTableView();
    	}
    }
    
    private void initilizeTableView() {
    	ObservableList<Contact> observableList;
    	observableList = FXCollections.observableArrayList(contactManager.getContacts());
    	
		tvContactList.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Contact,String>("name"));
		tcEmail.setCellValueFactory(new PropertyValueFactory<Contact,String>("email"));		
    }
    
    @FXML
    public void loadAddContact(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-contact.fxml"));
		
		fxmlLoader.setController(this);    	
		BorderPane addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);
    }

    @FXML
    public void loadContactList(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("contact-list.fxml"));
		
		fxmlLoader.setController(this);
		BorderPane contactListPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setCenter(contactListPane);
    }
    
    @FXML
    public void addContact(ActionEvent event) {
    	//add contact in the model
    	contactManager.addContact(txtName.getText(),txtEmail.getText());
    	
    	//clean the fields in the gui
    	txtName.setText("");
    	txtEmail.setText("");
    	
    	//show the success message
    	labMsg.setText("The contact was added succesfully!");
    }
    
    @FXML
    public void showAbout(ActionEvent event) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Contact Manager");
	    alert.setHeaderText("Credits");
	    alert.setContentText("Juan Reyes\nAlgorithms II");
	
	    alert.showAndWait();
    }
}
