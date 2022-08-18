package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "X", 123));
        cars.add(new Car(2, "X", 214));
        cars.add(new Car(3, "X", 342));
        cars.add(new Car(4, "X", 451));
        cars.add(new Car(5, "X", 535));
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> newCarsList = new ArrayList<>();
        cars.stream()
                .limit(count)
                .forEach(newCarsList::add);
        return newCarsList;
    }
}
