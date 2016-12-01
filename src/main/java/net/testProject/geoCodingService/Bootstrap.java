package net.testProject.geoCodingService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Bootstrap {

    public static void main(String[] args) throws IOException {

        List<String> cities = DataExtractor.getCities();

        List<CityCoordinatesEntity> cityCoordinateEntities =
                cities.stream().map(city -> new GeoCodingService().apply(city)).collect(Collectors.toList());

        cityCoordinateEntities.forEach(System.out::println);
    }

}
