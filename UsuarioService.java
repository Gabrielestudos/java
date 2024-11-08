import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final String ARQUIVO = "usuarios.txt";

    
    public void salvarUsuario(Usuario usuario) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(usuario.toString());
            writer.newLine();
        }
    }

    
    public List<Usuario> listarUsuarios() throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                usuarios.add(Usuario.fromString(linha));
            }
        }
        return usuarios;
    }
}
