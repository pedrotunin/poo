import java.util.Scanner;
import acesso.Usuario;
import acesso.Impressao;
import acesso.UsuarioBloqueado;
import acesso.SenhaInvalida;

public class AutenticacaoUsuario {

    public static Usuario encontraUsuario(String login, Usuario[] usuarios) {

        for (int i = 0; i < usuarios.length; i++) {

            if (usuarios[i].getLogin().equals(login)) {
                return usuarios[i];
            }

        }
        return null;
    }
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();

        String login, senha;

        Usuario[] usuarios = new Usuario[n];

        for (int i = 0; i < n; i++) {

            login = leitor.next();
            senha = leitor.next();

            usuarios[i] = new Usuario(login, senha);

        }

        int k = leitor.nextInt();
        Usuario usuario;

        for (int i = 0; i < k; i++) {

            login = leitor.next();
            senha = leitor.next();

            usuario = encontraUsuario(login, usuarios);

            try {

                 usuario.autenticar(senha);

                 Impressao.imprimirUsuarioAutenticado(login);

            } catch (SenhaInvalida e) {

                String l = e.getLogin();

                Impressao.imprimirSenhaInvalida(l);

            } catch (UsuarioBloqueado e) {

                String l = e.getLogin();

                Impressao.imprimirUsuarioBloqueado(l);
            }

        }

    }
}