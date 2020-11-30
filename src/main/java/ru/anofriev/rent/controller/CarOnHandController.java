package ru.anofriev.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anofriev.rent.model.CarOnHand;
import ru.anofriev.rent.service.CarOnHandService;

import java.util.List;

@RestController
public class CarOnHandController {

    private final CarOnHandService carOnHandService;

    @Autowired
    public CarOnHandController(CarOnHandService carOnHandService) {
        this.carOnHandService = carOnHandService;
    }

    @PostMapping(value = "/caronhand")
    public ResponseEntity<?> create(@RequestBody CarOnHand carOnHand) {
        carOnHandService.create(carOnHand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/caronhand")
    public ResponseEntity<List<CarOnHand>> read() {
        final List<CarOnHand> carOnHandList = carOnHandService.readAll();

        return carOnHandList != null &&  !carOnHandList.isEmpty()
                ? new ResponseEntity<>(carOnHandList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/caronhand/{id}")
    public ResponseEntity<CarOnHand> read(@PathVariable(name = "id") int id) {
        final CarOnHand carOnHand = carOnHandService.read(id);

        return carOnHand != null
                ? new ResponseEntity<>(carOnHand, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/caronhand/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody CarOnHand carOnHand) {
        final boolean updated = carOnHandService.update(carOnHand, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/caronhand/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = carOnHandService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
