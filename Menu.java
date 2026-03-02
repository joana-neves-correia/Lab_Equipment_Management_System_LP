package ProjetoLP;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        String ficheiro = "C:\\Users\\joana\\OneDrive\\Documentos\\Bioinformática\\2.LP - Linguagens de Programação\\Projeto\\utilizadores.txt";

        Scanner scanner = new Scanner(System.in);
        GestaoEquipamentos main = new GestaoEquipamentos(scanner);
        Estatisticas main2 = new Estatisticas(main);

        main.listaDeUtilizadores(ficheiro);

        int opcao;

        do {
            System.out.println("\n1 : Adicionar um novo equipamento ");
            System.out.println("2 : Editar equipamento");
            System.out.println("3 : Remover equipamento");
            System.out.println("4 : Pesquisar equipamento");
            System.out.println("5 : Mostrar todos os equipamentos");
            System.out.println("6 : Aluguer de equipamentos");
            System.out.println("7 : Imprimir lista de equipamentos");
            System.out.println("8 : Mostrar informações sobre o sistema");
            System.out.println("9 : Sair");
            System.out.print("\n Selecione uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: //adicionar equipamento
                    System.out.println("\n1 : Eletrónico");
                    System.out.println("2 : Recipiente");
                    System.out.println("3 : Medição");
                    System.out.println("4 : Voltar ao menu anterior ");
                    System.out.print("\nSelecione uma opção: ");

                    int opcao2;
                    opcao2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao2){
                        case 1: //adicionar equipamento Eletrónico
                            main.adicionarEquipamentoEletronico();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 2://adicionar equipamento Recipiente
                            main.adicionarEquipamentoRecipiente();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 3://adicionar equipamento Medição
                            main.adicionarEquipamentoMedicao();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 4: //voltar ao menu anterior
                            break;

                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 2: //editar equipamento
                    System.out.print("\nInsira o ID do equipamento: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    main.editarEquipamento(id);
                    break;

                case 3: //remover equipamento
                    System.out.print("\nInsira o ID do equipamento a eliminar: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    main.eliminarEquipamento(id);
                    System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                    scanner.nextLine();
                    break;

                case 4: //pesquisar equipamento
                    System.out.print("\nInsira o ID do equipamento: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    main.procurarID(id);
                    System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                    scanner.nextLine();
                    break;

                case 5: //mostrar todos os equipamentos
                    System.out.println("");
                    main.listarEquipamentos();
                    break;

                case 6: //alugar equipamento
                    System.out.println("\n1 : Alugar equipamento");
                    System.out.println("2 : Devolver equipamento");
                    System.out.println("3 : Voltar ao menu anterior ");
                    System.out.print("\nSelecione uma opção: ");

                    int opcao3;
                    opcao3 = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao3){
                        case 1://alugar equipamento
                            System.out.print("\nInsira o ID do equipamento a alugar: ");
                            int ID = scanner.nextInt();
                            scanner.nextLine();
                            main.alugarEquipamento(ID);
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 2://devolver equipamento
                            System.out.print("\nInsira o ID do equipamento a devolver: ");
                            int e = scanner.nextInt();
                            scanner.nextLine();
                            main.devolverEquipamento(e);
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 3://voltar ao menu anterior
                            break;

                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 7: //imprimir a lista
                    System.out.println("\n1 : Imprimir lista sem detalhes");
                    System.out.println("2 : Imprimir a lista com todos os detalhes");
                    System.out.println("3 : Voltar ao menu anterior");
                    System.out.print("\nSelecione uma opção: ");
                    int o = scanner.nextInt();
                    scanner.nextLine();

                    switch (o){

                        case 1:
                            System.out.print("Insira um nome para o ficheiro a ser impresso: ");
                            String file = scanner.nextLine();
                            main.gravarFicheiroSimples(file);
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 2:
                            System.out.print("Insira um nome para o ficheiro a ser impresso: ");
                            file = scanner.nextLine();
                            main.gravarFicheiroDetalhado(file);
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 8: //mostrar informações
                    System.out.println("\n1 : Contagem Equipamentos por tipo");
                    System.out.println("2 : Contagem de equipamentos por estado");
                    System.out.println("3 : Equipamento eletrónico de menor consumo");
                    System.out.println("4 : Recipiente com maior volume");
                    System.out.println("5 : Média de temperatura dos equipamentos de medicao de temperatura");
                    System.out.println("6 : Voltar ao menu anterior");
                    System.out.print("\nSelecione uma opção: ");
                    int e = scanner.nextInt();
                    scanner.nextLine();

                    switch (e){
                        case 1:
                            System.out.print("\nEquipamentos eletrónicos: ");
                            main2.numeroEletronico();
                            System.out.print("\nEquipamentos recipientes: ");
                            main2.numeroRecipiente();
                            System.out.print("\nEquipamentos medição: ");
                            main2.numeroMedicao();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 2:
                            System.out.print("\nEquipamentos ativos: ");
                            main2.numeroAtivos();
                            System.out.print("\nEquipamentos inativos: ");
                            main2.numeroInativos();
                            System.out.print("\nEquipamentos manutenção: ");
                            main2.numeroManutencao();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 3:
                            main2.menorConsumo();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 4:
                            main2.maiorVolume();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 5:
                            main2.mediaTemperatura();
                            System.out.println("\nPressione Enter para voltar ao Menu inicial.");
                            scanner.nextLine();
                            break;

                        case 6:
                            break;

                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 9: //sair
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        } while (opcao != 9);
    }
}

