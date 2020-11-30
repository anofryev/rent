package ru.anofriev.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anofriev.rent.model.Style;

import java.util.List;

public interface StyleRepository extends JpaRepository<Style, Integer> {

    List<Style> findByNameStyle(String name);
}
