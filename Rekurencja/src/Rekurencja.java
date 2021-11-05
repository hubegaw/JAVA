class doReccurency {
    String str;

    doReccurency(String s) {
        str = s;
    }

    void backward(int index) {
        if(index != str.length() - 1) backward(index + 1);

        System.out.print(str.charAt(index));
    }
}

public class Rekurencja {
    public static void main(String[] args) {
        doReccurency s = new doReccurency("To jest test");

        s.backward(0);
    }
}
