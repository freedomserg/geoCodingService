package net.testProject.geoCodingService;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import java.util.function.Function;

public class GeoCodingService implements Function<String, CityCoordinatesEntity> {

    private final String API_KEY = "AIzaSyDhlkpcEBoxdIv_Xnw6pv5fyF7qLZOgRxE";

    @Override
    public CityCoordinatesEntity apply(String city) {
        CityCoordinatesEntity cityCoordinatesEntity = new CityCoordinatesEntity();
        cityCoordinatesEntity.setCityName(city);
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        GeocodingResult[] results;
        try {
            results = GeocodingApi.geocode(context, city).await();
            GeocodingResult result = results[0];
            cityCoordinatesEntity.setLatitude(result.geometry.location.lat);
            cityCoordinatesEntity.setLongitude(result.geometry.location.lng);
        } catch (Exception e) {
        }
        return cityCoordinatesEntity;
    }
}
