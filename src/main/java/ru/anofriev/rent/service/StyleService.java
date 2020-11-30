package ru.anofriev.rent.service;

import ru.anofriev.rent.model.Style;

import java.util.List;

public interface StyleService {
    /**Добавление нового объекта**/
    void create(Style style);

    /**Список всех объектов**/
    List<Style> readAll();

    /**Возвращает объект по id**/
    Style read(int id_style);

    /**
     * Обновляет авто с заданным ID,
     * в соответствии с переданным клиентом
     * @param style - клиент в соответсвии с которым нужно обновить данные
     * @param id_style - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Style style, int id_style);

    /**
     * Удаляет клиента с заданным ID
     * @param id_style - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id_style);

    //Находит объект по наименованию
    List<Style> findByName(String name);
}
