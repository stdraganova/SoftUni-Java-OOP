package polymorphism.lab.mathoperation;

public class MathOperation {

    //Когато един клас няма полета и съответно няма конструктор
    //от него не може да се създава инстанция.
    //Това ни позволява, методите в този клас да бъдат статик
    //понеже тези методи не са зависими от инстанциите на класа

    //Compile Polymorphism - Methode overloading

    //1 way
    public static int add(int a, int b) {
        return  a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }


    //2 way - the Good practice
//    public static int add(int a, int b) {
//        return a + b;
//    }
//
//    public static int add(add(a, b), int c) {
//        return add(a, b) + c;
//    }
//
//    public static int add(add(a, b), add(c, d)) {
//        return add(a, b) + add(c,d);
//    }
}
