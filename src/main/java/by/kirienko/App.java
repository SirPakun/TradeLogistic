package by.kirienko;

import java.util.*;
import java.util.stream.Collectors;

import static by.kirienko.RoadLogistic.getAvailableRoads;

public class App {
    public static void main(String[] args) {
        CityGraph KRYZOPOL = new CityGraph(CityRegistry.KRIJOPOL);
        CityGraph LIGAT = new CityGraph(CityRegistry.LIGAT);
        CityGraph LYAPINSK = new CityGraph(CityRegistry.LYAPINSK);
        CityGraph ALADOR = new CityGraph(CityRegistry.ALADOR);

        CityGraph SOMAK = new CityGraph(CityRegistry.SOMAK);

        System.out.println(KRYZOPOL.getRoads());

        KRYZOPOL.addRoad(LIGAT, 100);
        KRYZOPOL.addRoad(LYAPINSK, 170);
        LIGAT.addRoad(LYAPINSK, 100);
        LYAPINSK.addRoad(ALADOR, 120);

        SOMAK.addRoad(LIGAT, 500);
        SOMAK.addRoad(LYAPINSK, 450);
        SOMAK.addRoad(ALADOR, 430);

        System.out.println(KRYZOPOL.getRoads());
        System.out.println(LIGAT.getRoads());
        System.out.println(LYAPINSK.getRoads());

        System.out.println(RoadLogistic.getRoadToFinish(LIGAT, ALADOR, new HashSet<>()).isPresent());
        System.out.println();

//        System.out.println(RoadLogistic.getAllWays(LIGAT, ALADOR));
//        System.out.println(RoadLogistic.getAllWays(ALADOR, LYAPINSK));
//        System.out.println(RoadLogistic.getAllWays(LYAPINSK, KRYZOPOL));
//        System.out.println(RoadLogistic.getAllWays(KRYZOPOL, ALADOR));
//        System.out.println(RoadLogistic.getAllWays(KRYZOPOL, new CityGraph(CityRegistry.NARTS)));
//        System.out.println(RoadLogistic.getAllWays(KRYZOPOL, ALADOR));

        RoadLogistic.getAllWays(KRYZOPOL, ALADOR).stream()
                .forEach(System.out::println);

    }

}
