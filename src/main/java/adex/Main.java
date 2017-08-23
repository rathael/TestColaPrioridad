package adex;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
		Queue<Persona> cola = new PriorityQueue<Persona>();

		cola.add(new Persona("Daniel", 1));
		cola.add(new Persona("Katherine", 3));
		cola.add(new Persona("Julio", 2));
		cola.add(new Persona("Maria", 1));

		while (!cola.isEmpty()) {
			Persona a = cola.remove();
			System.out.println(a.getNombre() + " " + a.getTipo());
		}
	}
}
