package ProjetoLP;

import java.time.LocalDate;

public class Utilizador {
    private String nomeUtilizador;
    private LocalDate dataNascimento;
    private String especializacao;



    public Utilizador(String nomeUtilizador, LocalDate dataNascimento,String especializacao) {
        this.nomeUtilizador = nomeUtilizador;
        this.dataNascimento = dataNascimento;
        this.especializacao = especializacao;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeUtilizador +
                "\nData de nascimento: " + dataNascimento +
                "\nEspecializacao: " + especializacao + "\n";
    }
}


//    public void setDataNascimento(int ano, int mês, int dia) {
//        this.dataNascimento = ano + mês + dia;
//    }

