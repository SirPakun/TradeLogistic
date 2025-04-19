package by.kirienko;

import java.util.Objects;

public class Road {
    private CityGraph startCity;
    private CityGraph finishCity;
    private int length;
    //private boolean Closability;

    public Road(CityGraph startCity, CityGraph finishCity, int length){
        this.startCity = startCity;
        this.finishCity = finishCity;
        this.length = length;
    }

    public CityGraph getStartCity() {
        return startCity;
    }

    public CityGraph getFinishCity() {
        return finishCity;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Road road = (Road) object;
        return length == road.length && startCity == road.startCity && finishCity == road.finishCity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startCity, finishCity, length);
    }

    @Override
    public String toString() {
        return "Road from: " + startCity + " to: " + finishCity + " is " + length + " km.";
    }
}
