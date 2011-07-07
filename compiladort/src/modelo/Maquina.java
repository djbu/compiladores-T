package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Maquina extends Figura{
	private int ancho;
	private String maquina;
	/*
	private int a[];
	private int b[];
	*/
	public Maquina(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false; 
		this.setTipo(3);
		/*
		this.a=new int[3];
		this.b=new int[3];
		this.a[0]=;
		this.a[1]=;
		this.a[2]=;
		this.b[0]=posicion.y+40;
		this.b[1]=posicion.y+60;
		this.b[2]=posicion.y+40;
		 
		*/
		//Deberia estar en el constructor pero por simplicidad
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	public void setMaquina(String Maquina){
		maquina = Maquina;
	}
	
	public String getMaquina(){
		return maquina;
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		int difY1=Math.abs(p.y-(posicion.y+40+(10)));
		
		return (( (difX<ancho/2) && (difY<ancho/2)) || ((difX<ancho/2) && (difY1<10)));   
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
		g.fillPolygon(new int[]{this.getX(),this.getX()+20,this.getX()+40}, new int[]{this.getY()+40,this.getY()+60,this.getY()+40}, 3);
		
		
		//g.fillRect(this.getX(), this.getY()+40, this.getAncho(), this.getAncho());
		if(this.getSeleccionada()){
			g.setColor(Color.YELLOW);
			g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAncho()-20);
		}
	}	
	

}
