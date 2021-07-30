package criptografia;

public class CifraCesar implements Cifra {

    private int nShifts;

    public CifraCesar(int nShifts) {
        while (nShifts >= 26) nShifts -= 26;
        while (nShifts <= -26) nShifts += 26;
        this.nShifts = nShifts;
    }

    private String cifra(String mensagem, int nShifts) {

        String cifra = "";

        for (int i = 0; i < mensagem.length(); i++) {

            //trata espaços
            if (mensagem.charAt(i) == ' ') {
                cifra += mensagem.charAt(i);
                continue;
            }

            if (((int) mensagem.charAt(i)) + this.nShifts <= 122 && nShifts > 0) {
                char novoChar = (char)(((int) mensagem.charAt(i)) + nShifts);
                cifra += novoChar;
                continue;
            }

            //trata limite direito excedido
            if (((int) mensagem.charAt(i)) + this.nShifts > 122 && nShifts > 0) {

                int novoShift = nShifts - (123 - (int)(mensagem.charAt(i)));
                char novoChar = (char)(97 + novoShift);
                cifra += novoChar;
                continue;

            }

            if (((int) mensagem.charAt(i)) + nShifts >= 97) {
                char novoChar = (char)(((int) mensagem.charAt(i)) + nShifts);
                cifra += novoChar;
                continue;
            }

            //trata limite esquerdo excedido
            if (((int) mensagem.charAt(i)) + nShifts < 97) {

                int novoShift = ((int)(mensagem.charAt(i)) - 96) + nShifts;
                char novoChar = (char)(122 + novoShift);
                cifra += novoChar;
                continue;
            }

        }
        return cifra;

    }

    public String cifrar(String mensagem) {

        return this.cifra(mensagem, this.nShifts);

    }

    public String decifrar(String mensagem) {

        return this.cifra(mensagem, -1 * this.nShifts);
  
    }

}