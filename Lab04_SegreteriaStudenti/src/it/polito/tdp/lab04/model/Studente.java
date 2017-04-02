package it.polito.tdp.lab04.model;

public class Studente {
	private int maticola;
	private String nome;
	private String cognome;
	private String cds;
	
	public Studente(int maticola, String nome, String cognome) {
		super();
		this.maticola = maticola;
		this.nome = nome;
		this.cognome = cognome;
	}

	/**
	 * @return the maticola
	 */
	public int getMaticola() {
		return maticola;
	}

	/**
	 * @param maticola the maticola to set
	 */
	public void setMaticola(int maticola) {
		this.maticola = maticola;
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
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the cds
	 */
	public String getCds() {
		return cds;
	}

	/**
	 * @param cds the cds to set
	 */
	public void setCds(String cds) {
		this.cds = cds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maticola;
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
		Studente other = (Studente) obj;
		if (maticola != other.maticola)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Studente [maticola=" + maticola + ", nome=" + nome + ", cognome=" + cognome + ", cds=" + cds + "]";
	}
	
	

	
}
