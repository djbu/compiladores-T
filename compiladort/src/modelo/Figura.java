package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {
	protected Point posicion;
	protected boolean seleccionada;
	protected int tipo;
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);	
	
	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	public  int getTipo(){
		return tipo;
		
	}
	public void setTipo(int a){
		
		tipo=a;
	}
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}

	Point getPosicion(){
		return posicion;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void setSeleccionada(boolean sel){
		seleccionada=sel;
	}

}
