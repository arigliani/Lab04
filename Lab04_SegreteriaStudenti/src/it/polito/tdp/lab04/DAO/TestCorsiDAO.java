package it.polito.tdp.lab04.DAO;

import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestCorsiDAO {
	public static void main(String[] args) {
		System.out.println("---------lista tutti corsi, metodo getTuttiCorsi--------");
		CorsoDAO dao=new CorsoDAO();
		
		List<Corso> corsi= dao.getTuttiICorsi();
		
		System.out.println(""+corsi);
		
		System.out.println("---------lista studenti, metodo getStudentiIscrittiAlCorso--------");
		Corso c= new Corso("09AQGPG", 8, "Economia aziendale", 1);
		 List<Studente> s= dao.getStudentiIscrittiAlCorso(c);
		System.out.println(""+s);
		 
        System.out.println("---------lista iscrizioni, metodo inscriviStudenteACorso--------");
        Corso c1= new Corso("09AQGPG", 8, "Economia aziendale", 1);
        Studente s1= new Studente(555,"fff", "fcvg");
		 boolean b=dao.inscriviStudenteACorso(s1, c1);
		if(b==true)
			System.out.println("aggiunto studente al corso");
		else
			System.out.println("errore nell' aggiungere");  
	}

}
