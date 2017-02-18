package ram_sim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class RamSim {
	
	 ArrayList<Instruccion> instruc  = new ArrayList<Instruccion>();
	 
	 public RamSim(String archivo) throws FileNotFoundException, IOException{
		 InputTape cinta = new InputTape(archivo,instruc);
		 
		 for(Instruccion ins:instruc){
				System.out.println(" aaaaaaa	" + ins);
		 }
				
		 }
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		RamSim p = new RamSim(args[0]);
		
		}

}
