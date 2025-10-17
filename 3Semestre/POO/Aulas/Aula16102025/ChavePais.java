
import java.util.Objects;

public class ChavePais {
    String nome;
    int posicao;

    public ChavePais(String nome, int posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public boolean ehOuro() {
        return posicao == 1;
    }

    public boolean ehPrata() {
        return posicao == 2;
    }

    public boolean ehBronze() {
        return posicao == 3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChavePais other = (ChavePais) obj;
        return Objects.equals(this.nome, other.nome);
    };

};
