package dao;

import java.util.Optional;

public interface City {
    Optional<City> findById(long id);
}
