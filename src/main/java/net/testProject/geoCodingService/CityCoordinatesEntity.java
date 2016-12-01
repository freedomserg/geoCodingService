package net.testProject.geoCodingService;

public class CityCoordinatesEntity {

    private String cityName;
    private double longitude;
    private double latitude;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(cityName).append(": ");
        if (longitude == 0 && latitude == 0) {
            return builder.
                    append("location is not found").
                    toString();
        } else {
            return builder.
                    append("latitude: ").
                    append(latitude).
                    append(" longitude: ").
                    append(longitude).
                    toString();
        }
    }
}
