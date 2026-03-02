package ProjetoLP;

public enum Unidades {
    TEMPERATURA ("ºC"),
    MASSA ("g"),
    VOLUME ("mL"),
    PH ("pH");

    private final String descricaoUnidade;

    Unidades(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }
}
