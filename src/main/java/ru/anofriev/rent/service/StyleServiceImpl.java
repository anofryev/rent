package ru.anofriev.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anofriev.rent.model.Manufacturer;
import ru.anofriev.rent.model.Style;
import ru.anofriev.rent.repository.StyleRepository;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService{
    
    @Autowired
    private StyleRepository styleRepository;

    @Override
    public void create(Style style) {
        styleRepository.save(style);
    }

    @Override
    public List<Style> readAll() {
        return styleRepository.findAll();
    }

    @Override
    public Style read(int id_style) {
        return styleRepository.getOne(id_style);
    }

    @Override
    public boolean update(Style style, int id_style) {
        if (styleRepository.existsById(id_style)) {
            style.setIdStyle(id_style);
            styleRepository.save(style);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id_style) {
        if (styleRepository.existsById(id_style)) {
            styleRepository.deleteById(id_style);
            return true;
        }
        return false;
    }

    //Находит объект по наименованию
    @Override
    public List<Style> findByName(String name) {
        List<Style> styleList = styleRepository.findByNameStyle(name);
        return styleList;
    }
}
