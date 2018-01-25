package futbol;

public class Portero extends Futbolista{

	public Portero(String nombre,Pelota ball) {
		super(nombre,ball);
	}

	public void juega() {
		ball.desplazar(this);
	}
}
