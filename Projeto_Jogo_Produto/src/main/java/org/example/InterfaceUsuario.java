package org.example;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    ProdutoDAO dao;
    JogoDAO dao1;
    Scanner in;

    public InterfaceUsuario(ProdutoDAO dao, JogoDAO dao1) {
        this.dao = dao;
        this.dao1=dao1;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        int opc = 0;
        do{
            System.out.println("\n==============");
            System.out.println("==== Categorias ====");
            System.out.println("==============");
            System.out.println("\t1. Mostrar menu dos Produtos ");
            System.out.println("\t2. Mostrar Menu dos Jogos");
            System.out.println("\t3. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();
            switch (opc) {
                case 1:
                    this.imprimirMenuProduto();
                    break;
                case 2:
                   this.menuJogos();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }
        while (opc != 3);


    }

    private void imprimirMenuProduto() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Inserir produto");
            System.out.println("\t2. Mostrar produtos");
            System.out.println("\t3. Atualizar produtos");
            System.out.println("\t4. Deletar produtos");
            System.out.println("\t5. Buscar produto por marca");
            System.out.println("\t6. Buscar produto por nome");
            System.out.println("\t7. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.criarProduto();
                    break;
                case 2:
                    this.mostrarProduto();
                    break;
                case 3:
                    this.atualizarProduto();
                    break;
                case 4:
                    this.deletarProduto();
                    break;
                case 5:
                    this.readMarca();
                    break;
                case 6:
                    this.readNome();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 7);
    }

    private void menuJogos() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Inserir jogo");
            System.out.println("\t2. Mostrar jogos");
            System.out.println("\t3. Atualizar os jogos");
            System.out.println("\t4. Deletar jogo");
            System.out.println("\t5. Buscar jogo por ID");
            System.out.println("\t6. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.criarJogo();
                    break;
                case 2:
                    this.mostrarJogos();
                    break;
                case 3:
                    this.atualizarJogo();
                    break;
                case 4:
                    this.deletarJogo();
                    break;
                case 5:
                    this.readId();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 6);
    }

    private void criarProduto() {
        Produto produto = new Produto();

        System.out.println("\n******************");
        System.out.println("*** Novo Produto ***");
        System.out.println("******************");

        System.out.print("\nInforme o codigo do produto: ");
        produto.setId(in.nextLine());

        System.out.print("Informe o nome do produto: ");
        produto.setDescricao(in.nextLine());

        System.out.print("Informe a marca do produto: ");
        produto.setMarca(in.nextLine());

        System.out.print("Informe o preço do produto: ");
        produto.setPreco(in.nextFloat());

        if (dao.create(produto)) {
            System.out.println("Produto adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o aluno");
        }
    }

    private void criarJogo() {
        Jogo jogo = new Jogo();

        System.out.println("\n******************");
        System.out.println("*** Novo Jogo ***");
        System.out.println("******************");

        System.out.print("\nInforme o nome do jogo: ");
        jogo.setId(in.nextLine());

        System.out.print("Informe o nome do primeiro time: ");
        jogo.setNomeTimeA(in.nextLine());

        System.out.print("Informe o nome do segundo time : ");
        jogo.setNomeTimeB(in.nextLine());

        System.out.print("Informe quantos gols o primeiro time marcou: ");
        jogo.setGolsTimeA(in.nextInt());

        System.out.print("Informe quantos gols o segundo time marcou: ");
        jogo.setGolsTimeB(in.nextInt());

        if (dao1.create(jogo)) {
            System.out.println("O jogo foi adicionado ao banco de Dados!");
        } else {
            System.out.println("Ops: problema ao adicionar o aluno!");
        }
    }

    private void mostrarProduto() {
        List<Produto> produtos = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Produtos Cadastrados ***");
        System.out.println("***********************************");
        for(Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private void mostrarJogos() {
        List<Jogo> jogos = dao1.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Jogos Registrados ***");
        System.out.println("***********************************");
        for(Jogo jogo : jogos) {
            System.out.println(jogo);
        }
    }

    private void deletarProduto() {
        List<Produto> produtos = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Produto produto : produtos) {
                System.out.println(i + " - " + produto);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual produto deseja remover? ");
            int opc = in.nextInt();

            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(produtos.get(opc))) {
                    System.out.println("Produto " + produtos.get(opc).getDescricao() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                break;
            }
        }
    }

    private void deletarJogo() {
        List<Jogo> jogos = dao1.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Jogos Registrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Jogo jogo : jogos) {
                System.out.println(i + " - " + jogo);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual jogo deseja remover? ");
            int opc = in.nextInt();

            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= jogos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao1.delete(jogos.get(opc))) {
                    System.out.println("Produto " + jogos.get(opc).getId() + " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                break;
            }
        }
    }

    private void atualizarProduto() {
        List<Produto> produtos = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Produto produto : produtos) {
                System.out.println(i + " - " + produto);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual produto deseja atualizar? ");
            int opc = in.nextInt();

            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                Produto produto = new Produto();

                System.out.println("\n******************");
                System.out.println("*** Atualizar produto ***");
                System.out.println("******************");

                produto.setId(produtos.get(opc).getId());

                System.out.print("Informe o nome do produto: ");
                produto.setDescricao(in.nextLine());

                System.out.print("Informe a marca do produto: ");
                produto.setMarca(in.nextLine());

                System.out.print("Informe o preço do produto: ");
                produto.setPreco(in.nextFloat());

                if (dao.update(produto)) {
                    System.out.println("Produto atualizado com sucesso no banco de Dados");
                } else {
                    System.out.println("Ops: problema ao atualizar o produto");
                }
                break;
            }
        }
    }

    private void atualizarJogo() {
        List<Jogo> jogos = dao1.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Jogos Registrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Jogo jogo : jogos) {
                System.out.println(i + " - " + jogo);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual jogo deseja atualizar? ");
            int opc = in.nextInt();

            in.nextLine();

            if (opc==i) {

                break;
            }

            if (opc >= jogos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                Jogo jogo = new Jogo();

                System.out.println("\n******************");
                System.out.println("*** Atualizar jogo ***");
                System.out.println("******************");

                jogo.setId(jogos.get(opc).getId());

                System.out.print("Informe o placar novo do primeiro time: ");
                jogo.setGolsTimeA(in.nextInt());

                System.out.print("Informe o placar novo do segundo time: ");
                jogo.setGolsTimeB(in.nextInt());

                if (dao1.update(jogo)) {
                    System.out.println("Jogo atualizado com sucesso no banco de Dados!");
                } else {
                    System.out.println("Ops: problema ao atualizar o produto!");
                }
                break;
            }
        }
    }

    private void readMarca() {
        Produto produto = new Produto();
        System.out.print("\nInforme a marca do produto: ");
        produto.setMarca(in.nextLine());

        System.out.println("\n***********************************");
        System.out.println("*** Produtos da marca ***");
        System.out.println("***********************************");

        dao.readMarca(produto);

    }

    private void readNome() {
        Produto produto = new Produto();
        System.out.print("\nInforme o nome do produto que deseja procurar: ");
        produto.setDescricao(in.nextLine());
        System.out.println("\n***********************************");
        System.out.println("*** Produtos cadastrados ***");
        System.out.println("***********************************");
        dao.readNome(produto);

    }

    private void readId() {
        Jogo jogo = new Jogo();
        System.out.print("\nInforme o jogo que deseja procurar pelo ID: ");
        jogo.setId(in.nextLine());
        System.out.println("\n***********************************");
        System.out.println("*** Jogos Registrados ***");
        System.out.println("***********************************");
        dao1.readId(jogo);

    }
}
