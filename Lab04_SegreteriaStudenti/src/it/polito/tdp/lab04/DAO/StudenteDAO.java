package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	private ConnectDB db;

      
	public Studente find(String codice){
		
		String sql = 
				//INSERT INTO `iscritticorsi`.`studente` (`matricola`, `cognome`, `nome`) VALUES ('544545', 'g', 'h');
		"SELECT `matricola`, `cognome`, `nome`, `CDS` "+
				"FROM `iscritticorsi`.`studente` "+
		"WHERE  `matricola`=?";
		
		Studente result= null;
		try {
			Connection conn = db.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			st.setString(1, codice);
			
         ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				
				Studente ex = new Studente(
						res.getInt("matricola"),
						res.getString("nome"),
						res.getString("cognome")
					
						) ;
				
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
	
	public boolean create(Studente s){
		//manca cds
		String sql= "INSERT INTO `iscritticorsi`.`studente` (`matricola`, `cognome`, `nome`) VALUES ('?', '?', '?')";
		
		Connection conn = db.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, s.getMaticola());
			st.setString(2, s.getNome());
			st.setString(3, s.getCognome());
			
			if(s.getCds()!=null){
				st.setString(4, s.getCds());
			}
			
			int result = st.executeUpdate() ;
			
            conn.close();
			
			if(result==1) {
				return true ;
			} else {
				return false ;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
    
}
