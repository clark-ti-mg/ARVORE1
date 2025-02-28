public class BSTree {
    Node raiz = null;
    public void inserir (Node no, Aluno aluno){
        if (no!=null){
            if (aluno.getMatricula() < no.aluno.getMatricula()){
                if (no.esquerda != null)
                    inserir(no.esquerda, aluno);
                else
                    no.esquerda = new Node(aluno);
            }else{
                if (no.direita!=null)
                    inserir(no.direita, aluno);
                else
                    no.direita = new Node(aluno);
            }
        } else {
            raiz = new Node(aluno);
        }
    }
    public Node remover(Aluno aluno) throws Exception{
        return remover(this.raiz,aluno);
    }
    private Node remover(Node no, Aluno aluno)throws Exception{
        boolean ajuste = false;
        if (no == null) throw new Exception("Valor não encontrado");
        if (this.raiz == null) throw new Exception("Árvore vazia");
        else{
            if (aluno.getMatricula() < no.aluno.getMatricula()){
                no.esquerda = remover(no.esquerda,aluno);
            } else if (aluno.getMatricula() > no.aluno.getMatricula()){
                no.direita = remover(no.direita,aluno);
            } else { // achamos
                // Se ele tiver dois filhos
                if (no.direita!= null && no.esquerda!=null){
                    // O substituto será o menor da arvore direita (sucessor)
                    no.aluno = minimo(no.direita).aluno; 
                    // Removemos o mínimo da subarvore da direita
                    // Que agora é a raiz desa subarvrore
                    no.direita = removeMinimo(no.direita);
                } else { // ele só tem um filho, o filho o substitui
                    // Caso o no seja a raiz com filho só para um lado
                    // Precisamos atualizar o ponteiro da raiz
                    if (no == raiz){
                        ajuste = true;
                    }
                    no = (no.esquerda!=null) ? no.esquerda : no.direita;
                    if (ajuste) raiz = no;
                }
            }
            return no;
        }
    }
    // retorna o menor no de uma subarvore
    private Node minimo(Node no) throws Exception{
        if (no==null)
            throw new Exception ("Raiz nula");
        if (no.esquerda!=null)
            return minimo(no.esquerda);
        else
            return no;
    }

    private Node maximo(Node no) throws Exception{
        if (no==null)
            throw new Exception ("Raiz nula");
        if (no.direita!=null)
            return maximo(no.direita);
        else
            return no;
    }
    // Remove o menor no de uma subarvore
    private Node removeMinimo(Node no)throws Exception{
        if (no == null) 
            throw new Exception("Raiz nula");
        else 
            if (no.esquerda!=null){
                no.esquerda = (removeMinimo(no.esquerda));
                return no;
            }else{
                return no.direita;
            }
    }

    public void preOrdem (Node no){
        if (no!=null){
            System.out.print(no.aluno.matricula + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
    public void inOrdem(Node no){
        if (no!=null){
            inOrdem(no.esquerda);
            System.out.print(no + " ");
            inOrdem(no.direita);
        }
    }
    public void posOrdem(Node no){
        if (no!=null){
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no + " ");
        }
    }

    public boolean encontreNaArvore(int matricula){
        Node no = raiz;

        boolean achou = false;
        while(no!=null){
            if(no.aluno.matricula == matricula){
                achou = true;
                break;
            }else{
                if(no.aluno.matricula > matricula){
                    no = no.direita;
                }else{
                    no = no.esquerda;
                }
            }
        }
        
        return achou;
        
    }

}
