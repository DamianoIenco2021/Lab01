package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.*;

public class Parole {
	private List<String>listaParole;
		
	public Parole() {
		this.listaParole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.removeAll(listaParole);
	}

	public String toString() {
		return  listaParole + "\n";
	}
	
	
	

}
