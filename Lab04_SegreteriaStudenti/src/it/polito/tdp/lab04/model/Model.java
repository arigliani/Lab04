package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	public Studente cercaStudente(int i){
		StudenteDAO dao= new StudenteDAO();
		Studente s= dao.find(i);
		return s;
		
	}
	
	public List<Corso> listaCorsi (){
		CorsoDAO dao= new CorsoDAO();
		List<Corso> corsi= dao.getTuttiICorsi();
		return corsi;
	}

	public String getStudenti(Corso corsoSelezionato) {
		//StudenteDAO daoS= new StudenteDAO();
		CorsoDAO daoC= new CorsoDAO();
		List<Studente> studenti= daoC.getStudentiIscrittiAlCorso(corsoSelezionato);
		if(studenti.size()>0){
		String s=this.trasformaStringa(studenti);
		return s;}
		else
			return "nessuno studente iscritto a questo corso";
		
	}

	private String trasformaStringa(List<Studente> studenti) {
		String s="";
		for(Studente studente: studenti){
			s=s+studente.getMaticola()+" "+studente.getNome()+" "+studente.getCognome()+"\n";
		}
		return s.trim();
	}

	public String cercaCorsiStudenti(Studente stu) {
		StudenteDAO daoS= new StudenteDAO();
		Studente s=daoS.find(stu.getMaticola());
		daoS.getCorsiStudente(s);
		List<Corso> corsi= daoS.getCorsiStudente(s);
		String s1= this.trasformaCorsoStringa(corsi);
		return s1;
		
	}
	
	
	private String trasformaCorsoStringa(List<Corso> corsi) {
		String s="";
		for(Corso c: corsi){
			s=s+c.getCodins()+" "+c.getNome()+"\n";
		}
		return s.trim();
	}

	public String verificaStudenteCorso(Corso corsoSelezionato, int i) {
		StudenteDAO daoS= new StudenteDAO();
		Studente s=daoS.find(i);
		
		CorsoDAO daoC= new CorsoDAO();
		List<Studente> studenti= daoC.getStudentiIscrittiAlCorso(corsoSelezionato);
		if(studenti.contains(s)){
			String frase="lo studente e' inscritto al corso";
			return frase;
		}
		
		String frase="lo studente NON e' inscritto al corso";
		return frase;
	}

	public boolean controllaSoloInt(String text) {
		int i= text.length();
		boolean flag=true;
		for(int j=0; j<i; j++){
		  flag= this.controlIntChar( text.charAt(j));
		  if(flag==false)
			  return false;
					
		}
		return true;
		
	}

	private boolean controlIntChar(char carattere) {
		
		for(int k=0;k<10;k++){
			String s=(""+carattere);
			if(s.contains(""+k)){
			 return true;
			}
		}
		return false;
	}
	public boolean booleanVerificaStudenteCorso(Corso corsoSelezionato, int i) {
		StudenteDAO daoS= new StudenteDAO();
		Studente s=daoS.find(i);
		
		CorsoDAO daoC= new CorsoDAO();
		List<Studente> studenti= daoC.getStudentiIscrittiAlCorso(corsoSelezionato);
		if(studenti.contains(s)){
			return true;
		}
		
		return false;
	}
	
	public String iscriviStudenteAlCorso(String text, Corso corso) {
		int matricola=Integer.parseInt(text);
		if(this.booleanVerificaStudenteCorso(corso, matricola)==true){
			return "lo studente e' gia iscritto al corso";
		}
		else{
			StudenteDAO daoS= new StudenteDAO();
			CorsoDAO daoC=new CorsoDAO();
			
			Studente s=daoS.find(matricola);
			boolean flag=daoC.inscriviStudenteACorso(s, corso);
			if(flag==true){
				return "Studente iscritto correttamente";
			}
			else{
				return"problema nell'iscriione dello studente al corso";
			}
		}
	}

}
