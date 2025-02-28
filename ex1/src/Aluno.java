public class Aluno {
    int matricula;
    String nome;
    String curso;

    Aluno(int matricula, String nome, String curso){
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setCurso(curso);
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }
}
