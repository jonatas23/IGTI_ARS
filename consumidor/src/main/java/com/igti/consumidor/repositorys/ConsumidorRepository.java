package com.igti.consumidor.repositorys;

import com.igti.consumidor.models.Consumidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, UUID> {
}
