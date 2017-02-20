package ram_sim;

public class Etiqueta {
	
	private String name;
	private int it;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public Etiqueta(String nombre, int i){
		name = nombre;
		it = i;
	}

		public String toString(){
			return name + " salto a " + it;
		}
}
