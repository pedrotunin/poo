package criptografia;

public class ZenitPolar implements Cifra {
    
    private char zenitPolar(char letra) {

        switch (letra) {
            case 'z':
                return 'p';
            case 'e':
                return 'o';
            case 'n':
                return 'l';
            case 'i':
                return 'a';
            case 't':
                return 'r';
            case 'p':
                return 'z';
            case 'o':
                return 'e';
            case 'l':
                return 'n';
            case 'a':
                return 'i';
            case 'r':
                return 't';
            default:
                return letra;
        }

    }

    public String cifrar(String mensagem) {

        String cifrada = "";

        for (int i = 0; i < mensagem.length(); i++) 
            cifrada += this.zenitPolar(mensagem.charAt(i));
            
        return cifrada;
        
    }

    public String decifrar(String mensagem) {
        return this.cifrar(mensagem);
    }

}
