package pt.tecnico.sd.store;

public class Doc {
	
	private String documento;
	private String nome;
	
	public void setName(String name){
		nome = name;
	}
	
	/* escrever no documento */
	
	public void writeDoc(String text){
		documento += text; 
	}
	
	
	/* ler do documento */
	
	public String readDoc(){
		return documento;
	}
	
	
	/* apagar documento*/
	
	public void clean(){
		documento = "";
	}

}
