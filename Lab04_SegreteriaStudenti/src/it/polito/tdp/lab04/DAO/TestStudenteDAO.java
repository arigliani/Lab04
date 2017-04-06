package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

import java.util.List;

import it.polito.tdp.lab04.model.Corso;
public class TestStudenteDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudenteDAO dao= new StudenteDAO();
		
		Studente s1=dao.find(146101);
		System.out.println(s1);
		
		Studente s2=dao.find(4444444);
		System.out.println(s2);
		
		
		List<Corso> c= dao.getCorsiStudente(s1);
		System.out.println(c.toString());
		
		
		
		
	/*  Studente stu= new Studente(999999, "aldo", "bello");
		boolean s2= dao.create(stu);
		if(s2==true){
			Studente s3=dao.find(999999);
			System.out.println(s3);
		}else{
			System.out.println(" sbagliato metodo crea");
		}*/

	}

}
