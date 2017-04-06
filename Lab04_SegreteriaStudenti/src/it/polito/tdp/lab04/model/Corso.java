package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class Corso {
	private String codins;
	private int crediti;
	private String nome;
	private int pd;
	private List<Studente> studenti= new LinkedList<Studente>();
	
	public Corso(String codins, int crediti, String nome, int pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}

	
	public List<Studente> getStudenti(){
		
		return this.studenti;
		
	}
	
	
	public boolean aggiungiStudente(Studente s){
		for(Studente stu: studenti){
			if(stu.getMaticola()==s.getMaticola())
				return false;
		}
		this.studenti.add(s);
		return true;
		
	}
	/**
	 * @return the codins
	 */
	public String getCodins() {
		return codins;
	}

	/**
	 * @param codins the codins to set
	 */
	public void setCodins(String codins) {
		this.codins = codins;
	}

	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ""+this.getNome();
	}
	
	
	

}
