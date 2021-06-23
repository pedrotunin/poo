package criptografia;

public class CifraCesar implements Cifra {

    private int nShifts;

    public CifraCesar(int nShifts) {
        while (nShifts >= 26) nShifts -= 26;
        while (nShifts <= -26) nShifts += 26;
        this.nShifts = nShifts;
    }

    public String cifrar(String mensagem) {

        String cifrada;

        for (int i = 0; i < mensagem.length(); i++) {

            //trata espaços
            if (mensagem.charAt(i) == ' ') {
                cifrada += mensagem.chatAt(i);
                continue;
            }

            //trata limite direito excedido
            if (((int) mensagem.charAt(i)) + this.nShifts > 122) {

                char novoC = 97 + 123 + mensagem.charAt(i) - this.nShifts;
                System.out.println(novoC);

            }

            //trata limite esquerdo excedido
            if (((int) mensagem.charAt(i)) + this.nShifts < 97) {



            }

        }
        return cifrada;

    }

    public String decifrar(String mensagem) {



    }

    public static void main(String[] args) {

        CifraCesar c = new CifraCesar(25);

        c.cifrar("b");

    }

}