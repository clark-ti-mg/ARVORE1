import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int matricula;
        String nome, curso;

        BSTree bst = new BSTree();
        
        int tam = 0;

        try {
            while(tam < 10){
                System.out.println("--------------------------------------------");
                System.out.println("Aluno " + tam);

                System.out.println("Nome do aluno:");
                nome = teclado.nextLine();
    
                System.out.println("Curso do aluno:");
                curso =  teclado.nextLine();
              
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

    }
}
