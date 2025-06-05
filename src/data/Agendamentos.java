
package data;

public class Agendamentos {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String idata;
    private String anotacoes;

    public Agendamentos() {
    }

    public Agendamentos(String id, String nome, String endereco, String telefone, String idata, String anotacoes) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idata = idata;
        this.anotacoes = anotacoes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdata() {
        return idata;
    }

    public void setIdata(String idata) {
        this.idata = idata;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    
}
