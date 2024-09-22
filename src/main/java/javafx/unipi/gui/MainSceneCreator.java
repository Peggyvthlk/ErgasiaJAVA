package javafx.unipi.gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

   //root
    FlowPane rootFlowPane;
    //Button
    Button clientBtn,telecommunicationCompanyBtn, planBtn,  contractBtn;

    public MainSceneCreator(double width, double height) {
        super(width, height);

        rootFlowPane = new FlowPane();

        clientBtn = new Button("Client");
        telecommunicationCompanyBtn = new Button("Telecommunication Company");
        planBtn = new Button("Plan");
        contractBtn = new Button("Contract");
        
        // attach handle event to Btn
    	planBtn.setOnMouseClicked(this);
    	clientBtn.setOnMouseClicked(this);
    	telecommunicationCompanyBtn.setOnMouseClicked(this);
    	contractBtn.setOnMouseClicked(this);

        rootFlowPane.getChildren().add( clientBtn);
        rootFlowPane.getChildren().add(telecommunicationCompanyBtn);
        rootFlowPane.getChildren().add(planBtn);
        rootFlowPane.getChildren().add(contractBtn);

        rootFlowPane.setHgap(10);
        rootFlowPane.setAlignment(Pos.CENTER);

    }
    
    public void handle(MouseEvent event) {
		if(event.getSource() == planBtn) {
			App.primaryStage.setScene(App.planScene);
			App.primaryStage.setTitle("Plan Window");
		}
		if (event.getSource() == clientBtn) {
    		
    		App.primaryStage.setScene(App.clientScene);
    		App.primaryStage.setTitle("Client Window");
    		
    	}
		if (event.getSource() == telecommunicationCompanyBtn ) {
    		App.primaryStage.setScene(App.telecommunicationCompanyScene);      //mainStage ? i primaryStage 
    		App.primaryStage.setTitle("Telecommunication Company Window!");   //magda
    	}
		if(event.getSource() == contractBtn) {
			App.primaryStage.setScene(App.contractScene);
			App.primaryStage.setTitle("Contract Window");
		}
	}
    
    @Override
    public Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }

}
