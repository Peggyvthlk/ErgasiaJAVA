package javafx.unipi.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.unipi.core.Contract;
import javafx.unipi.core.LandlinePlan;
import javafx.unipi.core.MobilePlan;
import javafx.unipi.core.Plan;


public class PlanSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//	Combobox
	ComboBox<String> combobox;
	
	//	Array
	static ArrayList<Plan> planList;
	
	//	Flow Pane
	FlowPane buttonFlowPane, searchFlowPane;
	
	//	Grid Panes
	GridPane rootGridPane, inputFieldsPane;
	
	// Scene buttons
	Button newPlanBtn, updatePlanBtn, deletePlanBtn, backBtn, searchBtn;
	
	// Scene labels
	Label companyLbl, callMinutesLbl, programCostLbl, SMSlineSpeedLbl, GBlineTypeLbl, searchLb;
	
	//	Scene TextFields
	TextField companyField, callMinutesField, programCostField, SMSlineSpeedField, GBlineTypeField, searchField; 
	
	//	TableView
	TableView<Plan> planTableView;
/*	TableView<MobilePlan> mobileplanTableView;
	TableView<LandlinePlan> landlineplanTableView;
*/	
    
	Random rnd = new Random(); //	Random code
	int	uniCode;
	int i;
//	int counter=0; //counter for uniCode

	public PlanSceneCreator(double width, double height) {
		super(width, height);
		planList = new ArrayList<>();
        buttonFlowPane = new FlowPane();
        searchFlowPane = new FlowPane();
        rootGridPane = new GridPane();
        inputFieldsPane = new GridPane();
        newPlanBtn = new Button("New PLan");
        updatePlanBtn = new Button("Update");
        deletePlanBtn = new Button("Delete");
        backBtn = new Button("Back");
        searchBtn = new Button("Search");
        companyLbl = new Label("Company: ");
        callMinutesLbl = new Label("Call-Minutes: ");
        programCostLbl = new Label("Cost: ");
        SMSlineSpeedLbl = new Label("Size: ");
        GBlineTypeLbl = new Label("GB/\nLineType: ");
        SMSlineSpeedLbl = new Label("SMS/\nLineSpeed: ");
        searchLb = new Label("Company: ");
        searchField = new TextField();
        companyField = new TextField();
        callMinutesField = new TextField();
        programCostField = new TextField();
        SMSlineSpeedField = new TextField();
        GBlineTypeField = new TextField();
        planTableView = new TableView<>();
        combobox = new ComboBox<String>();
        
      //add combobox items
        combobox.getItems().addAll("Mobile","Landline");
        
    //  Attach events
        backBtn.setOnMouseClicked(this);
        searchBtn.setOnMouseClicked(this);
        newPlanBtn.setOnMouseClicked(this);
        updatePlanBtn.setOnMouseClicked(this);
        deletePlanBtn.setOnMouseClicked(this);
        planTableView.setOnMouseClicked(this);
        
        // Top Flowpane
        searchFlowPane.setAlignment(Pos.TOP_LEFT);
        searchFlowPane.setHgap(10);
        searchFlowPane.setVgap(10);
        searchFlowPane.getChildren().add(combobox);
        searchFlowPane.getChildren().add(searchLb);
        searchFlowPane.getChildren().add(searchField);
        searchFlowPane.getChildren().add(searchBtn);
        
        //  Customize buttonFlowPane
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newPlanBtn);
        buttonFlowPane.getChildren().add(updatePlanBtn);
        buttonFlowPane.getChildren().add(deletePlanBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        
        //custom GridPane
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(5);
        inputFieldsPane.setHgap(5);
        inputFieldsPane.add(companyLbl, 0, 0);
        inputFieldsPane.add(companyField, 1, 0);
        inputFieldsPane.add(callMinutesLbl, 0, 1);
        inputFieldsPane.add(callMinutesField, 1, 1);
        inputFieldsPane.add(programCostLbl, 0, 2);
        inputFieldsPane.add(programCostField, 1, 2);
        inputFieldsPane.add(SMSlineSpeedLbl, 0, 3);
        inputFieldsPane.add(SMSlineSpeedField, 1, 3);
        inputFieldsPane.add(GBlineTypeLbl, 0, 4);
        inputFieldsPane.add(GBlineTypeField, 1, 4);

        // Customize rootGridPane
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(searchFlowPane, 0, 0);
        rootGridPane.add(inputFieldsPane, 2, 1);
        rootGridPane.add(planTableView, 0, 1);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 2, 2);
        
        // customize TableView
        TableColumn<Plan, String> uniCodeColumn = new TableColumn<>("Code");
        uniCodeColumn.setCellValueFactory(new PropertyValueFactory<>("uniCode"));
        planTableView.getColumns().add(uniCodeColumn);

        TableColumn<Plan, String> companyColumn = new TableColumn<>("Company");
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        planTableView.getColumns().add(companyColumn);

        TableColumn<Plan, String> callMinutesColumn = new TableColumn<>("Call/Minutes");
        callMinutesColumn.setCellValueFactory(new PropertyValueFactory<>("callMinutes"));
        planTableView.getColumns().add(callMinutesColumn);

        TableColumn<Plan, String> programCostColumn = new TableColumn<>("Cost");
        programCostColumn.setCellValueFactory(new PropertyValueFactory<>("programCost"));
        planTableView.getColumns().add(programCostColumn);
        
        TableColumn<Plan, String> SMSColumn = new TableColumn<>("SMS");
        SMSColumn.setCellValueFactory(new PropertyValueFactory<>("SMS"));
        planTableView.getColumns().add(SMSColumn);
        
        TableColumn<Plan, String> GBColumn = new TableColumn<>("GB");
        GBColumn.setCellValueFactory(new PropertyValueFactory<>("GB"));
        planTableView.getColumns().add(GBColumn);
        
        TableColumn<Plan, String> lineSpeedColumn = new TableColumn<>("LineSpeed");
        lineSpeedColumn.setCellValueFactory(new PropertyValueFactory<>("lineSpeed"));
        planTableView.getColumns().add(lineSpeedColumn);
        
        TableColumn<Plan, String> lineTypeColumn = new TableColumn<>("LineType");
        lineTypeColumn.setCellValueFactory(new PropertyValueFactory<>("lineType"));
        planTableView.getColumns().add(lineTypeColumn);
				        	        		
       
	}
	
	@Override
    public Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }
	
	@Override
	public void handle(MouseEvent event) {
		
        if (event.getSource() == backBtn) {
        	App.primaryStage.setTitle("Telecommunication System Window");
            App.primaryStage.setScene(App.mainScene);
        }
        
        if (event.getSource() == newPlanBtn) {
        	
        	int x=0;
        	
        	while(x != 1) { // Checking uniCode is unique
    			uniCode = 1000 + rnd.nextInt(10000-100);	// uniCode
    			
				for(i=0; i < planList.size(); i++ ) {
					if(planList.get(i).getUniCode() != uniCode) {
						x=1;
						break;
					}
				}
				
				if (planList.size() == 0) x=1;
    			
    		}
        	
        	if(combobox.getValue() == "Mobile") {
        		
        		String company = companyField.getText();
            
        		try { //Error For int to string
            	
        			int	callMinutes = Integer.parseInt(callMinutesField.getText());
        			Double programCost = Double.parseDouble(programCostField.getText());
        			int SMS = Integer.parseInt(SMSlineSpeedField.getText());
        			int GB = Integer.parseInt(GBlineTypeField.getText());
        			createMobilePlan(uniCode , company , callMinutes , programCost , SMS , GB );
                 
        		} catch (NumberFormatException e) {
        			Alert alertType = new Alert(Alert.AlertType.ERROR);
        			alertType.setTitle("Invalid value");
        			alertType.setContentText("The values provided are not numbers. \n Exception message: "+ e.getMessage());
        			alertType.show();
        		}
        		
            	tableSync();
            	clearTextFields();
        	
        	}
        	
        	if(combobox.getValue() == "Landline") {
    		
        		String company = companyField.getText();
    		
    			try { //Error For int to string
            	
    				int	callMinutes = Integer.parseInt(callMinutesField.getText());
    				Double programCost = Double.parseDouble(programCostField.getText());
    				int lineSpeed = Integer.parseInt(SMSlineSpeedField.getText());
    				String lineType = GBlineTypeField.getText();
    				createLandlinePlanint(uniCode , company , callMinutes , programCost , lineSpeed , lineType );
                 
    			} catch (NumberFormatException e) {
    				Alert alertType = new Alert(Alert.AlertType.ERROR);
    				alertType.setTitle("Invalid value");
    				alertType.setContentText("The values provided are not numbers. \n Exception message: "+ e.getMessage());
    				alertType.show();
    			}
    		
            	tableSync();
            	clearTextFields();
            	
        	}
        	
        } 
        
        if (event.getSource() == updatePlanBtn) {
        	
        	if(combobox.getValue() == "Mobile"){
        		String company = companyField.getText();
        		
        		try { //Error For int to string
                	
        			int	callMinutes = Integer.parseInt(callMinutesField.getText());
        			Double programCost = Double.parseDouble(programCostField.getText());
        			int SMS = Integer.parseInt(SMSlineSpeedField.getText());
        			int GB = Integer.parseInt(GBlineTypeField.getText());
            		updateMobilePlan( company , callMinutes , programCost , SMS , GB );
                 
        		} catch (NumberFormatException e) {
        			Alert alertType = new Alert(Alert.AlertType.ERROR);
        			alertType.setTitle("Invalid value");
        			alertType.setContentText("The values provided are not numbers. \n Exception message: "+ e.getMessage());
        			alertType.show();
        		}
        		
        		tableSync();
        		clearTextFields();
        	}

        	if(combobox.getValue() == "Landline"){
	        	String company = companyField.getText();
	        	
	        	try { //Error For int to string
	            	
    				int	callMinutes = Integer.parseInt(callMinutesField.getText());
    				Double programCost = Double.parseDouble(programCostField.getText());
    				int lineSpeed = Integer.parseInt(SMSlineSpeedField.getText());
    				String lineType = GBlineTypeField.getText();
    	        	updateLandlinePlan( company , callMinutes , programCost , lineSpeed , lineType );
                 
    			} catch (NumberFormatException e) {
    				Alert alertType = new Alert(Alert.AlertType.ERROR);
    				alertType.setTitle("Invalid value");
    				alertType.setContentText("The values provided are not numbers. \n Exception message: "+ e.getMessage());
    				alertType.show();
    			}
	        	
	            tableSync();
	            clearTextFields();
        	}
;
        }
		
        if (event.getSource() == deletePlanBtn) {
        	int i;
        	List<Contract> list = ContractSceneCreator.getContractList();

        	for(i=0;i < list.size(); i++) {
        	if(list.size() == 0) { //elenxos gia an yparxei plan me thn eteairia pou diagrafetai
        	deletePlan(companyField.getText());
        	}
        	}
        	tableSync();
        	clearTextFields();
        	}
        
        if (event.getSource() == planTableView) {
            Plan selectedPlan = planTableView.getSelectionModel().getSelectedItem();
            if (selectedPlan != null) {
            	uniCode = selectedPlan.getUniCode();
                companyField.setText(selectedPlan.getCompany());
                callMinutesField.setText(Integer.toString(selectedPlan.getCallMinutes()));
                programCostField.setText(Double.toString(selectedPlan.getProgramCost()));
                if(combobox.getValue() == "Mobile") {
                	SMSlineSpeedField.setText(String.valueOf(((MobilePlan) selectedPlan).getSMS()));
                	GBlineTypeField.setText(String.valueOf(((MobilePlan) selectedPlan).getGB()));
                }
                if(combobox.getValue() == "Landline") {
                	SMSlineSpeedField.setText(String.valueOf(((LandlinePlan) selectedPlan).getLineSpeed()));
                	GBlineTypeField.setText(((LandlinePlan) selectedPlan).getLineType());
                }
            
            }
        }
        
        if(event.getSource() == searchBtn){

        	
        		//LiveSearch
        		FilteredList<Plan> filteredData = new FilteredList<>(FXCollections.observableList(planList));
        		planTableView.setItems(filteredData);
        		
        		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        			filteredData.setPredicate(n -> {
        				// If filter text is empty, display all plans.
        				if (newValue == null || newValue.isEmpty()) {
        					return true;
        				}
        				
        				// Compare Company name  with filter text.
        				String lowerCaseFilter = newValue.toLowerCase();
        				
        				//Search for MobilePlan
        				if(combobox.getValue() == "Mobile" && n instanceof MobilePlan) {
        					if (n.getCompany().toLowerCase().contains(lowerCaseFilter)) {
        						return true; // Filter matches Company name.
        					}     				
        				}
        				
        				//Search for LandlinePlan
        				if(combobox.getValue() == "Landline" && n instanceof LandlinePlan) {
        					if (n.getCompany().toLowerCase().contains(lowerCaseFilter)) {
            					return true; // Filter matches Company name.
            				}
        				}
        				
        				return false; // Does not match.

        			});
        		});
        		
        		//filteredData.comparatorProperty().bind(planTableView.comparatorProperty());
        		
        		planTableView.setItems(filteredData);
        	
        }
    
        
	}
	
	public void createMobilePlan (int uniCode , String company , int callMinutes , double programCost , int SMS ,int GB ) {
    	Plan v = new MobilePlan( uniCode ,  company , callMinutes , programCost , SMS , GB );
    	planList.add(v);
    }
	public void createLandlinePlanint (int uniCode , String company , int callMinutes , double programCost , int lineSpeed , String lineType) {
    	Plan v = new LandlinePlan(uniCode , company , callMinutes , programCost , lineSpeed , lineType);
    	planList.add(v);
    }

    public void tableSync() {
        List<Plan> items = planTableView.getItems();
        items.clear();
        for (Plan v : planList) {
            if (v instanceof Plan) {
                items.add((Plan) v);
            }
        }
    }

    public void updateMobilePlan(String company , int callMinutes , double programCost , int SMS ,int GB) {
        for (Plan v : planList) {
        	if(v.getUniCode()== uniCode) {
        	//	v.setCompany(company);
        		v.setCallMinutes(callMinutes);
        		v.setProgramCost(programCost);
        		((MobilePlan) v).setSMS(SMS);
        		((MobilePlan) v).setGB(GB);
        	}
        }
    }
    
    public void updateLandlinePlan(String company , int callMinutes , double programCost , int lineSpeed , String lineType) {
        for (Plan v : planList) {
        	if(v.getUniCode()== uniCode) {
        		v.setCompany(company);
        		v.setCallMinutes(callMinutes);
        		v.setProgramCost(programCost);
        		((LandlinePlan) v).setLineSpeed(lineSpeed);
        		((LandlinePlan) v).setLineType(lineType);
        	}
        }
    }

    public void deletePlan(String company) {
        for (int i = 0; i <planList.size(); i++) {
            if (planList.get(i).getCompany().equals(company)) {
               planList.remove(i);
                break;
            }
        }
    }

    public void clearTextFields() {
    	companyField.setText("");
    	callMinutesField.setText("");
    	programCostField.setText("");
    	SMSlineSpeedField.setText("");
    	GBlineTypeField.setText("");
        
    }

	public static ArrayList<Plan> getPlanList() {
		return planList;
	}
    
    

}
