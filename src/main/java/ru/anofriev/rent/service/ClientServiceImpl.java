package ru.anofriev.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anofriev.rent.model.Client;
import ru.anofriev.rent.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client read(int id_client) {
        return clientRepository.getOne(id_client);
    }

    @Override
    public boolean update(Client client, int id_client) {
        if (clientRepository.existsById(id_client)) {
            client.setClient_id(id_client);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id_client) {
        if (clientRepository.existsById(id_client)) {
            clientRepository.deleteById(id_client);
            return true;
        }
        return false;
    }
}
