package com.Synchronytask.Project.controller;

import com.Synchronytask.Project.entity.EntityCls;
import com.Synchronytask.Project.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ExampleController {


        @Autowired
        private ExampleService service;

        @GetMapping("/entity/{id}")
        public Optional<EntityCls> getEntity(@PathVariable Long id) {
            return service.getEntity(id);
        }

        @PostMapping("/entity")
        public EntityCls updateEntity(@RequestBody EntityCls entity) {
            return service.updateEntity(entity);
        }

        @PostMapping("/tasks")
        public String performTasks() {
            service.performConcurrentTasks();
            return "Tasks submitted.";
        }
    }

