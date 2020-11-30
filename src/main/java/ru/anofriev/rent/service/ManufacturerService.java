package ru.anofriev.rent.service;

import ru.anofriev.rent.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    //Добавление нового объекта
    void create(Manufacturer manufacturer);

    //Список всех объектов
    List<Manufacturer> readAll();

    //Возвращает объект по id
    Manufacturer read(int id_manufacturer);

    /**
     * Обновляет авто с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param id_client - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Manufacturer manufacturer, int id_manufacturer);

    /**
     * Удаляет клиента с заданным ID
     * @param id_client - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id_manufacturer);

    //Находит объект по названию
    List<Manufacturer> findByName(String name);
}
