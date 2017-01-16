package Servido;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
public class Servidor
{
	
	Socket cliente;
	
  public  void estabelecerConecao()
  {
    ServerSocket s;
    
     
    
    try
    {
      int p = 3322;
      s = new ServerSocket(p);
      
       cliente = s.accept();

     
      DataInputStream in = new DataInputStream(cliente.getInputStream());
      DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
      String Recebe = in.readUTF();
      out.writeUTF(enviaPagina(Recebe));           
      
      
     
    

    }
    catch(Exception e)
      { }
   }
  
  public void encerraConexao(){
	  try {
		cliente.close();
	} catch (IOException e) {
	
		
	}
  }


  public  String index(){
		String resultado = "";
		resultado +="HTTP/1.1 200 OK"
				+ "<htm>"
				+ "<title>"
				+ "Projeto de Redes"
				+ "</title>"
				+ "<body>"
				+ "<NEG><TAM 30><p>     Projeto de Redes</p></h1></TAM></NEG>"
				+ "<SUB><COR green><br>   Professora jeisa</br></COR></SUB>"
				+ "<body>"
				+ "<htm>";	
		return resultado;
	}

	public  String teste(){
		String resultado = "";
		resultado +="HTTP/1.1 200 OK"
				+ "<htm>"
				+ "<title>"
				+ "Projeto de Redes"
				+ "</title>"
				+ "<body>"
				+ "<NEG><TAM 30><p>    Projeto de Redes</p></h1></TAM></NEG>"
				+ "<br>Alunos:</br>"
				+ "<ITA>Raylison nunes "
				+ "<br>Pedro Carlos</br></ITA>"
				+ "<body>"
				+ "<htm>";	
		return resultado;
	}

	public  String erro404(){
		return  
				 "<htm>"
				+ "<title>"
				+ "Projeto de Redes"
				+ "</title>"
				+ "<body>"
				+ "<NEG><TAM 30><p>404 HTTP Not Found</p></h1></TAM></NEG>"
				+ "<ITA><br><TAM 10>  Desculpe,  mas não conseguimos encontrar a página solicitad<TAM 20> </br></ITA>"
				+ "<body>"
				+ "<htm>";	
	}

	public  String erro400(){
		return "<htm>"
			 + "<title>"
			 + "Projeto de Redes"
			 + "</title>"
			 + "<body>"
			 + "<NEG><TAM 29><p>400 Bad Request</p></h1></TAM></NEG>"
			 + "<ITA><br><TAM 10> Desculpe,  mas não conseguimos encontrar a página solicitad<TAM 20> </br></ITA>"
			 + "<body>"
			 + "<htm>";	
	}

	
	public  boolean analisarComando(String comando){
		boolean ok = false;
		String temp;
		StringTokenizer st = new StringTokenizer(comando, " ", true);
		while(st.hasMoreTokens()){
			temp = st.nextToken();
			if(temp.equals("GET")){
				ok = true;
				break;
			}
		}
		return ok;
	}

	public  String enviaPagina(String comando){
		String temp, retorno = "";
		int i = 0;
		if (analisarComando(comando)){
			StringTokenizer st = new StringTokenizer(comando, " ", false);
			while(st.hasMoreTokens()){
				temp = st.nextToken();
				if(temp.equals("/")){
					retorno = index();
					i++;
					break;
				}else if(temp.equals("/TESTE")){
					retorno = teste();
					i++;
					break;
				}
			}
			if(i == 0){
				retorno = erro404();
			}
		}else{
			retorno = erro400();
		}
		return retorno;
	}



}
