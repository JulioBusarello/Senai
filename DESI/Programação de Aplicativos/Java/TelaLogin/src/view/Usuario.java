package view;

/**
 * @author julio_busarello
 */
public class Usuario {
    private String nome, usuario, password;
    private Integer cod;
    
    public Usuario(){
    }
    
    public Usuario(Integer cod, String nome, String usuario, String password){
        this.nome = nome;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCod() {
        return cod;
    } 
    
}
