package ram_sim;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Instruccion {
	
	private String operando;
	private String code;
	
	public Instruccion(String cod, String op){
		code = cod;
		operando = op;
	}




	public String getOperando() {
		return operando;
	}

	public void setOperando(String operando) {
		this.operando = operando;
	}
	
	public String toString(){
		return "" + code + "";
	}

	public int ejecutar(int it, ArrayList<Etiqueta> etiq, ArrayList<Integer> memDatos, InputTape input, String out) throws IOException{
		
		switch(code){
			case "load":{
				load(memDatos);
			}break;
			case "store":{
				store(memDatos);
			}break;
			case "add":{
				add(memDatos);
			}break;
			case "sub":{
				sub(memDatos);
			}break;
			case "mul":{
				mul(memDatos);
			}break;
			case "div":{
				div(memDatos);
			}break;
			case "read":{
				read(input,memDatos);
			}break;
			case "write":{
				write(out,memDatos);
			}break;
			case "jump":{
				it = jump(etiq);
			}break;
			case "jzero":{
				it = jzero(etiq,memDatos,it);
			}break;
			case "jgtz":{
				it = jgtz(etiq,memDatos,it);
			}break;
			case "halt":{
				halt();
			}break;
		}
		return it;
	}
	
	public void load(ArrayList<Integer> memDatos){
		
		System.out.println("Hago la funcion load");
		
		if(getOperando().contains("=")){ //Constante
			setOperando(operando.replace("=", ""));
			System.out.println(Integer.parseInt(getOperando()));
			memDatos.set(0, Integer.parseInt(getOperando()));
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			
			memDatos.set(0, memDatos.get(dirInd));
		}else{ // directo
			System.out.println("El operando de " + code + operando + " es " + memDatos.get(Integer.parseInt(operando)));
			memDatos.set(0, memDatos.get(Integer.parseInt(operando)));
		}
		
		
	}
	public void store(ArrayList<Integer> memDatos){
		if(getOperando().contains("=")){ //Constante
			System.out.println("No hago nada");
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			memDatos.set(memDatos.get(dirInd),memDatos.get(0));
		}else{ // directo
			memDatos.set(memDatos.get(Integer.parseInt(operando)),memDatos.get(0));
		}
		System.out.println("Hago la funcion store");
	}
	public void add(ArrayList<Integer> memDatos){
		int add;
		if(getOperando().contains("=")){ //Constante
			setOperando(operando.replace("=", ""));
			add = Integer.parseInt(getOperando()) + memDatos.get(0);
			memDatos.set(0, add);
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			add = memDatos.get(dirInd) + memDatos.get(0);
			memDatos.set(0, add);
		}else{ // directo
			add = memDatos.get(Integer.parseInt(operando)) + memDatos.get(0);
			memDatos.set(0, add);
		}
		System.out.println("Hago la funcion add");
	}
	public void sub(ArrayList<Integer> memDatos){
		int sub;
		if(getOperando().contains("=")){ //Constante
			setOperando(operando.replace("=", ""));
			sub =  memDatos.get(0) - Integer.parseInt(getOperando());
			memDatos.set(0, sub);
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			sub = memDatos.get(0) - memDatos.get(dirInd);
			memDatos.set(0, sub);
		}else{ // directo
			sub = memDatos.get(0) - memDatos.get(Integer.parseInt(operando));
			memDatos.set(0, sub);
		}
		System.out.println("Hago la funcion sub");
	}
	public void mul(ArrayList<Integer> memDatos){
		int sub;
		if(getOperando().contains("=")){ //Constante
			setOperando(operando.replace("=", ""));
			sub =  memDatos.get(0) * Integer.parseInt(getOperando());
			memDatos.set(0, sub);
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			sub = memDatos.get(0) * memDatos.get(dirInd);
			memDatos.set(0, sub);
		}else{ // directo
			sub = memDatos.get(0) * memDatos.get(Integer.parseInt(operando));
			memDatos.set(0, sub);
		}
		System.out.println("Hago la funcion mul");
	}
	public void div(ArrayList<Integer> memDatos){
		int sub;
		if(getOperando().contains("=")){ //Constante
			setOperando(operando.replace("=", ""));
			sub =  memDatos.get(0) / Integer.parseInt(getOperando());
			memDatos.set(0, sub);
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			sub = memDatos.get(0) / memDatos.get(dirInd);
			memDatos.set(0, sub);
		}else{ // directo
			sub = memDatos.get(0) / memDatos.get(Integer.parseInt(operando));
			memDatos.set(0, sub);
		}
		System.out.println("Hago la funcion div");
	}
	public void read(InputTape input, ArrayList<Integer> memDatos){
		
		System.out.println("Hago la funcion read");
		
		int leido = input.leer();
		if(getOperando().contains("=")){ //Constante
			System.out.println("no hago nada");
		}else if(operando.contains("*")){ //indirecto
			setOperando(operando.replace("*", ""));
			int dirInd = memDatos.get(Integer.parseInt(operando));
			memDatos.set(leido, memDatos.get(dirInd));
			
			
		}else{ // directo
			System.out.println("Estoy metiendo " + leido + " en " + operando);
			memDatos.set(Integer.parseInt(operando),leido);
		}
		
	}
	public void write(String out, ArrayList<Integer> memDatos) throws IOException{
		BufferedWriter output = null;
        try {
            //File file = new File(out);
        	File file = new File("prueba.txt");
            output = new BufferedWriter(new FileWriter(file));
            if(getOperando().contains("=")){ //Constante
    			output.write(operando);
    		}else if(operando.contains("*")){ //indirecto
    			setOperando(operando.replace("*", ""));
    			int dirInd = memDatos.get(Integer.parseInt(operando));
    			output.write(memDatos.get(dirInd));
    			
    			
    		}else{ // directo
    			System.out.println("Escribo "+ memDatos.get(Integer.parseInt(operando)));
    			output.write(String.valueOf(memDatos.get(Integer.parseInt(operando))) + " ");
    			
    		}
            System.out.println("Hago la funcion write");
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
		
	}
	}
	public int jump(ArrayList<Etiqueta> etiq){
		//System.out.println("Hago la funcion jump to " + getOperando());
		for(Etiqueta t:etiq){
			 if(t.getName().equals(getOperando())){
				 //System.out.print("El retorno de lee es " + t.getIt());
				 return t.getIt()-1;
			 }
		 }
		
		return 4;
	}
	public int jzero(ArrayList<Etiqueta> etiq, ArrayList<Integer> memDatos, int it){
		System.out.println("Hago la funcion jzero con operando " + getOperando() );
		if(memDatos.get(0) == 0){
			for(Etiqueta t:etiq){
				 if(t.getName().equals(getOperando())){
					 return (t.getIt()-1);
				 }
			 }
		}
		return it;
	}
	public int jgtz(ArrayList<Etiqueta> etiq, ArrayList<Integer> memDatos, int it){
		System.out.println("Hago la funcion jgtz");
		if(memDatos.get(0) > 0){
			for(Etiqueta t:etiq){
				 if(t.getName().equals(getOperando())){
					 return t.getIt()-1;
				 }
			 }
		}
		return it;
	}
	public void halt(){
		System.out.println("Hago la funcion halt");
		System.exit(0);
	}
	
}// cierre de clase
