package ru.anofriev.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anofriev.rent.model.Manufacturer;
import ru.anofriev.rent.service.ManufacturerService;

import java.util.List;

@RestController
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping(value = "/manufacturer")
    public ResponseEntity<?> create(@RequestBody Manufacturer manufacturer) {
        manufacturerService.create(manufacturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/manufacturer")
    public ResponseEntity<List<Manufacturer>> read() {
        final List<Manufacturer> manufacturerList = manufacturerService.readAll();

        return manufacturerList != null &&  !manufacturerList.isEmpty()
                ? new ResponseEntity<>(manufacturerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/manufacturer/{id}")
    public ResponseEntity<Manufacturer> read(@PathVariable(name = "id") int id) {
        final Manufacturer manufacturer = manufacturerService.read(id);

        return manufacturer != null
                ? new ResponseEntity<>(manufacturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/manufacturer/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Manufacturer manufacturer) {
        final boolean updated = manufacturerService.update(manufacturer, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/manufacturer/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = manufacturerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
