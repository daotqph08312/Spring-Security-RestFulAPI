package com.ex7.restfulapi.service;

import java.util.List;

public interface serviceRepository <T> {
    public List<T> getAll();
    public T getById(Long id);
    public T create(T t);
    public T update(T t, Long id);
    public String delete(Long id);
    public  String identity();

}
