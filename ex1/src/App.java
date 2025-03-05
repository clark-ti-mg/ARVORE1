import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int matricula;
        String nome, curso;

        BSTree bst = new BSTree();

        int tam = 0;

        try {
            while (tam < 10) {
                System.out.println("--------------------------------------------");
                System.out.println("Aluno " + tam);

                System.out.println("Nome do aluno:");
                nome = teclado.nextLine();

                System.out.println("Curso do aluno:");
                curso = teclado.nextLine();

                System.out.println("Matrícula: ");
                matricula = teclado.nextInt();

                Aluno aluno = new Aluno(matricula, nome, curso);

                bst.inserir(bst.raiz, aluno);
                teclado.nextLine();
                tam++;
            }
        } catch (Exception e) {
            System.out.println("Exceção ao capturar os dados: " + e.getMessage());
        }

        try {
            bst.preOrdem(bst.raiz);
        } catch (Exception e) {
            System.out.println("Exceção ao exibir os dados: " + e.getMessage());
        }

        System.out.println("Aluno com maior matrícula na árvore: ");
        System.out.println(bst.maximo(bst.raiz).aluno.matricula);

        System.out.println("Qual matrícula quer achar na árvore?");
        try {
            int matriculaBusca = teclado.nextInt();

            if (bst.encontreNaArvore(matriculaBusca)) {
                System.out.println("Aluno cadastrado.");
            } else {
                System.out.println("Aluno não cadastrado.");
            }
        } catch (Exception e) {
            System.out.println("Exceção ao capturar matrícula: " + e.getMessage());
        }

    }
}
