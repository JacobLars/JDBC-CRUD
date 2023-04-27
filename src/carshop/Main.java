package carShop;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static CarDaoImplementation carDao = new CarDaoImplementation();


    public static void main(String[] args) throws SQLException {

       menu();


    }


    public static void menu() throws SQLException {

        boolean loop = true;

        while (loop) {
            System.out.println("""
                    1. Add car
                    2. Show all cars
                    3. Show car by id
                    4. Show car by brand
                    5. Update car color
                    6. Update car price
                    7. Update car brand
                    8. Remove car
                    0. Exit""");

            int choice = sc.nextInt();

            if (choice == 1) {

                addCar();

            } else if (choice == 2) {

                showAllCars();


            }else if (choice == 3){

                showCarById();

            }else if (choice == 4){
                showCarByBrand();

            }else if (choice == 5){

                updateCarColor();

            }else if (choice == 6){

                updateCarPrice();

            }else if (choice == 7){

                updateCarBrand();

            }else if (choice == 8){

                removeCarById();

            }else if (choice == 0){

                loop = false;
            }

        }
    }

    public static void addCar() throws SQLException {
        
        System.out.println("Id:");
        int id = sc.nextInt();
        
        System.out.println("Brand: ");
        sc.nextLine();
        String brand = sc.nextLine();


        System.out.println("Color:");
        String color = sc.nextLine();

        System.out.println("Price: ");
        double price = sc.nextDouble();

        Car c = new Car(id, brand, color, price);

        carDao.addCar(c);

    }


    public static void showAllCars() throws SQLException {

        carDao.showAllCars();
        sc.nextLine();
        sc.nextLine();
    }

    public static void showCarById() throws SQLException {

        System.out.println("Id:");
        int id = sc.nextInt();
        sc.nextLine();
        carDao.showCarById(id);


    }

    public static void showCarByBrand() throws SQLException {

        System.out.println("Brand: ");
        sc.nextLine();
        String brand = sc.nextLine();


        carDao.showCarByBrand(brand);

    }


    public static void updateCarBrand() throws SQLException {

        System.out.println("Id of car you want to update:");
        int id = sc.nextInt();
        sc.nextLine();


        System.out.println("New brand: ");
        String brand = sc.nextLine();


        carDao.updateCarBrandById(id, brand);
    }

    public static void updateCarColor() throws SQLException {

        System.out.println("Id of car you want to update:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("New color");
        String color = sc.nextLine();

        carDao.updateCarColorById(id, color);

    }

    public static void updateCarPrice() throws SQLException {

        System.out.println("Id of car you want to update:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("New price");
        double price = sc.nextDouble();

        carDao.updatePriceById(id, price);
    }

    public static void removeCarById() throws SQLException {

        System.out.println("Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        carDao.removeCarById(id);
    }


}




