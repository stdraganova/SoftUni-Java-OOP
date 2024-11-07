package reflection.exercise.barracksWars.core.factories;

import reflection.exercise.barracksWars.interfaces.Unit;
import reflection.exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection.exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {

        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor(); // празен конструктор
			return constructor.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
	}
}
