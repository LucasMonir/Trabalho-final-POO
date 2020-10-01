package Componentes;

public class Cliente implements Consulta {
    private String nome;
    private int cpf=0;
    private Titulo titulo;
    
    //Cria um cliente
    public Cliente(String nome, int cpf, Titulo titulo){
        this.nome=nome;
        this.cpf=cpf;
        this.titulo=titulo;
    }

    //implementa Inteface Consulta
    public String consultaTitulo(){
        return "Cliente: "+getNome()+"\n"+"CPF:"+getCpf()+"\n"+titulo.consultaTitulo();
    }
    
    //implementa Inteface Consulta
    @Override
    public String relacaoDebito() {
        return "Cliente: "+nome+"| "+titulo.relacaoDebito();
    }
    
    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    public Titulo getTitulo() {
        return titulo;
    }
    
    public double getDebito(){
        return titulo.getDebito();
    }
    
    //implementa Inteface Consulta
    @Override
    public String getSituacaoCodigo(){
        return titulo.getSituacaoCodigo();
    }
    
    //Metodo equals sobrescrito para atender funcionamento desejado
    @Override
    public boolean equals(Object obj)
	{
		if(!(obj instanceof Cliente))
		{
			return false;
		}

        Cliente other = (Cliente) obj;
        if(obj==other){
            return true;
        }
        return false;
    } 
    
    //Metodo sobrescrito para criação de hashcode utilizando cpf, criando um espalhamento melhor.
    @Override
    public int hashCode(){
        return this.cpf !=0? this.cpf % 31:0;
    }
}