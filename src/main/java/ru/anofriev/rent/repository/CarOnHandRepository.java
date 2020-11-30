package ru.anofriev.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anofriev.rent.model.CarOnHand;

public interface CarOnHandRepository extends JpaRepository<CarOnHand, Integer> {
}
