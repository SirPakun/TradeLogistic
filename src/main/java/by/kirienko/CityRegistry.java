package by.kirienko;

public enum CityRegistry {

    KRIJOPOL(new City("Krijopol")),
    LIGAT(new City("Ligat")),
    SOMAK(new City("Somak")),
    ALADOR(new City("Alador")),
    LYAPINSK(new City("Lyapinsk")),
    NARTS(new City("Narts")),
    KORNUV(new City("Kornuv")),
    CHICK_CHIRICK(new City("Chick-Chirick")),
    STOLBCY(new City("Stolbcy"));

    private City city;

    CityRegistry(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return city.toString();
    }
}
