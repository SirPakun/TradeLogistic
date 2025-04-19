package by.kirienko;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CityGraph {

    private CityRegistry cityRegistry;
    private final List<Road> roads = new ArrayList<>();

    public CityGraph(CityRegistry cityRegistry) {
        this.cityRegistry = cityRegistry;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void addRoad(CityGraph finishCity, int length) {
        Road road = new Road(this, finishCity, length);
        Road roadBack = new Road(finishCity, this, length);

        roads.add(road);
        finishCity.roads.add(roadBack);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CityGraph cityGraph = (CityGraph) object;
        return cityRegistry == cityGraph.cityRegistry && Objects.equals(roads, cityGraph.roads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityRegistry);
    }

    @Override
    public String toString() {
        return cityRegistry.toString();
    }
}
