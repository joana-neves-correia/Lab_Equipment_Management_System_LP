package ProjetoLP;

public class Medicao extends Equipamento {

    private Unidades unidade;
    private float valorAtual;

    public Medicao(String nome) {
        super(nome);
    }

    public float getValor() {
        return valorAtual;
    }

    public Unidades getUnidade() {
        return unidade;
    }

    public boolean setValor(float valor) {
        switch(unidade){

            case TEMPERATURA:
                valorAtual = valor;
                return true;

            case MASSA:
                if(valor >0){
                    valorAtual = valor;
                    return true;
                } else {
                    System.out.println("Valor inválido, a massa deverá ser um valor positivo.");
                    return false;
                }

            case VOLUME:
                if (valor >= 0){
                    valorAtual = valor;
                    return true;
                } else {
                    System.out.println("Valor inválido, o volume deverá ser um valor positivo.");
                    return false;
                }

            case PH:
                if(valor >= 0 && valor <= 14){
                    valorAtual = valor;
                    return true;
                } else {
                    System.out.println("Valor inválido, o pH deverá ser um valor entre 0 e 14.");
                    return false;
                }
            default:
                System.out.println("Unidade desconhecida.");
        }
        return false;
    }

    public void setUnidade(Unidades unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Unidades: " + unidade.getDescricaoUnidade() +
                "\n Último valor medido: " + valorAtual;
    }
}
