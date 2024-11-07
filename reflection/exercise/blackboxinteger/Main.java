package reflection.exercise.blackboxinteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        Field innerValueField = clazz.getDeclaredField("innerValue");
        innerValueField.setAccessible(true);

        String[] command = scanner.nextLine().split("_");

        while (!command[0].equals("END")) {

            String methodName = command[0];
            int value = Integer.parseInt(command[1]);

            invoceMethodByName(methodName, value, blackBoxInt, clazz);
            //Срещу това поле в този конкретен обект, каква е стойността
            System.out.println(innerValueField.get(blackBoxInt));

            command = scanner.nextLine().split("_");
        }


    }

    private static void invoceMethodByName(String methodName, int value, BlackBoxInt blackBoxInt, Class<BlackBoxInt> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = clazz.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, value);
    }
}
