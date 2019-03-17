package CaixaEletronico;

public class Cliente {
    private String nome;
    private int    id;

    Cliente(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
}
