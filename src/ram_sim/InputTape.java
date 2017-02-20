package ram_sim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class InputTape {
	ArrayList<Integer> tape= new ArrayList<Integer>();
	int cont;
	int size;
	
	public InputTape(String archivo) throws IOException
	{
		 cont = 0;
		String cadena;
		FileReader fichero = new FileReader(archivo);
        BufferedReader b = new BufferedReader(fichero);
      
        
        cadena = b.readLine();
        //System.out.println(cadena);
        StringTokenizer tokenNumero = new StringTokenizer(cadena, " ");
        while (tokenNumero.hasMoreElements()) {
            
			String leoToken = tokenNumero.nextElement().toString();
			tape.add(Integer.parseInt(leoToken));
        }
        
       
	}
	
	public int leer(){
		int aux = tape.get(cont);
		if((cont+1) < size())
		cont++;
		else
		cont = 0;
		return aux;
	}
	
	public int size(){
		return tape.size();
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		for(int i=0;i<size();i++)
			System.out.println(tape.get(i));
	}

}
