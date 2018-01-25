package futbol;

import java.util.Random;

public abstract class Futbolista extends Thread {
	
	public String nombre;
	public int point_x, point_y;
	public Pelota ball;
	
	public Futbolista(String nombre, Pelota ball) {
		Random rnd = new Random();
		
		this.nombre = nombre;
		this.ball = ball;
		this.point_x = rnd.nextInt(51);
		this.point_y = rnd.nextInt(51);
	}
	
	public abstract void juega();
	
	public void run(){
			this.juega();
	}
	
	public void printPosicion(){
		System.out.println(this.nombre + " X:"+ this.point_x+" Y:"+this.point_y);
	}
}
