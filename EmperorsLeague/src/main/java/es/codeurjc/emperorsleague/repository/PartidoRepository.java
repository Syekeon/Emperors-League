package es.codeurjc.emperorsleague.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Partido;

@CacheConfig(cacheNames = "partidos")
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    @CacheEvict(allEntries = true)
    Partido save(Partido partido);

    @CacheEvict(allEntries = true)
    void deleteById(long id);

    @Cacheable
    Optional<Partido> findById(long id);
    
    @Cacheable
    List<Partido> findAll();
}