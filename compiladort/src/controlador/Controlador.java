package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Programa;
import modelo.Traductor;
import modelo.Interprete;
import modelo.Maquina;
import modelo.Figura;
import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}

	public void cambiarPosicion(Figura f, Point p){
		f.setPosicion(p);
	}
	
	public Vista getVista(){
		return vista;
	}
	public void quitarFigura(Figura f){
		
		modelo.QuitarFigura(f);
	}
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev) {
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			seleccionada=this.getFiguraEn(ev.getPoint());
			
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			if(this.getFiguraEn(ev.getPoint())==null)
			this.anyadirFigura(new Traductor(ev.getPoint(),40));
			if(this.getFiguraEn(ev.getPoint()).getSeleccionada()==true && this.getFiguraEn(ev.getPoint()).getTipo()==1){
			this.quitarFigura(this.getFiguraEn(ev.getPoint()));
			this.anyadirFigura(new Interprete(ev.getPoint(), 40));
				
			}
			if(this.getFiguraEn(ev.getPoint()).getSeleccionada()==true && this.getFiguraEn(ev.getPoint()).getTipo()==3){
				this.quitarFigura(this.getFiguraEn(ev.getPoint()));
				this.anyadirFigura(new Programa(ev.getPoint(), 57));
					
				}
			if(this.getFiguraEn(ev.getPoint()).getSeleccionada()==true && this.getFiguraEn(ev.getPoint()).getTipo()==2){
				this.quitarFigura(this.getFiguraEn(ev.getPoint()));
				this.anyadirFigura(new Maquina(ev.getPoint(), 40));
					
				}
			
				
				
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{

			if(this.getFiguraEn(ev.getPoint()).getSeleccionada()==true ){
				this.quitarFigura(this.getFiguraEn(ev.getPoint()));
					
				}
				
		//	this.anyadirFigura(new Programa(ev.getPoint(),57));
		}
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){
			//El movimiento puede ser mas fluido recalculando el pto
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
		}
	}

}
