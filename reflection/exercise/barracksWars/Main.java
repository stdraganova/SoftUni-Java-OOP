package reflection.exercise.barracksWars;

import reflection.exercise.barracksWars.interfaces.Repository;
import reflection.exercise.barracksWars.interfaces.Runnable;
import reflection.exercise.barracksWars.interfaces.UnitFactory;
import reflection.exercise.barracksWars.core.Engine;
import reflection.exercise.barracksWars.core.factories.UnitFactoryImpl;
import reflection.exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
