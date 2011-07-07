package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	
	private List<Figura> listaFiguras;
	public Modelo(){
		listaFiguras = new ArrayList<Figura>();
	}
	
	public void AnyadirFigura(Figura f){
		listaFiguras.add(f);
	}
	
	public void QuitarFigura(Figura f){
		
		listaFiguras.remove(f);
		
	}
	public List<Figura> getListado(){
		return listaFiguras;
	}
	
	public void quitarFigura(Figura f){
		
		listaFiguras.remove(f);
		
	}
	
	public void anyadirFigura(Figura f){
		listaFiguras.add(f);
	}
	
	public Figura getFiguraEn(Point p){
		for (Figura elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
				return elemento;				
			}
		}
		return null;
	}
}
