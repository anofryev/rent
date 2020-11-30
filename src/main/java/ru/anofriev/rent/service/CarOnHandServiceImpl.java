package ru.anofriev.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anofriev.rent.model.CarOnHand;
import ru.anofriev.rent.repository.CarOnHandRepository;

import java.util.List;

@Service
public class CarOnHandServiceImpl implements CarOnHandService {

    @Autowired
    private CarOnHandRepository carOnHandRepository;

    @Override
    public void create(CarOnHand carOnHand) {
        carOnHandRepository.save(carOnHand);
    }

    @Override
    public List<CarOnHand> readAll() {
        return carOnHandRepository.findAll();
    }

    @Override
    public CarOnHand read(int id_car) {
        return carOnHandRepository.getOne(id_car);
    }

    @Override
    public boolean update(CarOnHand carOnHand, int id_car) {
        if (carOnHandRepository.existsById(id_car)) {
            carOnHand.setIdCarOnHand(id_car);
            carOnHandRepository.save(carOnHand);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id_car) {
        if (carOnHandRepository.existsById(id_car)) {
            carOnHandRepository.deleteById(id_car);
            return true;
        }
        return false;
    }
}
