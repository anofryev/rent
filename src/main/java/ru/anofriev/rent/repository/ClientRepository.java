package ru.anofriev.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anofriev.rent.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
