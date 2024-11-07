package workingwithabstraction.lab.workingwithabstractionlab;

public record Student (String name, int age, double grade) {
    //Този клас става рекорд, понеже имаше само гетъри
    //и параметрите не се променят никъде, а само се инициализират при
    //създаване на инстанцията
}
