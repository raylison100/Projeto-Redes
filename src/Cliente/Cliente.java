package Cliente;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class Cliente {
	

	private String nomeArquivo;
    private transient String ipDestino = null;
	String recebe = null;
  
     
    public Cliente(){
    	
    	setIpDestino("localhost");

    }

	public void estabelencendoConexao() {
		Socket s = null;
		
		try {
		
		
			s = new Socket(getIpDestino(),3322);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			out.writeUTF(getNomeArquivo().toUpperCase());
			out.flush();
			
		    recebe = in.readUTF();
				
		} catch (Exception e) {
			
		}
		finally{
			try{
				if(s!=null) 
					s.close();
			}catch(Exception e2){}
		}
	}

	
	
	public static String tituloDaPagina(String entrada){
		String resultado = "";
		String temp = null;
		StringTokenizer st = new StringTokenizer(entrada, "<>", false);
		while(st.hasMoreTokens()){
			temp = st.nextToken();
			if(temp.equals("title")){
				temp = st.nextToken();
				resultado += temp;
			}
		}
		return resultado;
	}

	public static String removerPrimeiraLinha(String entrada){
		String resultado = "";
		char[] aux = new char[entrada.length()];
		aux = entrada.toCharArray();
		int i = 0;
		while(aux[i] != '<'){
			aux[i] = 0;
			i++;
		}
		for(int j = 0; j <= (aux.length-1); j++){
			if(aux[j] != 0){
				resultado += aux[j];
			}
		}
		return resultado;
	}

	public  String converterString(String entrada){
		String resultado = "";

			entrada = removerPrimeiraLinha(entrada);
			String temp = null;
			int i = 0, n = 0, s = 0;
			StringTokenizer st = new StringTokenizer(entrada, "<>/", true);
			while(st.hasMoreTokens()){
				temp = st.nextToken();
				if(temp.equals("NEG")){
					if(n == 0){
						resultado += "b";
						n++;
					}else if(n == 1){
						resultado += "/b";
						n = 0;
					}
				}else if(temp.equals("SUB")){
					if(s == 0){
						resultado += "u";
						s++;
					}else if(s == 1){
						resultado += "/u";
						s = 0;
					}
				}else if(temp.equals("ITA")){
					if(i == 0){
						resultado += "i";
						i++;
					}else if(i == 1){
						resultado += "/i";
						i = 0;
					}
				}else if(temp.contains("TAM")){
					if(temp.length() > 3){
						resultado += "font size=\"";
						resultado += temp.substring(4, temp.length());
						resultado += "\"";
					}else{
						resultado += "/font";
					}
				}else if(temp.contains("COR")){
					if(temp.length() > 3){
						resultado += "font color=\"";	
						resultado += temp.substring(4, temp.length());
						resultado += "\"";
					}else{
						resultado += "/font";
					}
				}else if(temp.equals("htm")){
					resultado += "html";
				}else if(temp.contains("/")){
					resultado += "";
				}else{
					resultado += temp;
				}
			}
			return resultado;
	}


	

	public String getIpDestino() {
		return ipDestino;
	}


	public void setIpDestino(String ipDestino) {
		this.ipDestino = ipDestino;
	}


	public String getNomeArquivo() {
		return nomeArquivo;
	}


	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}


	
	public String getRecebe() {
			return recebe;
		}

	public void setRecebe(String recebe) {
			this.recebe = recebe;
		}
	
	
}
