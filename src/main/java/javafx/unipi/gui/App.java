package javafx.unipi.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    static Stage primaryStage;
    static Scene mainScene, planScene,clientScene, telecommunicationCompanyScene, contractScene;

    @Override
    public void start(Stage primaryStage) {
    	
    	this.primaryStage = primaryStage; //arxikopoihsh tou primaryStage
    	
    	//dhmiourgia newn antikeimenwn typou sceneCreator
        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        SceneCreator planSceneCreator = new PlanSceneCreator(650, 300);
        SceneCreator clientSceneCreator = new ClientSceneCreator(650, 300);
        SceneCreator contractSceneCreator = new ContractSceneCreator(650, 300);
        SceneCreator telecommunicationCompanySceneCreator= new TelecommunicationCompanySceneCreator(650, 300);

        
        mainScene = mainSceneCreator.createScene(); //dhmiourgia ths mainScene
        planScene = planSceneCreator.createScene(); //dhmiourgia ths planScene
        clientScene = clientSceneCreator.createScene(); //dhmiourgia ths clientScene
        telecommunicationCompanyScene = telecommunicationCompanySceneCreator.createScene();//dhmiourgia ths telecommunicationCompanyScene
        contractScene = contractSceneCreator.createScene();

        primaryStage.setTitle("Telecommunication System Window"); //titlos primaryStage
        primaryStage.setScene(mainScene); //skhnh ths primaryStage
        primaryStage.show(); 

    }

    public static void main(String[] args) {
        launch(args);
    }

}