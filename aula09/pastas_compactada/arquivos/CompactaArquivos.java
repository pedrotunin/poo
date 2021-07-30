package arquivos;

import java.util.Scanner;

public class CompactaArquivos {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        PastaCompactada<Texto> pastaTexto = new PastaCompactada<Texto>();
        PastaCompactada<Imagem> pastaImagem = new PastaCompactada<Imagem>();

        int n = leitor.nextInt();

        for (int i = 0; i < n; i++) {

            String tipo = leitor.next();
            
            if (tipo.equals("Texto")){
                Texto novo = new Texto();
                pastaTexto.adicionar(novo);
            }
            
            if (tipo.equals("Imagem")) {
                Imagem novo = new Imagem();
                pastaImagem.adicionar(novo);
            }

            if (tipo.equals("TextoTXT")) {
                TextoTXT novo = new TextoTXT();
                pastaTexto.adicionar(novo);
            }
            
            if (tipo.equals("TextoDOCX")) {
                TextoDOCX novo = new TextoDOCX();
                pastaTexto.adicionar(novo);
            }
            
            if (tipo.equals("ImagemPNG")) {
                ImagemPNG novo = new ImagemPNG();
                pastaImagem.adicionar(novo);
            }
            
            if (tipo.equals("ImagemJPEG")) {
                ImagemJPEG novo = new ImagemJPEG();
                pastaImagem.adicionar(novo);
            }

        }

        pastaTexto.imprimir();
        pastaImagem.imprimir();
        
    }
}