package ru.anofriev.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anofriev.rent.model.Manufacturer;
import ru.anofriev.rent.repository.ManufacturerRepository;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{
    
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public void create(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> readAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer read(int id_manufacturer) {
        return manufacturerRepository.getOne(id_manufacturer);
    }

    @Override
    public boolean update(Manufacturer manufacturer, int id_manufacturer) {
        if (manufacturerRepository.existsById(id_manufacturer)) {
            manufacturer.setIdManufacturer(id_manufacturer);
            manufacturerRepository.save(manufacturer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id_manufacturer) {
        if (manufacturerRepository.existsById(id_manufacturer)) {
            manufacturerRepository.deleteById(id_manufacturer);
            return true;
        }
        return false;
    }
    //Находит объект по наименованию

    @Override
    public List<Manufacturer> findByName(String name) {
        List<Manufacturer> manufacturerList= manufacturerRepository.findByNameManufacturer(name);
        return manufacturerList;
    }
}
