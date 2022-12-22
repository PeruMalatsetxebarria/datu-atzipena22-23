package dambi.rest_mongo_pelikulak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PelikulaRepository {
    List<Pelikula> findAll();
    Pelikula findById(String id);
    Pelikula findByYear(String year);
    Pelikula findByActor(String actor);
    Pelikula findByZuzendari(String director);
    List<Pelikula> findByZuzendaria();
    Pelikula save(Pelikula pelikula);
    long delete(String title);
}
