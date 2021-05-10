package eniac.projeto.sched.model;

public class Usuario {
    int codigo;
    String nome;
    String senha;
    String usuario;
    public  Usuario(){

    }
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    public Usuario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Usuario(String nome, String senha, String usuario) {
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
    }
    public String getNome(){
        return this.nome;
    }
    public String getSenha(){
        return this.senha;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
}
