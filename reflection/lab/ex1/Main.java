package reflection.lab.ex1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Class<?> clazz = Class.forName("Name")
        Class<Reflection> clazz = Reflection.class;

        //Class Type
        System.out.println(clazz);

        //Super (Base) class type
        System.out.println(clazz.getSuperclass());

        //All interfaces implemented by the class
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces){
            System.out.println(anInterface);
        }

        //Instatanate object
        //getDeclaredConstructor()  throws IllegalAccessException
        //newInstance() throws InstantiationException
        Object reflectionObject = clazz.getDeclaredConstructor()
                .newInstance();

        System.out.println(reflectionObject);

    }
}
