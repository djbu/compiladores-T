package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Programa extends Figura {

	private int radio;
	private String codigoFuente;
	private String titulo;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Programa(Point posicion, int radio){
		this.posicion=posicion;
		this.radio=radio;
		this.seleccionada=false;  
		this.setTipo(4);
		//Deberia estar en el constructor de figura pero por simplicidad
	}
	
	public void setCodigoFuente(String codigoF){
		codigoFuente = codigoF;
	}
	

	public void setTitulo(String Titulo){
		titulo = Titulo;
	}
	
	public String getCodigoFuente(String codigoF){
		return codigoFuente;
	}
	

	public String getTitulo(){
		return titulo;
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x, 2 ) + Math.pow(p.y - posicion.y, 2 )) || ((Math.abs(p.x - (this.getX()+29))<20) && (Math.abs(p.y-(this.getY()+69))<20)))		
				return true;
		else
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		g.fillRect(this.getX()+9, this.getY()+49, 40, 40);
		
		if(this.getSeleccionada()){
			g.setColor(Color.CYAN);
			g.drawOval(this.getX()+7, this.getY()+7, this.getRadio()-20, this.getRadio()-20);
		}
	}

}
