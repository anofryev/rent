package ru.anofriev.rent.service;

import ru.anofriev.rent.model.Client;

import java.util.List;

public interface ClientService {
    //Добавление нового объекта
    void create(Client client);

    //Список всех объектов
    List<Client> readAll();

    //Возвращает объект по id
    Client read(int id_client);

    /**
     * Обновляет авто с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id_client - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client client, int id_client);

    /**
     * Удаляет клиента с заданным ID
     * @param id_client - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id_client);
}
