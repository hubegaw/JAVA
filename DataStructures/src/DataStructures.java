class Queue {
    private int queue[];
    private int putloc, getloc;

    Queue(int size) { // tworzy pustą kolejke o podanym rozmiarze
        queue = new int[size];
        putloc = getloc = 0;
    }

    Queue(Queue object) { // tworzy obiekt na podstawie innego obiektu
        putloc =  object.putloc;
        getloc = object.getloc;
        queue = new int[object.queue.length];

        for(int i = 0; i < putloc; i++) {
            queue[i] = object.queue[i];
        }
    }

    Queue(int tab[]) { // tworzy kolejke i umieszcza w niej elementy
        putloc = getloc = 0;
        queue = new int[tab.length];

        for(int i = 0; i <tab.length; i++) {
            put(tab[i]);
        }
    }

    void put(int x) {
        if(putloc == queue.length) {
            System.out.println(" -- Kolejka jest pełna!");
            return;
        }
        queue[putloc++] = x;
    }

    int get() {
        if(getloc == putloc) {
            System.out.println(" -- Kolejka jest pusta!");
            return (int) 0;
        }
        return queue[getloc++];
    }

}

class Stack {
    private int stack[];
    private int max;

    Stack(int size) {
        stack = new int[size];
        max = 0;
    }

    Stack(Stack Object) {
        max = Object.max;
        stack = new int[Object.stack.length];

        for(int i = 0; i < max; i++) {
            stack[i] = Object.stack[i];
        }
    }

    Stack(int a[]) {
        stack = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            push(a[i]);
        }
    }

    void push(int x) {
        if(max == stack.length) {
            System.out.println(" -- Stos jest pełny!");
            return;
        }
        stack[max] = x;
        max++;
    }

    int pop() {
        if(max == 0) {
            System.out.println(" -- Stos jest pusty!");
            return (int) 0;
        }
        max--;
        return stack[max];
    }
}

public class DataStructures {
    public static void main(String[] args) throws java.io.IOException {

        int number, size;

        System.out.print("Podaj wielkość stosu/kolejki: ");
        size = System.in.read();

        Stack StackObject = new Stack(size);

        Queue QueueObject = new Queue(size);

        StackObject.push(3);
        StackObject.push(14);
        Stack StackObject2 = new Stack(StackObject);
        for(int i = 0; i < 2; i++) {
            number = StackObject.pop();
            System.out.println(number);
        }

        System.out.println("Stos stworzony na podstawie innego stosu:");
        for(int i = 0; i < 2; i++) {
            number = StackObject2.pop();
            System.out.println(number);
        }
    }
}
