package com.Synchronytask.Project.service;

import com.Synchronytask.Project.entity.EntityCls;
import com.Synchronytask.Project.repository.ExampleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ExampleServiceImpl implements ExampleService{
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private ExampleRepository repository;

    @Cacheable(value = "example", key = "#id")
    public Optional<EntityCls> getEntity(Long id) {
        return repository.findById(id);
    }

    @CacheEvict(value = "example", key = "#entity.id")
    @Transactional
    public EntityCls updateEntity(EntityCls entity) {
        return repository.save(entity);
    }

    public void performConcurrentTasks() {
        executorService.submit(() -> {
            // Example concurrent task: database read
            repository.findAll();
        });

        executorService.submit(() -> {
            // Example concurrent task: cache update
            EntityCls entity = new EntityCls();
            entity.setName("Example");
            entity.setValue("New Value");
            repository.save(entity);
        });
    }
}
