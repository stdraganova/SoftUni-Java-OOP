package reflection.exercise.barracksWars.core.commands;

import reflection.exercise.barracksWars.interfaces.Executable;
import reflection.exercise.barracksWars.interfaces.Repository;
import reflection.exercise.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected String[] getData() {
        return data;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
