/* 
 * IMPORTANTE: NAO ALTERE ESTE ARQUIVO
 */
package relatorio;

public abstract class Relatorio {
    private String autor;
    private String texto;
    
    public Relatorio(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return this.autor;
    }

    public final void setTexto(String texto) {
        this.texto = texto;
    }

    public final String getTexto() {
        return this.texto;
    }
    
    public abstract void imprimirRelatorio();
}