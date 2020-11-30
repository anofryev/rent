package ru.anofriev.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anofriev.rent.model.Car;

import ru.anofriev.rent.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public void create(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> readAll() {
        return carRepository.findAll();
    }

    @Override
    public Car read(int id_car) {
        return carRepository.getOne(id_car);
    }

    @Override
    public boolean update(Car car, int id_car) {
        if (carRepository.existsById(id_car)) {
            car.setId_car(id_car);
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id_car) {
        if (carRepository.existsById(id_car)) {
            carRepository.deleteById(id_car);
            return true;
        }
        return false;
    }


}
