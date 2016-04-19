package core.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import structures.Lista;
import structures.Nodo;

/*
 * @ClassName : Files 
 * Responsibility : Manejo de archivos y carpetas
 * Auhor: Luis ALberto Bolaños
 * Created: 11-dic-2015
 * Modified by:
 * Modified:
 */
public class Files {
	
	public Files(){
	
	}

	/*
	* @Method: read
	* Description: Lee el contenido de un archivo
	* Params: path: {string} ruta absoluta del archivo a leer 
	* Return: Objecto Lista
	* Recomendaciones:
	*/
	public String read(String path) throws Exception{
		BufferedReader br = null;
		String line = "";
		String content = "";
		try{
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null){
				content+= line;
			}
			
			return content;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			br.close();
		}
	}
	
		
	/*
	* @Method: getFilesDirectory
	* Description: Obtiene una lista con las rutas absolutas de los archivos a partir de un directorio base
	* Params: directory: {string} carpeta base o path,  
	* Return: Objecto Lista
	* Recomendaciones:
	*/
	public Lista getFilesDirectory( File root ){
		
		File [] files = null;
		int index = 0;
		Lista listDirectories = null;
		Lista listFiles = null; 
		Nodo nodo = null;
		try{
			
			// Consulta los archivo en la ruta raiz
			
			files = root.listFiles();
			listDirectories = new Lista();
			
			// Se adiciona el directorio base
			listFiles = new Lista();
			//listFiles.add(directory);
			//nodo = listFiles.getPrimerNodo();
			
			if(files != null){
				do{
					
					//  Obtiene los archivos y carpertas
					
						
					
					files = root.listFiles();
					for(File resource : files){
						
						if(resource.isFile() && resource.getAbsolutePath().endsWith(".java")){
							listFiles.add(resource.getAbsolutePath());
						}
						
						if(resource.isDirectory()){
							listDirectories.add(resource.getAbsolutePath());
						}
						
					}
					
					// Verifica si hay  directorios tal caso obtiene el nodo y aumenta el index
						
					if(nodo == null){
						nodo =  listDirectories.getPrimerNodo();
					}
					else{
						nodo =  nodo.getNodoDerecho();
					}
					
					if(nodo != null && nodo.getValue() != null)
						root  = new File(nodo.getValue().toString());
						
						
					

				}while(nodo != null);
			}
			
			
			
			return listFiles;
			
		}
		catch(Exception e){
			throw e;
		}
	}
	
	/*
	* @Method: readLines
	* Description: Obtiene las lineas de un archivo especifico
	* Params: path{string}: ruta absolutad del archivo
	* Return: Objecto Lista
	* Recomendaciones:
	*/
	public Lista readLines(String path) throws Exception{
		BufferedReader bufferReader = null;
		String currentLine = null;
		Lista codeLines = null;
		try{
			//Lectura del contenido del archivo
			bufferReader = new BufferedReader(new FileReader(path));
			codeLines = new Lista();
			while( (currentLine = bufferReader.readLine()) != null ){
				//Adicionado linea al la lista
				codeLines.add(currentLine);
			}
			
			return codeLines;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			if(bufferReader!=null)
				bufferReader.close();
		}
		
	}
	
	
	/*
	* @Method: Read
	* Description: Almacena en una Lista los valores de dos columnas de un archivo
	* Params: path: {string} ruta absoluta del archivo a leer 
	*  idxCol1 : indice de primera columna a leer
	*  idxCol2 : indice de segunda columna a leer
	*  separator: caraceter separador de columnas
	* Return: Objecto Lista
	* Recomendaciones:
	*/
	public Lista readColumns(String path, int idxCol1, int idxCol2, String separator) throws Exception{
		BufferedReader br = null;
		String line = "";
		String [] columns = null;
		Lista lista = new Lista();
		String value = null;
		String secondValue = null;
		
		try{
			
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null){
				line = line.replace(" ", "");
				columns = line.split(separator);
				if(columns.length > 0){
					value = columns[idxCol1].replace(" ", "");
					secondValue = columns[idxCol2].replace(" ", "");
					lista.add(value, secondValue);
				}
			}
			return lista;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			br.close();
		}
	}
	
	
}
