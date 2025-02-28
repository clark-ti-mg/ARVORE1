public class Node {
    Aluno aluno;
    Node esquerda;
    Node direita;
    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.esquerda = null;
        this.direita = null;
    }
    @Override
    public String toString(){
        return String.valueOf(this.aluno);
    }
}