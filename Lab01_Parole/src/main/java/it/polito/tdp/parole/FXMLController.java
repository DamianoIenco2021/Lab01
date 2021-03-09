package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtPrestazioni;
    
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	this.txtPrestazioni.setText("");
    	double start= System.nanoTime();

    	String lista="";
        String p=txtParola.getText();
         elenco.addParola(p);
    	
    	for(String s : elenco.getElenco()) {
    		lista+=s+"\n";
    	}
    	
    	this.txtParola.setText("");
    	this.txtResult.setText(lista);
       
    	double stop= System.nanoTime();
    	
    	this.txtPrestazioni.setText("Tempo di esecuzione parola"+ "( parola "+ p + "):" + "\n"+ (stop-start) + "  nanosecondi!");
  	}
    	
     @FXML
    void doReset(ActionEvent event) {
    	 this.txtPrestazioni.setText("");
     	double start= System.nanoTime();
    	 
       elenco.reset();
       txtResult.setText("");
       
       double stop= System.nanoTime();
   	
   	this.txtPrestazioni.setText("Tempo di esecuzione reset" + "\n"+ (stop-start) + "  nanosecondi!");
    	
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	
    	 this.txtPrestazioni.setText("");
      	double start= System.nanoTime();
     	 

    	String list="";
    	this.txtParola.setText("");
    	
    	String daCancellare= this.txtResult.getSelectedText();
    	elenco.cancella(daCancellare);
    	this.txtResult.clear();
    	
    	   double stop= System.nanoTime();
    	   	
    	   	this.txtPrestazioni.setText("Tempo di esecuzione Cancella" + "\n"+ (stop-start) + "  nanosecondi!");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
