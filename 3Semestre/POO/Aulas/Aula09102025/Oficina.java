import java.util.HashMap;
import java.util.Map;

public class Oficina {
    Map<Integer, Mecanica> mecanicos = new HashMap<Integer, Mecanica>();

    public void adicionaMecanico(Mecanica m) {
        mecanicos.put(m.getIDPessoa(), m);
    }

    public void liberaAcesso(int id) {
        Mecanica m = mecanicos.get(id);
        if (m.temAcessoPesado()) {
            System.out.println("Acesso pesado");
        } else {
            System.out.println("Acesso Restrito");
        }
        m.liberaAcessoOficina();
    };
};
