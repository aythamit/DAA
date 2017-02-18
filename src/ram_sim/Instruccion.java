package ram_sim;

public class Instruccion {
	
	private int operando;
	private String code;
	
	public Instruccion(String cod, int op){
		code = cod;
		operando = op;
	}

	public Instruccion(String cod, String op) {
		// TODO Auto-generated constructor stub
		code = cod;
	}



	public int getOperando() {
		return operando;
	}

	public void setOperando(int operando) {
		this.operando = operando;
	}
	
	public String toString(){
		return "" + code + "";
	}

}
