public class Maquina {
    private String numeroSerial;
    private int patrimonio;
    private String modelo;
    private int ano;
    private String marca;
    private String entrada;
    private String saida;

    public Maquina(String numeroSerial, int patrimonio, String modelo, int ano, String marca, String entrada,
            String saida) {
        this.numeroSerial = numeroSerial;
        this.patrimonio = patrimonio;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Máquina {" +
                "\n  Número de Serial = " + numeroSerial +
                "\n  Patrimônio       = " + patrimonio +
                "\n  Modelo           = " + modelo +
                "\n  Ano              = " + ano +
                "\n  Marca            = " + marca +
                "\n  Entrada          = " + entrada +
                "\n  Saída            = " + saida +
                "\n}";
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getMarca() {
        return marca;
    }

    public String setMarca(String marca) {
        return this.marca = marca;
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}