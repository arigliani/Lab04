package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
//	private ConnectDB db;

      
	public Studente find(int codice){
		
		String sql = 
				//INSERT INTO `iscritticorsi`.`studente` (`matricola`, `cognome`, `nome`) VALUES ('544545', 'g', 'h');
		"SELECT `matricola`, `cognome`, `nome`, `CDS` "+
				"FROM `iscritticorsi`.`studente` "+
		"WHERE  `matricola`=?";
		String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root";
		
		
		Studente result= null;
		try {
			Connection conn= DriverManager.getConnection(jdbcUrl);
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setInt(1, codice);
			
         ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				
				Studente ex = new Studente(
						res.getInt("matricola"),
						res.getString("nome"),
						res.getString("cognome")
					
						) ;
				
				if(res.getString("CDS")!=null){
					ex.setCds(res.getString("CDS"));
				}
				
				// TODO: estrarre anche voto e data_superamento !!
				
				result = ex ;
				} else {
					result = null;
				}
				
				conn.close();
				return result ;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public List<Corso> getCorsiStudente(Studente s) {
		//List<Studente> studenti= new LinkedList<Studente>();
		
		final String sql = "SELECT * FROM iscrizione";
		Connection conn = ConnectDB.getConnection();
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
         			
			ResultSet rs = st.executeQuery();
            
			while (rs.next()) {
				if(s.getMaticola()==rs.getInt("matricola")){
					
					CorsoDAO cDAO= new CorsoDAO();
					String codins=rs.getString("codins");
					Corso c=cDAO.getCorso(codins);
				    s.aggiungiCorso(c);
					
				}
				
				}
				
               //studenti.add(stu);
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				
										

			return s.getCorsi();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	
	
	
	
	
	/*public boolean create(Studente s){
				
		String sql="INSERT INTO `iscritticorsi`.`studente` (`matricola`, `cognome`, `nome`) VALUES (?,?,?);";
		String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root";

		
		int result=0;
		try {
			Connection conn= DriverManager.getConnection(jdbcUrl);

			PreparedStatement st = conn.prepareStatement(sql) ;
			int i=Integer.parseInt("matricola");
			st.setInt(1, i); // mTRICOLA NON me lo da come intero
			st.setString(2, "cognome");
			st.setString(3, "nome");
			
            result = st.executeUpdate() ;
			
			conn.close();
			
			if(result==1) {
				return true ;
			} else {
				return false ;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		return false;
		
	}*/
	
    
}
