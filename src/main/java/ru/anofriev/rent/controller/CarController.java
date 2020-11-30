package ru.anofriev.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anofriev.rent.model.Car;
import ru.anofriev.rent.model.Manufacturer;
import ru.anofriev.rent.model.Style;
import ru.anofriev.rent.service.CarService;
import ru.anofriev.rent.service.ManufacturerService;
import ru.anofriev.rent.service.StyleService;

import java.util.List;

@RestController
public class CarController {
    
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(value = "/car")
    public ResponseEntity<?> create(@RequestBody Car car) {
        carService.create(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/car")
    public ResponseEntity<List<Car>> read() {
        final List<Car> carList = carService.readAll();

        return carList != null &&  !carList.isEmpty()
                ? new ResponseEntity<>(carList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Car> read(@PathVariable(name = "id") int id) {
        final Car car = carService.read(id);

        return car != null
                ? new ResponseEntity<>(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/car/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Car car) {
        final boolean updated = carService.update(car, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = carService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    
}
