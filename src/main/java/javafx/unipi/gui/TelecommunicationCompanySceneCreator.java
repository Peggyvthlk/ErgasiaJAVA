package javafx.unipi.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.unipi.core.LandlinePlan;
import javafx.unipi.core.MobilePlan;
import javafx.unipi.core.Plan;
import javafx.unipi.core.TelecommunicationCompany;

import java.util.Random;


public class TelecommunicationCompanySceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

	Random random = new Random();
	
	ArrayList<TelecommunicationCompany> companyList ;  			//lista se pinaka etairion pou parexoun
															   //proggrammata kinitis kai statheris tilefonias
	FlowPane buttonFlowPane,  searchFlowPane ;
	GridPane rootGridPane , inputFieldsPane ;
	Button newCompanyBtn , updateCompanyBtn , deleteCompanyBtn , backBtn, searchBtn ;
	Label companyNameLbl , phoneLbl , emailLbl, searchLb ;
	TextField companyNameField , phoneField , emailField, searchField ;
	TableView<TelecommunicationCompany> companyTableView ;

	int companyCode;
	String companyname;
	int companyphone;
	String email;
	
	
	public TelecommunicationCompanySceneCreator(double width, double height) {
		super(width, height);
		
		companyList = new ArrayList<>();
	    rootGridPane = new GridPane();
	    buttonFlowPane = new FlowPane();
        searchFlowPane = new FlowPane();
	    companyNameLbl = new Label("Company's Name: ");
	    phoneLbl = new Label("Phone: ");
	    emailLbl = new Label("E-mail: ");
	    companyNameField = new TextField();
	    phoneField = new TextField();
	    emailField = new TextField();
	    newCompanyBtn = new Button("New Company");
	    updateCompanyBtn = new Button("Update");
	    deleteCompanyBtn = new Button("Delete");
	    backBtn = new Button("Go Back");
        searchBtn = new Button("Search");
	    searchLb = new Label("Company Name: ");
        searchField = new TextField();
	    inputFieldsPane = new GridPane();
	    companyTableView = new TableView<>();
	    
	    
	    //attach event
	    backBtn.setOnMouseClicked(this);
	    newCompanyBtn.setOnMouseClicked(this);
	    updateCompanyBtn.setOnMouseClicked(this);
	    deleteCompanyBtn.setOnMouseClicked(this);
	    companyTableView.setOnMouseClicked(this);
        searchBtn.setOnMouseClicked(this);
	    
        // Top Flowpane
        searchFlowPane.setAlignment(Pos.TOP_LEFT);
        searchFlowPane.setHgap(10);
        searchFlowPane.setVgap(10);
        searchFlowPane.getChildren().add(searchLb);
        searchFlowPane.getChildren().add(searchField);
        searchFlowPane.getChildren().add(searchBtn);
        
	    //customize flowpane
	    buttonFlowPane.setHgap(10);
	    buttonFlowPane.getChildren().add(newCompanyBtn);
	    buttonFlowPane.getChildren().add(updateCompanyBtn);
	    buttonFlowPane.getChildren().add(deleteCompanyBtn);
	    buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
	    
	    
	    // customize inputfieldspane
	    inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
	    inputFieldsPane.setVgap(10);
	    inputFieldsPane.setHgap(10);
	    inputFieldsPane.add(companyNameLbl, 0, 0);
	    inputFieldsPane.add(companyNameField, 1, 0);
	    inputFieldsPane.add(phoneLbl, 0, 1);
	    inputFieldsPane.add(phoneField, 1, 1);
	    inputFieldsPane.add(emailLbl, 0, 2);
	    inputFieldsPane.add(emailField, 1, 2);

	    
	    // customize rootGridPane
	    rootGridPane.setVgap(10);
	    rootGridPane.setHgap(10);
        rootGridPane.add(searchFlowPane, 0, 0);
	    rootGridPane.add(inputFieldsPane, 2, 1);
	    rootGridPane.add(companyTableView, 0, 1);
	    rootGridPane.add(buttonFlowPane, 0, 2);
	    rootGridPane.add(backBtn, 2, 2);
	    
	    
	    // customize TableView
	    TableColumn<TelecommunicationCompany , String> randColumn = new TableColumn<>("Unique Code");
	    randColumn.setCellValueFactory(new PropertyValueFactory<>("companycode"));
	    companyTableView.getColumns().add(randColumn);
	    
	    
	    TableColumn<TelecommunicationCompany , String> nameColumn = new TableColumn<>("Company Name");
	    nameColumn.setCellValueFactory(new PropertyValueFactory<>("companyname"));
	    companyTableView.getColumns().add(nameColumn);
	     
	     
	    TableColumn<TelecommunicationCompany, String> phoneColumn = new TableColumn<>("Phone");
	    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
	    companyTableView.getColumns().add(phoneColumn);


	    TableColumn<TelecommunicationCompany , String> emailColumn = new TableColumn<>("E-mail");
	    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
	    companyTableView.getColumns().add(emailColumn);

		
	}

	@Override
	public Scene createScene() {
		
		return new Scene(rootGridPane , width , height ) ;
		
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		if (event.getSource() == backBtn) {
			App.primaryStage.setTitle("Telecommunication System Window");
            App.primaryStage.setScene(App.mainScene);
        }
		
		
		if (event.getSource() == newCompanyBtn) {
			
			int x = 0 ;
			int i = 0;
			
			while ( x!= 1 ) {
				
				companyCode = 1000 + random.nextInt(10000-100) ;
				for (i=0 ; i<companyList.size(); i++) {
					
					if (companyList.get(i).getCompanycode() != companyCode ) {
						
						x=1 ;
						break;
						
					}
					
				}
				
				if (companyList.size() == 0 ) {
					
					x=1;
					
				}
				
			}
			
            String companyName = companyNameField.getText();
            String email = emailField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            String phoneString = String.valueOf(phone);
            if (phoneString.length()==10) {    				//prepei na kano kati allo??
            
				createCompany(  companyCode , companyName , phone , email ) ;
            }	
            tableSync();
            clearTextFields();
	    }     
		
	
  
	
	
		if (event.getSource() == updateCompanyBtn) {
			String companyName = companyNameField.getText();
			String phone = phoneField.getText();
			String email = emailField.getText();
			updateCompany(companyName, Integer.parseInt(phone), email);
			tableSync();
			clearTextFields();
		}
		
		if (event.getSource() == deleteCompanyBtn) {
			int i;
			List<Plan> list = PlanSceneCreator.getPlanList();

			for(i=0;i < list.size(); i++) {
			if(!(companyNameField.getText().equals(list.get(i).getCompany()))) { //elenxos gia an yparxei plan me thn eteairia pou diagrafetai
			deleteCompany(companyNameField.getText());
			}
			}
			tableSync();
			clearTextFields();
			}
	   
	   if (event.getSource() == companyTableView) {
           TelecommunicationCompany selectedCompany = companyTableView.getSelectionModel().getSelectedItem();
           if (selectedCompany != null) {
               companyNameField.setText(selectedCompany.getCompanyname());
               phoneField.setText(Integer.toString(selectedCompany.getPhone()));
               emailField.setText(selectedCompany.getEmail());
           }
       }
	   
	   if(event.getSource() == searchBtn){

       	
   		//LiveSearch
   		FilteredList<TelecommunicationCompany> filteredData = new FilteredList<>(FXCollections.observableList(companyList));
   		companyTableView.setItems(filteredData);
   		
   		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
   			filteredData.setPredicate(n -> {
   				// If filter text is empty, display all plans.
   				if (newValue == null || newValue.isEmpty()) {
   					return true;
   				}
   				
   				// Compare Company name  with filter text.
   				String lowerCaseFilter = newValue.toLowerCase();
   				
   				//Search
				if (n.getCompanyname().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches Company name.
				}     				
   				
   				return false; // Does not match.

   			});
   		});
   		
   		//filteredData.comparatorProperty().bind(planTableView.comparatorProperty());
   		
   		companyTableView.setItems(filteredData);
   	
   }
	 
	}   
	//create Company
	public void createCompany(int companyCode , String companyName, int phone, String email) {
        TelecommunicationCompany c = new TelecommunicationCompany(companyCode , phone, email, companyName);
        companyList.add(c);
    }
	
	public void tableSync() {
        List<TelecommunicationCompany> items = companyTableView.getItems();
        items.clear();
        for (TelecommunicationCompany c : companyList) {
            if (c instanceof TelecommunicationCompany) {
                items.add((TelecommunicationCompany) c);
            }
        }
    }
	
	public void updateCompany(String companyname, int companyphone , String email ) {
        
		for (TelecommunicationCompany c : companyList) {
           
        	if ((c.getCompanyname()).equals(companyname)) {
                c.setPhone(companyphone);
                c.setEmail(email);
 
            }
        }
    }
	
	public void deleteCompany(String companyName) {
        for (int i = 0; i < companyList.size(); i++) {
            if (companyList.get(i).getCompanyname().equals(companyname)) {
                companyList.remove(i);
                break;
            }
        }
    }
	

	
	public void clearTextFields() {
        companyNameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

}

 