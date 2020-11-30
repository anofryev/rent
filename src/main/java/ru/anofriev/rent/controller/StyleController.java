package ru.anofriev.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anofriev.rent.model.Style;
import ru.anofriev.rent.service.StyleService;

import java.util.List;

@RestController
public class StyleController {
    private final StyleService styleService;

    @Autowired
    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @PostMapping(value = "/style")
    public ResponseEntity<?> create(@RequestBody Style style) {
        styleService.create(style);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/style")
    public ResponseEntity<List<Style>> read() {
        final List<Style> styleList = styleService.readAll();

        return styleList != null &&  !styleList.isEmpty()
                ? new ResponseEntity<>(styleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/style/{id}")
    public ResponseEntity<Style> read(@PathVariable(name = "id") int id) {
        final Style style = styleService.read(id);

        return style != null
                ? new ResponseEntity<>(style, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/style/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Style style) {
        final boolean updated = styleService.update(style, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/style/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = styleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
