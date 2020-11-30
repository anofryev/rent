package ru.anofriev.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anofriev.rent.model.Manufacturer;
import ru.anofriev.rent.model.Style;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {

    List<Manufacturer> findByNameManufacturer(String name);
}
