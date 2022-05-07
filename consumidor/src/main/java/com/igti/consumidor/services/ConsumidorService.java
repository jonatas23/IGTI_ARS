package com.igti.consumidor.services;

import com.igti.consumidor.exception.NotFoundException;
import com.igti.consumidor.models.Consumidor;
import com.igti.consumidor.repositorys.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumidorService {

    final ConsumidorRepository consumidorRepository;

    @Autowired
    public ConsumidorService(ConsumidorRepository consumidorRepository) {
        this.consumidorRepository = consumidorRepository;
    }

    @Transactional
    public Consumidor save(Consumidor consumidor) {
        return consumidorRepository.save(consumidor);
    }

    public List<Consumidor> findAll() {
        return consumidorRepository.findAll();
    }

    public Consumidor findById(UUID id) {
        return consumidorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Transactional
    public void delete(Consumidor consumidor) {
        consumidorRepository.delete(consumidor);
    }

}
