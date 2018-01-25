package futbol;

import java.util.ArrayList;
import java.util.Random;

public class Pelota {

	private boolean disponible;
	public int point_x,point_y;
	
	public Pelota() {
		this.disponible = true;
		this.point_x=25;
		this.point_y=25;
	}
	
	public void setLibre(boolean estado){
		this.disponible = estado;
	}
	
	public boolean getLibre(){
		return this.disponible;
	}
	
	public synchronized void desplazar(Futbolista f){
		int tamCampo = 50;
		if(this.getLibre() == false){
			try {
				wait();
			} catch (Exception e) { 
				System.out.println(e);	
			}
		}
		Random rnd = new Random();
		
		int x = rnd.nextInt(tamCampo+1);
		int y = rnd.nextInt(tamCampo+1);
		int tmp = 0;
		
		if ((x+this.point_x) > tamCampo){
			tmp = tamCampo-this.point_x;
			tmp = x-tmp;
			this.point_x = tamCampo-tmp;
		} else {
			this.point_x+=x;
		}
		
		if ((y+this.point_y) > tamCampo){
			tmp = tamCampo-this.point_y;
			tmp = y-tmp;
			this.point_y = tamCampo-tmp;
		} else {
			this.point_y+=y;
		}
		
		System.out.println(f.nombre + " mueve la pelota a la posicion X:"+ point_x+" Y:"+point_y);

		f.point_x = this.point_x;
		f.point_y = this.point_y;
		
		this.setLibre(true);
		notify();
	}
	
	public void printPosicion(){
		System.out.println("Pelota X:"+ this.point_x+" Y:"+this.point_y);
	}

	public void estadoActual(ArrayList<Futbolista> partido) {
		System.out.println("############");
		for(int i=0;i<partido.size();i++){
			partido.get(i).printPosicion();
		}
		this.printPosicion();
		System.out.println("############");
	}
}
