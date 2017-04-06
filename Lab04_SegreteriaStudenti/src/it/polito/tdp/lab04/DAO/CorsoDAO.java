package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso co= new Corso(
						rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd")
						);
               corsi.add(co);
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				
										
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */	
	public Corso getCorso(String codins) {//Non capito cosa deve fare. sarebbe piu bello farlo con try e catch, e' giusto cambiando i metodi?
		List<Corso> corsi= this.getTuttiICorsi();
	
		
		for(Corso a: corsi){
			if(a.getCodins().equals(codins)){
				return a;
			}
		}
		
	   return null;
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		//List<Studente> studenti= new LinkedList<Studente>();
		
		final String sql = "SELECT * FROM iscrizione";
		Connection conn = ConnectDB.getConnection();
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
         			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				if(corso.getCodins().equals(rs.getString("codins"))){
					
					StudenteDAO stuDAO= new StudenteDAO();
					Studente s=stuDAO.find(rs.getInt("matricola"));
					
				    //s.aggiungiCorso(corso);
					
					corso.aggiungiStudente(s);
				}
				
				}
				
               //studenti.add(stu);
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				
										

			return corso.getStudenti();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		String sql="INSERT INTO `iscritticorsi`.`iscrizione` (`matricola`,`codins`) VALUES (?,?);";
		
		Connection conn = ConnectDB.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, studente.getMaticola());
			st.setString(2, corso.getCodins());
			
			int result=st.executeUpdate();
			conn.close();
			
			if(result==1){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
}
