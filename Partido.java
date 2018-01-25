package futbol;

import java.util.ArrayList;

public class Partido {
	
	public static void main(String[] args) {
				
		Pelota ball = new Pelota();
		
		Delantero messi = new Delantero("messi",ball);
		Delantero cristiano = new Delantero("cristiano",ball);
		Portero casillas = new Portero("casillas",ball);
		Portero valdes = new Portero("valdes",ball);
				
		ArrayList<Futbolista> partido = new ArrayList<>();
		
		partido.add(messi);
		partido.add(cristiano);
		partido.add(casillas);
		partido.add(valdes);
		
		for(int i=0;i<partido.size();i++){
			partido.get(i).start();
			ball.estadoActual(partido);
		}		
	}
	
}
