package carShop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImplementation implements CarDao {

    Connection conn;
    PreparedStatement insertCar, getAllCars, showCarById, showCarByBrand ,
            updateCarBrandById, updateCarColorById, updateCarPriceById, removeCarById;

    String url = "jdbc:mysql://localhost:3306/carshop";
    String user = "root";
    String password = "root";


    CarDaoImplementation() {


        try {
            conn = DriverManager.getConnection(url, user, password);
            insertCar = conn.prepareStatement("INSERT INTO carshop.cars (brand, color, price) VALUES (?, ?, ?)");
            getAllCars = conn.prepareStatement("SELECT  * FROM carshop.cars");
            showCarById = conn.prepareStatement("SELECT * FROM carshop.cars WHERE id = ?");
            updateCarBrandById = conn.prepareStatement("UPDATE carshop.cars SET brand = ? WHERE id = ?");
            updateCarColorById = conn.prepareStatement("UPDATE carshop.cars SET color = ? WHERE id = ?");
            updateCarPriceById = conn.prepareStatement("UPDATE carshop.cars SET price = ? WHERE id = ?");
            showCarByBrand = conn.prepareStatement("SELECT * FROM carshop.cars WHERE brand = ?");
            removeCarById = conn.prepareStatement("DELETE FROM carshop.cars WHERE id = ?");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void addCar(Car c) throws SQLException {

        try {
            insertCar.setString(1, c.getBrand());
            insertCar.setString(2, c.getColor());
            insertCar.setDouble(3, c.getPrice());

        } catch (SQLException e) {
            System.out.println("Could not add car");
        }

        insertCar.executeUpdate();
    }


    @Override
    public List<Car> showAllCars() throws SQLException {

        List<Car> cars = new ArrayList<>();

        ResultSet rs = getAllCars.executeQuery();

        while (rs.next()) {

            cars.add(new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("color"), rs.getDouble("price")));

        }

        for (Car c : cars) {
            System.out.println(c);
        }
        return cars;
    }

    @Override
    public void showCarById(int id) throws SQLException {

        showCarById.setInt(1, id);
        ResultSet rs = showCarById.executeQuery();

        while (rs.next()) {

            int carId = rs.getInt("id");
            String brand = rs.getString("brand");
            String color = rs.getString("color");
            double price = rs.getDouble("price");

            System.out.println("Id=" + carId + " brand=" + brand + " color=" + color + " price=" + price);


        }

    }



    @Override
    public void updateCarBrandById(int id, String brand) throws SQLException {

        updateCarBrandById.setString(1, brand);
        updateCarBrandById.setInt(2, id);

        updateCarBrandById.executeUpdate();

    }

    @Override
    public void updateCarColorById(int id, String color) throws SQLException {

        updateCarColorById.setString(1, color);
        updateCarColorById.setInt(2, id);

        updateCarColorById.executeUpdate();

    }

    @Override
    public void updatePriceById(int id, double price) throws SQLException {

        updateCarPriceById.setDouble(1, price);
        updateCarPriceById.setInt(2, id);

        updateCarPriceById.executeUpdate();

    }

    @Override
    public void removeCarById(int id) throws SQLException {

        removeCarById.setInt(1, id);

        removeCarById.executeUpdate();

    }

    @Override
    public void showCarByBrand(String brand) throws SQLException {

        showCarByBrand.setString(1, brand);

        ResultSet rs = showCarByBrand.executeQuery();

        while (rs.next()){

            int id = rs.getInt("id");
            String carBrand = rs.getString("brand");
            String color = rs.getString("color");
            double price = rs.getDouble("price");

            System.out.println("Id=" + id + " brand=" + brand + " color=" + color + " price=" + price);

        }

    }
}
