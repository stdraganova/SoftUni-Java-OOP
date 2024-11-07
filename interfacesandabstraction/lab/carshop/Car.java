package interfacesandabstraction.lab.carshop;

import java.io.Serializable;

public interface Car extends Serializable {
    //В интерфейсите всички методи са публични и абстрактни
    //всички полета са публични, статични, файнал константи

    Integer TIRES = 4;

    //Абстрактен клас връща като стринг модела
    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
