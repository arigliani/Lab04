package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

public class TestStudenteDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudenteDAO dao= new StudenteDAO();
		
		Studente s1=dao.find(146101);
		System.out.println(s1);
		
	
		boolean s2= dao.create(new Studente(99999, "aldo", "brutto"));
		if(s2==true){
			Studente s3=dao.find(99999);
			System.out.println(s3);
		}else{
			System.out.println(" sbagliato metodo crea");
		}

	}

}
