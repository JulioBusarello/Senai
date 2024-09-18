/**
 * @author julio_busarello
 */
public class Fornecedor {
    private int codigo;
    private String empresa;
    private String contato;
    private String telefone;
    private String email;
    
    public Fornecedor(){
    }
    
    public Fornecedor(int codigo, String empresa, String contato, String telefone, String email) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
