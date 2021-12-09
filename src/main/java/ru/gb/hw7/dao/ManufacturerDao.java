package ru.gb.hw7.dao;

import ru.gb.hw7.entity.Manufacturer;

public interface ManufacturerDao {
    Iterable<Manufacturer> findAll();
    Manufacturer findById(Long id);
    String findNameById(Long id);
    Manufacturer save(Manufacturer manufacturer);
    void deleteById(Long id);
    void delete(Manufacturer manufacturer);
}
