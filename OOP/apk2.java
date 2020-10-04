import java.util.*;
import Controllers.CadastroController;
import Controllers.MenuController;
import Models.Cliente;
import Views.CadastroTitulo;
import Views.Menu;

public class apk2 {
    private static Set<Cliente> listaClientes = new HashSet<Cliente>();
    public static void main(String[] args) {
        new MenuController(listaClientes);
    }
}
