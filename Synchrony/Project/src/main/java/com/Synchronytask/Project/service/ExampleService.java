package com.Synchronytask.Project.service;

import com.Synchronytask.Project.entity.EntityCls;

import java.util.Optional;

public interface ExampleService {
    
    public Optional<EntityCls> getEntity(Long id);

    public EntityCls updateEntity(EntityCls entity);

    void performConcurrentTasks();
}