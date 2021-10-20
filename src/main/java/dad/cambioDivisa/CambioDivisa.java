package dad.cambioDivisa;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
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
	
	private Double cantidad ;
	
	private ComboBox<Divisa> comboBoxDivisa1;
	private ComboBox<Divisa> comboBoxDivisa2;
	
	private DoubleProperty resultadoFinal= new SimpleDoubleProperty();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primerTextField=new TextField();
		primerTextField.setMaxWidth(50);
		segundoTextField=new TextField();
		segundoTextField.setMaxWidth(50);
		segundoTextField.setEditable(false);
		Button cambiar= new Button("Cambiar");
		
		comboBoxDivisa1= new ComboBox<>();
		comboBoxDivisa1.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Libra", 0.8873),
				new Divisa("Dolar", 1.2007),
				new Divisa("Yen", 133.59)
				);
		
		comboBoxDivisa2= new ComboBox<>();
		comboBoxDivisa2.getItems().addAll(
				new Divisa("Euro", 1.0),
				new Divisa("Libra", 0.8873),
				new Divisa("Dolar", 1.2007),
				new Divisa("Yen", 133.59)
				);
		
		HBox fila1= new HBox(primerTextField,comboBoxDivisa1);
		fila1.setAlignment(Pos.CENTER);
		fila1.setSpacing(5);
		HBox fila2= new HBox (segundoTextField,comboBoxDivisa2);
		fila2.setAlignment(Pos.CENTER);
		fila2.setSpacing(5);
		
		VBox root= new VBox (fila1,fila2,cambiar);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		
	    Scene scene = new Scene(root,640,480);

        primaryStage.setTitle("CambioDivisa");
        primaryStage.setScene(scene);
        primaryStage.show();
   
      
        
     
       
       
         
      comboBoxDivisa1.getSelectionModel().getSelectedItem();
      comboBoxDivisa2.getSelectionModel().getSelectedItem();
      
      cambiar.setOnAction(e -> cambio(comboBoxDivisa1.getSelectionModel().getSelectedItem(), comboBoxDivisa2.getSelectionModel().getSelectedItem(),Double.parseDouble( primerTextField.getText()))); 
	}

	public void cambio(Divisa primeraDivisa,Divisa segundaDivisa,double cantidad) {
		
		
		
	    
		
		
			 
			 String resultadoD= Divisa.fromTo(primeraDivisa,segundaDivisa,cantidad).toString();
			     segundoTextField.setText(resultadoD);
		
			
	    
		   
			
		}
	    
	     
	     
	

	public static void main(String[] args) {
		launch(args);
	}
	
}
