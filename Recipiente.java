package ProjetoLP;

public class Recipiente extends Equipamento{
    private int volume;
    private Material material;
    private boolean esteril;

    public Recipiente(String nome){
        super(nome);
    }

    public boolean setVolume(int volume) {
        if (volume > 0) {
            this.volume = volume;
            return true;
        } else {
            System.out.println("Volume tem que ser maior que 0.");
            return false;
        }
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setEsteril(boolean esteril) {
        this.esteril = esteril;
        if(!esteril) {
            System.out.println("Recipiente não estéril, colocado em manutenção.");
            this.setEstado(Estados.MANUTENCAO);
        }
    }

    public int getVolume() {return volume;}

    public Material getMaterial() {return material;}

    public boolean getEsteril() {
        return esteril;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Volume (mL): " + volume +
                "\n Material: " + material +
                "\n Esteril: " + (esteril ? "Sim": "Não");
    }
}
