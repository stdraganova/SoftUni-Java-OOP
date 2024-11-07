package reflection.exercise.harvestingfields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//Starting Reflection
		Class<RichSoilLand> clazz = RichSoilLand.class;

		Field[] declaredFields = clazz.getDeclaredFields();

		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {

			switch (command) {
				case "private" -> {
					Arrays.stream(declaredFields).filter(field -> Modifier.isPrivate(field.getModifiers()))
							.forEach(field -> {
								System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " +field.getName());
							});
				}
				case "protected" -> {
					Arrays.stream(declaredFields).filter(field -> Modifier.isProtected(field.getModifiers()))
							.forEach(field -> {
								System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " +field.getName());
							});
				}
				case "public" -> {
					Arrays.stream(declaredFields).filter(field -> Modifier.isPublic(field.getModifiers()))
							.forEach(field -> {
								System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " +field.getName());
							});
				}
				case "all" -> {
					Arrays.stream(declaredFields).forEach(field -> {
						System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " +field.getName());
					});
				}

			}

			command = scanner.nextLine();
		}

	}
}
