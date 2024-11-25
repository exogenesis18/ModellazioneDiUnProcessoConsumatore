# ModellazioneDiUnProcessoConsumatore

### Struttura del progetto
- **classes**:
   - Queue.java -> classe che implementa l'interfaccia IQueue
   - Request.java -> classe che implementa l'interfaccia IRequest
- **interfaces**:
   - IQueue.java -> interfaccia della classe Queue data alla consegna
   - IRequest.java -> interfaccia data classe Request data alla consegna
- **enumerations**:
   - Priority.java -> enumerazione di priorità (Alta o Bassa) data alla consegna
- **main**:
   - Main.java -> classe di main per eseguire una simulazione
 
### Spiegazione dell'algoritmo
Immaginiamo di avere una coda di processi con priorità bassa (blu) e con priorità alta (rossi), per semplicità il numero del processo corrisponde all'ordine di creazione dello stesso (nel codice non ho utilizzato numeri ma timestamp di creazione)

![image](https://github.com/user-attachments/assets/dc3679b1-e3b3-4e4c-80f5-4644d2233b32)

Una volta inseriti nella Queue, vengono automaticamente ordinati, nel caso venga chiamata la funzione di pop, l'ultimo elemento della lista è quello preso in considerazione

![image](https://github.com/user-attachments/assets/f19f6874-4f8e-4c1e-a0dd-e22de21bb903)

Quando la pop() inerente ad un processo ad alta priorità viene eseguita, viene incrementato un contatore che conta quante volte di seguito viene eseguito un processo ad alta priorità

![image](https://github.com/user-attachments/assets/20df598e-507c-4a90-a9c1-c0d85fd70cec)

![image](https://github.com/user-attachments/assets/b4cdcf2b-5f7b-4caf-a164-1a2dccbf4a2b)


Ad un certo punto potremmo arrivare ad avere una combinazione di 4 processi ad alta priorità eseguiti di fila, in questo caso per evitare il fenomeno di starvation dei processi a bassa priorità, inverteremo il peso delle priorità cosicchè l'ultimo processo in lista sarà uno a bassa priorità (se presente)

![image](https://github.com/user-attachments/assets/f9efd34c-b9bf-4d95-bc88-2b7785e095b4)

Una volta eseguita la pop() di un processo a bassa priorità il contatore viene azzerato ed il sorting viene ripristinato e quindi verranno di nuovo eseguiti i processi ad alta priorità se presenti

![image](https://github.com/user-attachments/assets/2b5e42e5-3ea3-4340-9ce8-6a709ad98aa2)

![image](https://github.com/user-attachments/assets/25cd33c1-42ce-49b0-a8e2-6b23c4bb74d8)

![image](https://github.com/user-attachments/assets/d0d1f579-ebba-4041-81c0-3e125bd894a5)

### Istruzioni di compilazione

E' sufficiente clonare la repository e runnare la classe Main.java, per compilare questo codice è necessario avere installato almeno Java 1.8 dato che per implementare il sorting ho utilizzato una Lambda







