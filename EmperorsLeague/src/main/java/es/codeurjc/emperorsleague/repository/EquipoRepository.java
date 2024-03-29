package es.codeurjc.emperorsleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Equipo;

@CacheConfig(cacheNames = "equipos")
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    @CacheEvict(allEntries = true)
    Equipo save(Equipo equipo);

    @CacheEvict(allEntries = true)
    void deleteById(long id);

    @Cacheable
    Optional<Equipo> findById(long id);

    @Cacheable
    List<Equipo> findAll();
}