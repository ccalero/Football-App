package futbol;

public class Delantero extends Futbolista {
	
	public Delantero(String nombre, Pelota ball) {
		super(nombre,ball);
	}
	
	public void juega(){
		for (int i = 0; i < 5; i++) {
			ball.desplazar(this);
		}
	}
	
}
