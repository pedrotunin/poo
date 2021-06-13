package aula3.projetoProva;

import aula3.projetoProva.autocorrecao.Alternativa;
import aula3.projetoProva.autocorrecao.Pergunta;
import aula3.projetoProva.autocorrecao.Prova;

public class ProgramaProva {
    public static void main (String args[]) {
        Prova p1 = new Prova(2);

        Pergunta q1 = new Pergunta(3, "Qual o valor de 10 x 10?");
        q1.adicionarAlternativa(true, new Alternativa("100"));
        q1.adicionarAlternativa(false, new Alternativa("1"));
        q1.adicionarAlternativa(false, new Alternativa("10"));

        Pergunta q2 = new Pergunta(2, "Qual o valor de 50 x 50?");
        q2.adicionarAlternativa(false, new Alternativa("5"));
        q2.adicionarAlternativa(true, new Alternativa("2500"));

        p1.adicionarPergunta(q1);
        p1.adicionarPergunta(q2);

        p1.imprimir();
    }
    
}
