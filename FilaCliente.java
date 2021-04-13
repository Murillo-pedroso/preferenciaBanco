public class FilaCliente {

    private boolean[] preferencia;
    private int[] dados;
    private int tamanhoVetor;
    private int posFinal;
  
  
    public FilaCliente(int tamanhoMaximo){
        this.dados = new int[tamanhoMaximo];
        this.preferencia = new boolean[tamanhoMaximo];
        this.tamanhoVetor = tamanhoMaximo;
        this.posFinal = -1;
    }
  
  
    public void destroyFila() {
      this.dados = null;
      System.gc();
    }
  
    public boolean isFull() {
      if(this.posFinal == (this.tamanhoVetor - 1)) {
        //System.out.println("cheia");
        return true;
      }
      else {
       // System.out.println("não cheia");
        return false;
      }
    }
  
    public boolean isEmpty() {
      if (this.posFinal == -1) {
        //System.out.println("vazia");
        return true;
      }
      else {
        //System.out.println("não vazia");
        return false;
      }
    }
  
  
    public void Enqueue(int valor,boolean preferencia) {
      if (!isFull()) {
        this.dados[this.posFinal + 1] = valor;
        this.preferencia[this.posFinal + 1] = preferencia;
        this.posFinal++;
      }
      
    }
  
  
    public double Dequeue() {
      if(!isEmpty()) {
        double elemento = this.dados[0];
        boolean elementoPref = this.preferencia[0];
  
        for (int i = 0; i < this.posFinal; i++) {
           this.dados[i] = this.dados[i+1]; 
           this.preferencia[i] = this.preferencia[i+1]; 

        }
        this.posFinal--;
        System.out.printf("\nVocê chamou o cliente de senha: "+elemento);
        if(elementoPref == true){
            System.out.printf(" ele é um cliente preferencial\n\n");
           }else{
            System.out.printf(" ele é um cliente normal\n\n");
        }

        return 0;
      }else{
         System.out.println("\nA fila está vazia, espere um novo cliente\n\n");
        return 0;
        }
    }
  
   public void imprimeFila() {
    if(isEmpty()) {
      System.out.println("\nvazia\n\n");
    }
    else {
     System.out.println("--------------------------");
     for (int i = 0; i <= this.posFinal; i++ ) {
       System.out.printf("\nElemento [" + i + "] = " + this.dados[i] + " | ");

       if(this.preferencia[i] == true){
        System.out.printf("PREFERENCIAL");
       }else{
        System.out.printf("NORMAL");
       }
     }
    System.out.printf("\n--------------------------\n");
    }
   }
     
  
  
  
  }