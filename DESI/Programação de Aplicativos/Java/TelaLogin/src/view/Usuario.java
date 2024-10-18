package view;

/**
 * @author julio_busarello
 */
public class Usuario {
    private String name, user, password;
    private Integer cod;
    
    public Usuario(){
    }
    
    public Usuario(String name, String user, String password){
        this.name = name;
        this.user = user;
        this.password = password;
    }
    
    public Usuario(Integer cod, String name, String user, String password){
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public void setCod(Integer cod) {
        this.cod = cod;
    }
    
}
