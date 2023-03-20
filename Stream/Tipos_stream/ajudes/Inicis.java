package cat.spaad.ajudes;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Inicis implements Serializable {
	
	@Serial
    private static final long serialVersionUID = 101L;
	
	int numeric;
	String alfanumeric;
	
	public Inicis(int numeric,String alfanumeric) {
		this.numeric = numeric;
		this.alfanumeric = alfanumeric;
	}
	
	
	public int getNumeric() {
		return numeric;
	}


	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}


	public String getAlfanumeric() {
		return alfanumeric;
	}


	public void setAlfanumeric(String alfanumeric) {
		this.alfanumeric = alfanumeric;
	}


	@Override
	public int hashCode() {
		return Objects.hash(alfanumeric, numeric);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inicis other = (Inicis) obj;
		return Objects.equals(alfanumeric, other.alfanumeric) && numeric == other.numeric;
	}

	@Override
	public String toString() {
		return "Inicis numeric=" + numeric + ", alfanumeric=" + alfanumeric;
	}
}
