package ru.anofriev.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anofriev.rent.model.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
