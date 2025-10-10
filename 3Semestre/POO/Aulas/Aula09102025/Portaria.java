
import java.util.HashMap;
import java.util.Map;

public class Portaria {

    Map<Integer, Pessoa> pessoas = new HashMap();

    public void adicionaPessoa(Pessoa p) {
        pessoas.put(p.getId(), p);
    };

    public void liberaAcesso(int id) {
        pessoas.get(id).liberaAcesso();
    };
};
