package com.example.ForexApp_v1.repositories;

import com.example.ForexApp_v1.model.User;

import java.util.List;

public interface IRepository<TEntity> {
    void create(TEntity entity);
    void edit(TEntity entity);
    void delete(TEntity entity);
    TEntity findById(Long id);
    //User findUserByEmail(String email);
    List<TEntity> findAll();
}
