package by.kirienko;

import java.util.*;
import java.util.stream.Collectors;

public class RoadLogistic {

    public static ArrayList<ArrayList<Road>> getAllWays(CityGraph start, CityGraph finish) {
        ArrayList<ArrayList<Road>> AllWays = new ArrayList<>();
        ArrayList<Road> currentWay = new ArrayList<>();

        ArrayList<Road> currentWayCopy = (ArrayList<Road>) currentWay.clone();

        HashSet<CityGraph> passedCities = new HashSet<>();
        passedCities.add(start);

        //Set<Road> availableRoads = getAvailableRoads(start, passedCities);
        Set<Road> availableRoads = getAvailableRoadsExceptFinish(start, finish, passedCities);

        Optional<Road> roadToFinish = getRoadToFinish(start, finish, passedCities);

//        System.out.println("START : " + start);
//        System.out.println("FINISH : " + finish);
//        System.out.println("PASSED : " + passedCities);
//        System.out.println("CURRENT WAY" + currentWay);
//        System.out.println("ALL WAYS: " + AllWays);

        if (roadToFinish.isPresent()) {
            currentWay.add(roadToFinish.get());
//            System.out.println("CURRENT WAY : " + currentWay);
            AllWays.add(currentWay);
//            System.out.println("ALL WAYS: " + AllWays);
        }

//        System.out.println("/////////////////////////////////////////////////");
        if (!availableRoads.isEmpty()) {
            for (Road road : availableRoads) {
                ArrayList<Road> currentWayCopyNew = (ArrayList<Road>) currentWayCopy.clone();
                currentWayCopyNew.add(road);
                getAllWays(road.getFinishCity(), finish, (HashSet<CityGraph>) passedCities.clone(), AllWays, currentWayCopyNew);
                //currentWayCopy.remove(road);
            }
        }

//        System.out.println("ALL WAYS: " + AllWays);
//        System.out.println("/////////////////////////////////////////////////");
//        System.out.println("END OF MAIN METHOD");
//        System.out.println("/////////////////////////////////////////////////");
        return AllWays;
    }

    public static void getAllWays(CityGraph start, CityGraph finish, HashSet<CityGraph> passedCities,
                                  ArrayList<ArrayList<Road>> AllWays, ArrayList<Road> currentWay) {

        ArrayList<Road> currentWayCopy = (ArrayList<Road>) currentWay.clone();

        passedCities.add(start);

        //Set<Road> availableRoads = getAvailableRoads(start, passedCities);
        Set<Road> availableRoads = getAvailableRoadsExceptFinish(start, finish, passedCities);
        Optional<Road> roadToFinish = getRoadToFinish(start, finish, passedCities);

//        System.out.println("START : " + start);
//        System.out.println("FINISH : " + finish);
//        System.out.println("PASSED : " + passedCities);
//        System.out.println("CURRENT WAY" + currentWay);
//        System.out.println("ALL WAYS: " + AllWays);

        if (roadToFinish.isPresent()) {
            currentWay.add(roadToFinish.get());
//            System.out.println("CURRENT WAY : " + currentWay);
            AllWays.add(currentWay);
//            System.out.println("ALL WAYS: " + AllWays);
        }

//        System.out.println("/////////////////////////////////////////////////");
        for (Road road : availableRoads) {
            ArrayList<Road> currentWayCopyNew = (ArrayList<Road>) currentWayCopy.clone();
            currentWayCopyNew.add(road);
            getAllWays(road.getFinishCity(), finish, (HashSet<CityGraph>) passedCities.clone(), AllWays, currentWayCopyNew);
        }

//        System.out.println("ALL WAYS: " + AllWays);
//        System.out.println("/////////////////////////////////////////////////");
//        System.out.println("END OF METHOD");
//        System.out.println("/////////////////////////////////////////////////");
    }

    public static Set<Road> getAvailableRoads(CityGraph start, Set<CityGraph> passedCities) {
        Set<Road> availableRoads = start.getRoads().stream()
                .filter((road) -> !passedCities.contains(road.getFinishCity()))
                .collect(Collectors.toSet());

        return availableRoads;
    }

    public static Optional<Road> getRoadToFinish(CityGraph start, CityGraph finish, Set<CityGraph> passedCities) {
        Optional<Road> roadToFinish = getAvailableRoads(start, passedCities).stream()
                .filter((road) -> road.getFinishCity().equals(finish))
                .findFirst();

        return roadToFinish;
    }

    public static Set<Road> getAvailableRoadsExceptFinish(CityGraph start, CityGraph finish, Set<CityGraph> passedCities) {
        Set<Road> availableRoads = start.getRoads().stream()
                .filter((road) -> !passedCities.contains(road.getFinishCity()))
                .filter((road) -> !road.getFinishCity().equals(finish))
                .collect(Collectors.toSet());

        return availableRoads;
    }
}
