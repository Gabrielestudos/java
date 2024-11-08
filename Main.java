import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Listar usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    Usuario usuario = new Usuario(nome, email, senha);
                    try {
                        usuarioService.salvarUsuario(usuario);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar o usuário: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        List<Usuario> usuarios = usuarioService.listarUsuarios();
                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuário cadastrado.");
                        } else {
                            System.out.println("--- Lista de Usuários ---");
                            usuarios.forEach(System.out::println);
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao listar os usuários: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
