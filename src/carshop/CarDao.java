package carShop;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {

    void addCar(Car c) throws SQLException;



    List<Car> showAllCars() throws SQLException;

    void showCarById(int id) throws SQLException;

    void updateCarBrandById(int id, String brand) throws SQLException;

    void updateCarColorById(int id, String color) throws SQLException;

    void updatePriceById(int id, double price) throws SQLException;

    void removeCarById(int id) throws SQLException;

    void showCarByBrand(String brand) throws SQLException;
}
