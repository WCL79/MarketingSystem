package br.com.zup.exceptions;

public class ProdutoExistenteException extends RuntimeException {
    private int Status = 422;
    private String campo = "cpf";
    private String razao = "UNPROCESSABLE ENTITY";
    private String tipoErro = "Produto já cadastrado!";

    public ProdutoExistenteException(String message) {
        super(message);
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTipoErro() {
        return tipoErro;
    }

    public void setTipoErro(String tipoErro) {
        this.tipoErro = tipoErro;
    }

}
