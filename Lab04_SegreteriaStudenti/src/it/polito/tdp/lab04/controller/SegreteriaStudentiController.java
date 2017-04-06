package it.polito.tdp.lab04.controller;

//import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model= new Model();
	List<Corso> corsi = new LinkedList<Corso>();

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model) {

	}

	@FXML
	void doReset(ActionEvent event) {
		txtResult.setText(null);
		txtCognome.setText(null);
		txtNome.setText(null);
		txtMatricola.setText(null);
		comboCorso.setValue(null);
		

	}

	@FXML
	void doCercaNome(ActionEvent event) {
		if(model.controllaSoloInt(txtMatricola.getText())==true){
		int i= Integer.parseInt(txtMatricola.getText());
		Studente s=model.cercaStudente(i);
		if(s!=null){
		String nome= s.getNome();
		String cognome=s.getCognome();
		
		txtNome.setText(nome);
		txtCognome.setText(cognome);}
		else{
			txtNome.clear();
			txtCognome.clear();
			txtResult.clear();
			txtResult.setText("la matricola inserita non e' corretta");
		}
		}
		else{
			txtResult.clear();
			txtResult.setText("inserire solo caratteri numerici");
		}
		
	}

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
		if(comboCorso.getValue()==null){  //controlla che il valore nella combobox non sia nullo
			txtResult.setText("nessun corso selezionato");
		return;
    	}
		else{
			if(txtMatricola.getText().equals("")&& txtNome.getText().equals("")){
			Corso corsoSelezionato=comboCorso.getValue();
			String s=model.getStudenti(corsoSelezionato);
			txtResult.clear();
			txtResult.setText(s);
			}
			else{
				Corso corsoSelezionato=comboCorso.getValue();
				int i= Integer.parseInt(txtMatricola.getText());
				String s= model.verificaStudenteCorso(corsoSelezionato, i);
				txtResult.clear();
				txtResult.setText(s);
			}
		}
		

	}

	@FXML
	void doCercaCorsi(ActionEvent event) {//si puo migliorare la parte del model
		
		if((txtMatricola.getText()!=null)&&(txtNome.getText()!=null)&&(txtCognome.getText()!=null)){
			int matricola= Integer.parseInt(txtMatricola.getText());
		String nome= txtNome.getText();
		String cognome=txtCognome.getText();
		Studente stu= new Studente(matricola, nome, cognome);
		 String s=model.cercaCorsiStudenti(stu);
		 txtResult.clear();
		txtResult.setText(s);}
		else{
			txtResult.clear();
			txtResult.setText("inserire la matricola, premere ook, e riprovare");
		}
		
		 

	}

	@FXML
	void doIscrivi(ActionEvent event) {
		String matricola= txtMatricola.getText();
		Corso corso= comboCorso.getValue();
		if(txtNome!=null){
		String s= model.iscriviStudenteAlCorso(matricola, corso);
		
		txtResult.clear();
		txtResult.setText(s);}
		else{
			txtResult.clear();
			txtResult.setText("inserire matricola, premere ook e riprovare");
		}
		

	}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	
	    comboCorso.getItems().addAll(model.listaCorsi());
	    
	
	}

}
