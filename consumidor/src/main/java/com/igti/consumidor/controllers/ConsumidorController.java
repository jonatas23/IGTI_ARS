package com.igti.consumidor.controllers;

import com.igti.consumidor.dtos.ConsumidorDto;
import com.igti.consumidor.models.Consumidor;
import com.igti.consumidor.services.ConsumidorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/cons")
public class ConsumidorController {

    private ConsumidorService consumidorService;

    @Autowired
    public ConsumidorController(ConsumidorService consumidorService) {
        this.consumidorService = consumidorService;
    }

    @PostMapping
    public ResponseEntity<Object> save(ConsumidorDto consumidorDto){
        Consumidor consumidor = new Consumidor();
        BeanUtils.copyProperties(consumidorDto, consumidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(consumidorService.save(consumidor));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consumidor> findById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(consumidorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Consumidor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(consumidorService.findAll());
    }

    @PutMapping
    public ResponseEntity<Object> update(Consumidor consumidor){
        return ResponseEntity.status(HttpStatus.CREATED).body(consumidorService.save(consumidor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id){
        Consumidor consumidor = consumidorService.findById(id);
        consumidorService.delete(consumidor);
        return ResponseEntity.status(HttpStatus.OK).body("Consumidor deleted successfully.");
    }
}
