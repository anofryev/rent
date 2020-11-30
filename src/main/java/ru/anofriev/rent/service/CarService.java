package ru.anofriev.rent.service;

import ru.anofriev.rent.model.Car;

import java.util.List;

public interface CarService {
    //Добавление нового объекта
    void create(Car car);

    //Список всех объектов
    List<Car> readAll();

    //Возвращает объект по id
    Car read(int id_car);

    /**
     * Обновляет авто с заданным ID,
     * в соответствии с переданным клиентом
     * @param car - клиент в соответсвии с которым нужно обновить данные
     * @param id_car - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Car car, int id_car);

    /**
     * Удаляет клиента с заданным ID
     * @param id_car - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id_car);

    //Представление

}
