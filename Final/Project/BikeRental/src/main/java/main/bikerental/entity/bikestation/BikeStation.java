package main.bikerental.entity.bikestation;

public class BikeStation {
    private int id;
    private String name;
    private String address;
    private int numberOfBike;
    private int numberOfBikeAvailable;

    public BikeStation() {

    }

    public BikeStation(int id, String name, String address, int numberOfBike, int numberOfBikeAvailable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numberOfBike = numberOfBike;
        this.numberOfBikeAvailable = numberOfBikeAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBike() {
        return numberOfBike;
    }

    public void setNumberOfBike(int numberOfBike) {
        this.numberOfBike = numberOfBike;
    }

    public int getNumberOfBikeAvailable() {
        return numberOfBikeAvailable;
    }

    public void setNumberOfBikeAvailable(int numberOfBikeAvailable) {
        this.numberOfBikeAvailable = numberOfBikeAvailable;
    }

    @Override
    public String toString() {
        return "BikeStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfBike=" + numberOfBike +
                ", numberOfBikeAvailable=" + numberOfBikeAvailable +
                '}';
    }
}
