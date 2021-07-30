package operacoesstring;

public class OperacoesStrings {
    
    private String texto;

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return this.texto;
    }

    public int contaPalavras() {
        int qtd = 0;
        boolean palavra = false;
        for(int i = 0; i < this.texto.length(); i++) {
            char c = this.texto.charAt(i);
            if (c == ' ' || c == '.') {
                palavra = false;
                continue;
            }
            if (!palavra) {
                palavra = true;
                qtd++;
            }
        }
        return qtd;
    }

    public double comprimentoMedioPalavras() {
        double soma = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            char c = this.texto.charAt(i);
            if (c == ' ' || c == '.') continue;
            soma++;
        }
        return soma / this.contaPalavras();
    }

    public String maiorPalavra() {
        String maiorPalavra = "", palavra = "";
        int maior = 0;
        int len = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            char c = this.texto.charAt(i);
            if (c == ' ' || c == '.') {
                if (len > maior) {
                    maior = len;
                    maiorPalavra = palavra;
                    continue;
                }
                len = 0;
                palavra = "";
                continue;
            }
            palavra = palavra + c;
            len++; 
        }

        if (palavra.length() > maiorPalavra.length()) return palavra;
        return maiorPalavra;
    }

    public int comprimentoMaiorPalavra() {
        String palavra = this.maiorPalavra();
        return palavra.length();
    }
}
