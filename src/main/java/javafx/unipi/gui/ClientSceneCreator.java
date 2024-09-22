package javafx.unipi.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.unipi.core.Client;
import javafx.unipi.core.Contract;
import javafx.unipi.core.TelecommunicationCompany;

public class ClientSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

	ArrayList<Client> clientList; //arxikopoihsh listas typou client
	
	//flowpane
	FlowPane buttonFlowPane, searchFlowPane; 
	
	//gridpane
	GridPane rootGridPane, inputFieldsPane;
	
	//buttons
	Button newClientBtn, modifyClientBtn, deleteClientBtn, backBtn, searchBtn, searchBtn2;
	
	//labels
	Label licensenumberLbl, afmLbl, nameLbl, surnameLbl, jobLbl, adressLbl, emailLbl, phoneLbl, searchLb, searchLb2;
	
	//textfields
	TextField licensenumberField, afmField, nameField, surnameField, jobField, adressField, emailField, phoneField, searchField, searchField2;
	
	TableView<Client> clientTableView; //arxikopoihsh pinaka typou client
	
	String licensenumber;

	public ClientSceneCreator(double width, double height) {
			
		super(width, height);
		
		//Initialize fields
		clientList = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		searchFlowPane = new FlowPane();
		licensenumberLbl = new Label("License Number: ");
		afmLbl = new Label("Tax Number: ");
		nameLbl = new Label("Name: ");
		surnameLbl = new Label("Surname: ");
		jobLbl = new Label("Job: ");
		adressLbl = new Label("Adress: ");
		emailLbl = new Label("E-mail: ");
		phoneLbl = new Label("Phone Number: ");
		licensenumberField = new TextField();
		afmField = new TextField();
		nameField = new TextField();
		surnameField = new TextField();
		jobField = new TextField();
		adressField = new TextField();
		emailField =  new TextField();
		phoneField = new TextField();
		newClientBtn = new Button("New");
		modifyClientBtn = new Button("Update");
		deleteClientBtn = new Button("Delete");
		inputFieldsPane = new GridPane();
		clientTableView = new TableView<>();
	    backBtn = new Button("Go Back");
        searchBtn = new Button("Search");
	    searchLb = new Label("Licence: ");
	    searchField = new TextField();
	    searchLb2 = new Label("AFM: ");
	    searchField2 = new TextField();
	    
        searchFlowPane.setAlignment(Pos.TOP_LEFT);
        searchFlowPane.setHgap(10);
        searchFlowPane.setVgap(10);
        searchFlowPane.getChildren().add(searchLb);
        searchFlowPane.getChildren().add(searchField);
        searchFlowPane.getChildren().add(searchLb2);
        searchFlowPane.getChildren().add(searchField2);
        searchFlowPane.getChildren().add(searchBtn);
		
		//custom FlowPane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newClientBtn);
		buttonFlowPane.getChildren().add(modifyClientBtn);
		buttonFlowPane.getChildren().add(deleteClientBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
		//custom GridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(licensenumberLbl, 0, 0);
        inputFieldsPane.add(licensenumberField, 1, 0);
        inputFieldsPane.add(afmLbl, 0, 1);
        inputFieldsPane.add(afmField, 1, 1);
        inputFieldsPane.add(nameLbl, 0, 2);
        inputFieldsPane.add(nameField, 1, 2);
        inputFieldsPane.add(surnameLbl, 0, 3);
        inputFieldsPane.add(surnameField, 1, 3);
        inputFieldsPane.add(jobLbl, 0, 4);
        inputFieldsPane.add(jobField, 1, 4);
		inputFieldsPane.add(adressLbl, 0, 5);
		inputFieldsPane.add(adressField, 1, 5);
		inputFieldsPane.add(emailLbl, 0, 6);
		inputFieldsPane.add(emailField, 1, 6);
		inputFieldsPane.add(phoneLbl, 0, 7);
		inputFieldsPane.add(phoneField, 1, 7);

		
		//custom rootGridPane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(searchFlowPane, 0, 0);
		rootGridPane.add(inputFieldsPane, 2, 1);
		rootGridPane.add(clientTableView, 0, 1);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 2, 2);
		
		//customize TableView
		TableColumn<Client, String> licensenumberColumn = new TableColumn<>("License Number");
		licensenumberColumn.setCellValueFactory(new PropertyValueFactory<>("licensenumber"));
		clientTableView.getColumns().add(licensenumberColumn);
		
		TableColumn<Client, String> afmColumn = new TableColumn<>("Tax Number");
		afmColumn.setCellValueFactory(new PropertyValueFactory<>("afm"));
		clientTableView.getColumns().add(afmColumn);
		
		TableColumn<Client, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		clientTableView.getColumns().add(nameColumn);
		
		TableColumn<Client, String> surnameColumn = new TableColumn<>("Surname");
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
		clientTableView.getColumns().add(surnameColumn);
		
		TableColumn<Client, String> jobColumn = new TableColumn<>("Job");
		jobColumn.setCellValueFactory(new PropertyValueFactory<>("job"));
		clientTableView.getColumns().add(jobColumn);
		
		TableColumn<Client, String> adressColumn = new TableColumn<>("Adress");
		adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
		clientTableView.getColumns().add(adressColumn);
		
		TableColumn<Client, String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		clientTableView.getColumns().add(emailColumn);
		
		TableColumn<Client, String> phoneColumn = new TableColumn<>("Phone Number");
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		clientTableView.getColumns().add(phoneColumn);
		
		//attach event
		backBtn.setOnMouseClicked(this);
		newClientBtn.setOnMouseClicked(this);
		modifyClientBtn.setOnMouseClicked(this);
		deleteClientBtn.setOnMouseClicked(this);
		clientTableView.setOnMouseClicked(this);
		searchBtn.setOnMouseClicked(this);
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		if (event.getSource() == backBtn) { //back button
			
			//epistrofh sthn arxikh selida
			App.primaryStage.setTitle("Telecommunication System Window");
			App.primaryStage.setScene(App.mainScene);
		}
		
		if (event.getSource() == newClientBtn) { //dhmiourgia neou pelath
			
			String licensenumber = licensenumberField.getText();
			String name = nameField.getText();
			String surname = surnameField.getText();
			String job = jobField.getText();
			String adress = adressField.getText();
			String email = emailField.getText();
			
			
			
            try { //elegxos an to afm kai to phone einai Strings
            	
            	long afm = Long.parseLong(afmField.getText());	
            	long phone = Long.parseLong(phoneField.getText());
            	String phoneString = String.valueOf(phone);
            	String afmString = String.valueOf(afm);
            	
    			int i = 0;
    				
    			if (clientList.size() == 0 ) {
					
					if (phoneString.length() == 10 && afmString.length() == 9) {
	            		
	            		createClient(licensenumber, afm, name, surname, job, adress, email, phone);
	            		
	            	}
				}
    			
    				for (i=0 ; i<clientList.size(); i++) {
    					
    					if (clientList.get(i).getAfm() != afm && !clientList.get(i).getLicensenumber().equals(licensenumber)) {
    						
    						if (phoneString.length() == 10 && afmString.length() == 9) {
    		        
    		            		createClient(licensenumber, afm, name, surname, job, adress, email, phone);
    		            		
    		            	}
    						
    					}
    					
    				}
            	
            	
			} catch (NumberFormatException e) {
				
				//proeidopoihsh an to afm h/kai to phone einai Strings
				Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("The value provided for afm and/or phone is not a number. \n Exception message: "+ e.getMessage());
				alertType.show();
				
			}
            
            
            tableSync(); //metafora pediwn se pinaka
            clearTextFields(); //katharismos pediwn
            
            //??phone = 10 
            //afm = 9
            //monadiko afm kai adt
		
		}
		
		if (event.getSource() == modifyClientBtn) { //tropopoihsh stoixeiwn pelath
			
			String name = nameField.getText();
			String surname = surnameField.getText();
			String job = jobField.getText();
			String adress = adressField.getText();
			String email = emailField.getText();
			long phone = Long.parseLong(phoneField.getText());
			updateClient(licensenumber, name, surname, job, adress, email, phone);
            tableSync(); //metafora pediwn se pinaka
            clearTextFields(); //katharismos pediwn
			
		}
		
		if (event.getSource() == deleteClientBtn) { //diagrafh pelath
			int i;
			List<Contract> list = ContractSceneCreator.getContractList();

			for(i=0;i < list.size(); i++) {
			if(!(afmField.getText().equals(list.get(i).getAfm()))) { //elenxos gia an yparxei plan me thn eteairia pou diagrafetai
			deleteClient(nameField.getText());
			}
			}
			tableSync(); //metafora pediwn se pinaka
			clearTextFields(); //katharismos pediwn
	    }
		
        if (event.getSource() == clientTableView) { 
        	
            Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
            
            if (selectedClient != null) {
            	
                licensenumberField.setText(selectedClient.getLicensenumber());
                afmField.setText(Long.toString(selectedClient.getAfm()));
                nameField.setText(selectedClient.getName());
                surnameField.setText(selectedClient.getSurname());
                jobField.setText(selectedClient.getJob());
                adressField.setText(selectedClient.getAdress());
                emailField.setText(selectedClient.getEmail());
                phoneField.setText(Long.toString(selectedClient.getPhone()));
                
            }
            
        }
        
        if(event.getSource() == searchBtn){

           	
       		//LiveSearch
       		FilteredList<Client> filteredData = new FilteredList<>(FXCollections.observableList(clientList));
       		clientTableView.setItems(filteredData);
       		
       		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
       			filteredData.setPredicate(n -> {
       				// If filter text is empty, display all plans.
       				if (newValue == null || newValue.isEmpty()) {
       					return true;
       				}
       				
       				// Compare Company name  with filter text.
       				String lowerCaseFilter = newValue.toLowerCase();
       				String afmString = String.valueOf(n.getAfm());
       				
       				//Search	
   					if (n.getLicensenumber().toLowerCase().contains(lowerCaseFilter) && afmString.toLowerCase().contains(searchField2.getText())) {
    					return true; // Filter matches Company name.
    				}
   					
       				return false; // Does not match.

       			});
       		});
       		
       		clientTableView.setItems(filteredData);
       		
       		searchField2.textProperty().addListener((observable, oldValue, newValue) -> {
       			filteredData.setPredicate(n -> {
       				// If filter text is empty, display all plans.
       				if (newValue == null || newValue.isEmpty()) {
       					return true;
       				}
       				
       				// Compare Company name  with filter text.
       				String lowerCaseFilter = newValue.toLowerCase();
       				
       				//Search
    				String afmString = String.valueOf(n.getAfm());
    				
    				if (afmString.toLowerCase().contains(lowerCaseFilter) && n.getLicensenumber().toLowerCase().contains(searchField.getText())) {
    					return true; // Filter matches Company name.
    				}     	
       				
       				return false; // Does not match.

       			});
       		});
       		
       		//filteredData.comparatorProperty().bind(planTableView.comparatorProperty());
       		
       		clientTableView.setItems(filteredData);
       	
       }
		
	}

	public void createClient(String licensenumber, long afm, String name, String surname, String job, String adress, String email, long phone) {
    	
        Client c = new Client(licensenumber, afm, name, surname, job, adress, email, phone);
        clientList.add(c); //prosthkh neou pelath kai perasma twn stoixeiwn tou ston pinaka
        
    }
    
    public void tableSync() {
    	
        List<Client> items = clientTableView.getItems();
        items.clear();
        for (Client c : clientList) {
        	
            if (c instanceof Client) {
            	
                items.add((Client) c);
                
            }
            
        }
        
    }
    
    
    public void updateClient(String licensenumber, String name, String surname, String job, String adress, String email, long phone) {
    	
        for (Client c : clientList) {
        	
            if ((c.getLicensenumber()).equals(licensenumber)) {
            	
                c.setName(name);
                c.setSurname(surname);
                c.setJob(job);
                c.setAdress(adress);
                c.setEmail(email);
                c.setPhone(phone);
            }
            
        }
        
    }
    
    public void deleteClient(String name) {
    	
        for (int i = 0; i < clientList.size(); i++) {
        	
            if (clientList.get(i).getName().equals(name)) {
            	
                clientList.remove(i); //afairesh tou pelath i kai diagrafh twn stoixeiwn tou apo ton pinaka
                break;
                
            }
            
        }
        
    }
    
    public void clearTextFields() {
    	
    	//katharismos pediwn 
        nameField.setText("");
        surnameField.setText("");
        jobField.setText("");
        adressField.setText("");
        emailField.setText("");
        licensenumberField.setText("");
        afmField.setText("");
        phoneField.setText("");
        
    }
    
	@Override
	public Scene createScene() {

		return new Scene(rootGridPane, width, height);
	}
	
	
}
