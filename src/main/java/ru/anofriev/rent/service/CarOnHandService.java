package ru.anofriev.rent.service;

import ru.anofriev.rent.model.CarOnHand;

import java.util.List;

public interface CarOnHandService {
    //Добавление нового объекта
    void create(CarOnHand carOnHand);

    //Список всех объектов
    List<CarOnHand> readAll();

    //Возвращает объект по id
    CarOnHand read(int id_car);

    /**
     * Обновляет авто с заданным ID,
     * в соответствии с переданным клиентом
     * @param carOnHand - клиент в соответсвии с которым нужно обновить данные
     * @param id_car - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(CarOnHand carOnHand, int id_car);

    /**
     * Удаляет клиента с заданным ID
     * @param id_car - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id_car);
}
