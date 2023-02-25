package dao;

import java.util.Optional;

public interface CityDao {
    Optional<CityDao> findById(long id);
}
