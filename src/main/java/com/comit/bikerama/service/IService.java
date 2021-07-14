package com.comit.bikerama.service;

import java.util.List;

public interface IService <T,Long>{
    public List<T> getAll();

    public T getById(Long id);

    public T save(T Entity);

    public T update(T Entity);

    public void delete(Long id);
}
