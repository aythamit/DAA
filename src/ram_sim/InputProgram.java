package ram_sim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputProgram {
	
	
	public InputProgram(String archivo, ArrayList<Instruccion> vecIns, ArrayList<Etiqueta> vecTag) throws IOException, FileNotFoundException{
		
			String cadena;
			int contInstruc = 0;
	        FileReader fichero = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(fichero);
	        while((cadena = b.readLine())!=null) {
	            if(!cadena.contains("#")){
	            	if(!cadena.isEmpty()){
	            		
	            		cadena = cadena.replaceAll("\\s"," ");
	            		cadena = cadena.toLowerCase();
	            		//System.out.println( "----" + cadena);
	            		
			            StringTokenizer tokenNumero = new StringTokenizer(cadena, " ");
			            while (tokenNumero.hasMoreElements()) {
			                
							String leoToken = tokenNumero.nextElement().toString();
							if(leoToken.contains(":")){ // Es etiqueta
								leoToken = leoToken.replace(":", "");
								//System.out.println(leoToken);
								vecTag.add(new Etiqueta(leoToken,contInstruc));
							}
							else{ // Es intruccion
								contInstruc++;
								if(!leoToken.equals("halt"))
								{
									String leoToken2 = tokenNumero.nextElement().toString();
									//System.out.println(leoToken + " " + leoToken2);
									selectIns(leoToken, leoToken2,vecIns);
									
								}else{
									selectIns(leoToken, "",vecIns);
									//System.out.println(leoToken);
								}
							}
							
							
			            }
	            	}

			    }
	        }
	        
	        //System.out.println("Hay: " + contInstruc + " instrucciones.");
	}

	private void selectIns(String instr, String op, ArrayList<Instruccion> vec) 
	{
		switch(instr){
			case "load":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "store":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "add":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "sub":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "mul":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "div":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "read":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "write":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "jump":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "jzero":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "jgtz":{
				vec.add(new Instruccion(instr,op));
			}break;
			case "halt":{
				vec.add(new Instruccion(instr,"halt"));
			}break;
		}

		
	}

	

}
