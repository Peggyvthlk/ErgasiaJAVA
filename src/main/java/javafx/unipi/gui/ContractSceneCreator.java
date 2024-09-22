package javafx.unipi.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.unipi.core.Client;
import javafx.unipi.core.Contract;
import javafx.unipi.core.Plan;
import javafx.unipi.core.MobilePlan;
import javafx.unipi.core.LandlinePlan;

public class ContractSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    static ArrayList <Contract> contractList;
    FlowPane buttonFlowPane, searchFlowPane;
    GridPane rootGridPane, inputFieldsPane;
    Button newContractBtn, deleteContractBtn, backBtn, searchBtn;
    Label phoneNumberLbl, afmLbl, programTypeLbl, startDateLbl, contractDurationLbl, accountTypeLbl, paymentMethodLbl, activeContractLbl, searchLbl;
    TextField phoneNumberField, afmField, programTypeField, startDateField, contractDurationField, accountTypeField, paymentMethodField, activeContractField, searchField;
    TableView<Contract> contractTableView;
    ComboBox<String> combobox;
    String code ;
    float discount , finalCost , cancellationCost ;
    public ContractSceneCreator(double width, double height) {
        super(width, height);
        //Initialize Fields        
        combobox = new ComboBox<String>();
        contractList = new ArrayList<>();
        rootGridPane = new GridPane();
        buttonFlowPane = new FlowPane();
        searchFlowPane = new FlowPane();
        phoneNumberLbl = new Label("Phone Number: ");
        afmLbl = new Label("Tax Number: ");
        programTypeLbl = new Label("Program Type: ");
        startDateLbl = new Label("Start Date: ");
        contractDurationLbl = new Label("Contract Duration: ");
        accountTypeLbl = new Label("Account Type: ");
        paymentMethodLbl = new Label("Payment Method: ");
        activeContractLbl = new Label("Active Contract: ");
        phoneNumberField = new TextField();
        afmField = new TextField();
        programTypeField = new TextField();
        startDateField = new TextField();
        contractDurationField = new TextField();
        accountTypeField = new TextField();
        paymentMethodField = new TextField();
        activeContractField = new TextField();
        newContractBtn = new Button("New");
        deleteContractBtn = new Button("Delete");
        inputFieldsPane = new GridPane();
        contractTableView = new TableView();
        backBtn = new Button("Go Back");
        searchBtn = new Button("Search");
        searchLbl = new Label("Mobile:");
        searchField = new TextField();
        //add combobox items        
        combobox.getItems().addAll("Mobile","Landline");
        // Top Flowpane        
        searchFlowPane.setAlignment(Pos.TOP_LEFT);
        searchFlowPane.setHgap(10);
        searchFlowPane.setVgap(10);
        searchFlowPane.getChildren().add(combobox);
        searchFlowPane.getChildren().add(searchLbl);
        searchFlowPane.getChildren().add(searchField);
        searchFlowPane.getChildren().add(searchBtn);;
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newContractBtn);
        buttonFlowPane.getChildren().add(deleteContractBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(phoneNumberLbl, 0, 0);
        inputFieldsPane.add(phoneNumberField, 1, 0);
        inputFieldsPane.add(afmLbl, 0, 1);
        inputFieldsPane.add(afmField, 1, 1);
        inputFieldsPane.add(programTypeLbl, 0, 2);
        inputFieldsPane.add(programTypeField, 1, 2);
        inputFieldsPane.add(startDateLbl, 0, 3);
        inputFieldsPane.add(startDateField, 1, 3);
        inputFieldsPane.add(contractDurationLbl, 0, 4);
        inputFieldsPane.add(contractDurationField, 1, 4);
        inputFieldsPane.add(accountTypeLbl, 0, 5);
        inputFieldsPane.add(accountTypeField, 1, 5);
        inputFieldsPane.add(paymentMethodLbl, 0, 6);
        inputFieldsPane.add(paymentMethodField, 1, 6);
        inputFieldsPane.add(activeContractLbl, 0, 7);
        inputFieldsPane.add(activeContractField, 1, 7);
        //custom rootGridPane        
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(searchFlowPane, 0, 0);
        rootGridPane.add(inputFieldsPane, 2, 1);
        rootGridPane.add(contractTableView, 0, 1);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 2, 2);
        //customize TableView        
        TableColumn<Contract, String>codeColumn = new TableColumn<>("Code");
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        contractTableView.getColumns().add(codeColumn);
        TableColumn<Contract, String>phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        contractTableView.getColumns().add(phoneNumberColumn);
        TableColumn<Contract, String> afmColumn = new TableColumn<>("AFM Number");
        afmColumn.setCellValueFactory(new PropertyValueFactory<>("afm"));
        contractTableView.getColumns().add(afmColumn);
        TableColumn<Contract, String> programTypeColumn = new TableColumn<>("Program Type");
        programTypeColumn.setCellValueFactory(new PropertyValueFactory<>("programType"));
        contractTableView.getColumns().add(programTypeColumn);
        TableColumn<Contract, String> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        contractTableView.getColumns().add(startDateColumn);
        TableColumn<Contract, String> contractDurationColumn = new TableColumn<>("Contract Duration");
        contractDurationColumn.setCellValueFactory(new PropertyValueFactory<>("contractDuration"));
        contractTableView.getColumns().add(contractDurationColumn);
        TableColumn<Contract, String> accountTypeColumn = new TableColumn<>("Account Type");
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<>("accountType"));
        contractTableView.getColumns().add(accountTypeColumn);
        TableColumn<Contract, String> paymentMethodColumn = new TableColumn<>("Payment Method");
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        contractTableView.getColumns().add(paymentMethodColumn);
        TableColumn<Contract, String> activeContractColumn = new TableColumn<>("Active Contract");
        activeContractColumn.setCellValueFactory(new PropertyValueFactory<>("activeContract"));
        contractTableView.getColumns().add(activeContractColumn);
        //attach event        
        backBtn.setOnMouseClicked(this);
        newContractBtn.setOnMouseClicked(this);
        deleteContractBtn.setOnMouseClicked(this);
        contractTableView.setOnMouseClicked(this);
        searchBtn.setOnMouseClicked(this);
        searchBtn.setOnMouseClicked(this);
    }

	@Override
	public void handle(MouseEvent event) {

		if (event.getSource() == backBtn) {
			
			App.primaryStage.setTitle("Telecommunication System Window");
			App.primaryStage.setScene(App.mainScene);
		}
		
		if (event.getSource() == newContractBtn) {
			
			String programType = programTypeField.getText();
		    String accountType = accountTypeField.getText();
		    String paymentMethod = paymentMethodField.getText();
		    try {
		    	boolean activeContract = Boolean.parseBoolean(activeContractField.getText());
		    	long phoneNumber = Long.parseLong(phoneNumberField.getText());
		    	long afm = Long.parseLong(afmField.getText());
		    	int contractDuration = Integer.parseInt(contractDurationField.getText());
		    	long startDate = Long.parseLong(startDateField.getText());
		    	String date = String.valueOf(startDate);
		    	String afmString = String.valueOf(afm);
		    	String phoneString = String.valueOf(phoneNumber);
		    	
              for (Contract c : contractList) {
            	  
            	  
            	  
              }
            	  
    			int i = 0;
    				
    			if (contractList.size() == 0 ) {
					
					if (phoneString.length() == 10 && afmString.length() == 9) {
	            		
						if ((programTypeField.getText().equals("Mobile") && phoneString.charAt(0)=='6') || (programTypeField.getText().equals("Landline") && phoneString.charAt(0)=='2')) {

					    	code = date + "-" + afmString + "-" + programType;
							createContract (code, phoneNumber, afm, programType, startDate, contractDuration, discount, finalCost, accountType, paymentMethod, cancellationCost, activeContract);
						}
	            	}
				}
    			
    				for (Contract c : contractList) {
    					System.out.println("1");
    					if (c.getAfm() != afm) {
    						System.out.println("2");
    						if (phoneString.length() == 10 && afmString.length() == 9) {
    							System.out.println("3");
    							if (c.isActiveContract()==true && c.getPhoneNumber()!=phoneNumber) {
    								System.out.println("4");
    								if ((c.getProgramType().equals("Mobile") && phoneString.charAt(0)=='6') || (c.getProgramType().equals("Landline") && phoneString.charAt(0)=='2')) {
    									
    									System.out.println("5");
    							    	code = date + "-" + afmString + "-" + programType;
    									createContract (code, phoneNumber, afm, programType, startDate, contractDuration, discount, finalCost, accountType, paymentMethod, cancellationCost, activeContract);
    									
    								}
    							}
    		            	}
    						
    					}
    					
    				}
    				
		    } catch (NumberFormatException e) {
		    	
		    	Alert alertType = new Alert(Alert.AlertType.ERROR);
				alertType.setTitle("Invalid value");
				alertType.setContentText("The values provided are not numbers. \n Exception message: "+ e.getMessage());
				alertType.show();
		    	
		    }
		   
		    tableSync();
            clearTextFields();
			
		}

		if (event.getSource() == deleteContractBtn) {

			boolean activeContract = Boolean.parseBoolean(activeContractField.getText());
			
			if (activeContract == true) {
				
                for (Contract c : contractList) {
                	
                	if (c.getAfm() == Integer.parseInt(afmField.getText())) {
                		
                		c.setActiveContract(false);
                		
                	}
                }
				
			}			
			
			tableSync();
            clearTextFields();
            
		}
		
		if (event.getSource() == contractTableView) { 
            Contract selectedClient = contractTableView.getSelectionModel().getSelectedItem();
            if (selectedClient != null) {
                phoneNumberField.setText(String.valueOf(selectedClient.getPhoneNumber()));
                afmField.setText(String.valueOf(selectedClient.getAfm()));
                programTypeField.setText(String.valueOf(selectedClient.getProgramType()));
                startDateField.setText(String.valueOf(selectedClient.getStartDate()));
                contractDurationField.setText(String.valueOf(selectedClient.getContractDuration()));
                accountTypeField.setText(String.valueOf(selectedClient.getAccountType()));
                paymentMethodField.setText(String.valueOf(selectedClient.getAccountType()));
                activeContractField.setText( String.valueOf(selectedClient.isActiveContract()));
            }
		}
		
		if(event.getSource() == searchBtn){
			 
			List<Plan> list = PlanSceneCreator.getPlanList();
            //LiveSearch             
			FilteredList<Contract> filteredData = new FilteredList<>(FXCollections.observableList(contractList));
            contractTableView.setItems(filteredData);
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(c -> {
                    // If filter text is empty, display all plans.                         
                	if (newValue == null || newValue.isEmpty()) {
                             return true;
                         }
                         // Compare Company name  with filter text.                          
                	String lowerCaseFilter = newValue.toLowerCase();
                         //Search for MobilePlan                          
                	if(combobox.getValue() == "Mobile" && c.getProgramType().equals("Mobile")) {
                             if (c.getCode().toLowerCase().contains(lowerCaseFilter)) {
                                 return true; // Filter matches Company name.                              
                                 }                     
                         }
                         //Search for LandlinePlan                          
                             if(combobox.getValue() == "Landline" && c.getProgramType().equals("Landline")) {
                             if (c.getCode().toLowerCase().contains(lowerCaseFilter)) {
                                 return true; // Filter matches Company name.                              
                                 }
                         }
                   return false;
                             
                });
            });
            
            contractTableView.setItems(filteredData);
	 	
		 }
	}
	
	public void deleteContract(boolean activeContract) {
        for (int i = 0; i <contractList.size(); i++) {
            if (contractList.get(i).isActiveContract() == (activeContract)) {
               contractList.remove(i);
                break;
            }
        }
    }

	private void clearTextFields() {
		
		phoneNumberField.setText("");
    	afmField.setText("");
    	programTypeField.setText("");
    	startDateField.setText("");
    	contractDurationField.setText("");
    	accountTypeField.setText("");
    	paymentMethodField.setText("");
    	activeContractField.setText("");
		
	}

	private void tableSync() {
		
		List<Contract> items = contractTableView.getItems();
		items.clear();
		for (Contract c : contractList) {
			if (c instanceof Contract) {
				items.add((Contract) c); 
			}
		}
	
	}

public void createContract (String code, long phoneNumber, long afm, String programType, long startDate, int contractDuration, float discount, float finalCost, String accountType, String paymentMethod, float cancellationCost, boolean activeContract) {

	Contract c = new Contract(code, phoneNumber, afm, programType, startDate, contractDuration,
			discount, finalCost, accountType, paymentMethod, cancellationCost,
			activeContract);
    contractList.add(c);
	
    }

    @Override
    public Scene createScene() {

	   return new Scene(rootGridPane, width, height);
	   
    }
    
    public static ArrayList<Contract> getContractList() {
        return contractList;
    }

  }

