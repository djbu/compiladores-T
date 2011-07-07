package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Interprete extends Figura{

	private int ancho;
	private String codigoFuente;
	private String maquina;
	
	public Interprete(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false; 
		
		this.setTipo(2);
		//Deberia estar en el constructor pero por simplicidad
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	public void setCodigoFuente(String codigoF){
		codigoFuente = codigoF;
	}
	

	public void setMaquina(String Maquina){
		maquina = Maquina;
	}
	
	public String getCodigoFuente(String codigoF){
		return codigoFuente;
	}
	

	public String getMaquina(){
		return maquina;
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		int difY1=Math.abs(p.y-(posicion.y+40+(ancho/2)));
		
		return (( (difX<ancho/2) && (difY<ancho/2)) || ((difX<ancho/2) && (difY1<ancho/2)));   
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
		g.fillRect(this.getX(), this.getY()+40, this.getAncho(), this.getAncho());
		if(this.getSeleccionada()){
			g.setColor(Color.YELLOW);
			g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAncho()-20);
		}
	}	
	
	
}
