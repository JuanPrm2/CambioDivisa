package dad.cambioDivisa;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CambioDivisa extends Application{

	private TextField primerTextField,segundoTextField;
	
	private DoubleProperty operando1 = new SimpleDoubleProperty(0);
	private DoubleProperty resultado = new SimpleDoubleProperty(0);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primerTextField=new TextField();
		primerTextField.setMaxWidth(50);
		segundoTextField=new TextField();
		segundoTextField.setMaxWidth(50);
		segundoTextField.setEditable(false);
		Button cambiar= new Button("Cambiar");
		cambiar.setOnAction(e -> cambio(e)); 
		
		ObservableList<String> divisas= FXCollections.observableArrayList();
		
		divisas.addAll("Euro","Libra","Yen","Dolar");
		
		ComboBox<String> combo = new ComboBox<>(divisas);
	
		
		
		ComboBox<String> combo2 = new ComboBox<>(divisas);
		
		
		HBox fila1= new HBox(primerTextField,combo);
		fila1.setAlignment(Pos.CENTER);
		
		HBox fila2= new HBox (segundoTextField,combo2);
		fila2.setAlignment(Pos.CENTER);
		
		VBox root= new VBox (fila1,fila2,cambiar);
		root.setAlignment(Pos.CENTER);
		
	    Scene scene = new Scene(root,640,480);

        primaryStage.setTitle("CambioDivisa");
        primaryStage.setScene(scene);
        primaryStage.show();
   
        
        primerTextField.textProperty().bindBidirectional(operando1, new NumberStringConverter());
        
	}

	private Object cambio(ActionEvent e) {
		
		
		return null;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
