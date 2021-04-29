public class FilaCliente {

    private boolean[] preferencia;
    private int[] idCliente;
    private int tamanhoVetor;
    private int posFinal;
    private int id;
    private int cont = 0;

    public FilaCliente(int tamanhoMaximo) {
        this.idCliente = new int[tamanhoMaximo];
        this.preferencia = new boolean[tamanhoMaximo];
        this.tamanhoVetor = tamanhoMaximo;
        this.posFinal = -1;
        this.id = 0;
    }

    public boolean isFull() {

        if (this.posFinal == (this.tamanhoVetor - 1)) {

            return true;

        } else {

            return false;

        }
    }

    public boolean peek() {
        return this.preferencia[0];
    }

    public boolean isEmpty() {
        if (this.posFinal == -1) {

            return true;
        } else {

            return false;
        }
    }

    public void enqueue(boolean preferencia) {
        if (!isFull()) {

            this.idCliente[this.posFinal + 1] = this.id;
            this.preferencia[this.posFinal + 1] = preferencia;
            this.posFinal++;
            this.id++;
        }

    }

    public void enqueue(int id, boolean preferencia) {
        if (!isFull()) {

            this.idCliente[this.posFinal + 1] = id;
            this.preferencia[this.posFinal + 1] = preferencia;
            this.posFinal++;

        }

    }

    public boolean dequeue() {
        if (!isEmpty()) {
            double elemento = this.idCliente[0];
            boolean elementoPref = this.preferencia[0];

            for (int i = 0; i < this.posFinal; i++) {
                this.idCliente[i] = this.idCliente[i + 1];
                this.preferencia[i] = this.preferencia[i + 1];

            }
            this.posFinal--;

            return elementoPref;
        } else {
            System.out.println("\nA fila está vazia, espere um novo cliente\n\n");

            return false;
        }

    }

    public void imprimeFila() {
        if (isEmpty()) {
            System.out.println("\nvazia\n\n");
        } else {
            System.out.println("--------------------------");
            for (int i = 0; i <= this.posFinal; i++) {
                System.out.printf("\nCliente" + (i + 1) + " = " + this.idCliente[i] + " | ");

                if (this.preferencia[i] == true) {

                    System.out.printf("PREFERENCIAL");

                } else {

                    System.out.printf("NORMAL");

                }
            }
            System.out.printf("\n--------------------------\n");
        }
    }

    public void proximoCliente() {
        boolean pref;
        int chamou = 0;
        if (this.cont == 3) {
            pref = false;
            cont = 0;
        } else {
            pref = true;
            cont++;
        }
        for (int i = 0; i <= this.posFinal; i++) {
            if (peek() == pref) {
                dequeue();
                chamou = 1;
                System.out.printf("\nVocê chamou o cliente de senha: " + this.idCliente[0]);

                if (pref == true) {
                    System.out.printf(" ele é um cliente preferencial \n\n");
                } else {
                    System.out.printf(" ele é um cliente normal\n\n");
                }
                for (int j = i; j <= this.posFinal; j++) {
                    enqueue(this.idCliente[0], dequeue());
                }
                
                break;
            } else {
                enqueue(this.idCliente[0], dequeue());
            }
        }
        if (chamou == 0) {
            dequeue();
            System.out.printf("\nVocê chamou o cliente de senha: " + this.idCliente[0]);

            if (this.preferencia[0] == true) {
                System.out.printf(" ele é um cliente preferencial\n\n");
            } else {
                System.out.printf(" ele é um cliente normal\n\n");
            }
        }

    }

}