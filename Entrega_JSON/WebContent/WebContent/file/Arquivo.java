package file;

import java.io.File;

public class Arquivo {
	
	File arquivo = new File("C:\\logs","arquivo.log");
	
	public void metodo(){
		if(arquivo.isFile()){
			//fazer coisas com o arquivo
		} else if(arquivo.isDirectory()){
			//fazer coisa com o diretorio
		}
		
		String[] arquivos = arquivo.list();
		
		long tempo = arquivo.lastModified();
		
		long tamanho = arquivo.length();
		
	}

}
