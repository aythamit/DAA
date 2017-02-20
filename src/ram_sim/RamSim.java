package ram_sim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class RamSim {
	
	 ArrayList<Instruccion> instruc  = new ArrayList<Instruccion>();
	 ArrayList<Etiqueta> tag = new ArrayList<Etiqueta>();
	 ArrayList<Integer> memDatos = new ArrayList<Integer>();
	 InputProgram program;
	 InputTape input;
	 
	 public RamSim(String programa, String tape, String out) throws FileNotFoundException, IOException{
		 
		 program = new InputProgram(programa,instruc,tag);
		 input = new InputTape(tape);
		 for(int i=0;i<15;i++)
			 memDatos.add(0); // R0, el acumulador.

			 for(int i=0;i<instruc.size();i++){
				
				i = instruc.get(i).ejecutar(i,tag,memDatos,input,out);
			 }
				
		 }
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		
		System.out.println(args[0]+" " + args[1] + " " + args[2]);
		RamSim p = new RamSim(args[0],args[1],args[2]);
		
		
		}

}
