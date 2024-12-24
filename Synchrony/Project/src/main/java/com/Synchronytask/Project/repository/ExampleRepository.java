package com.Synchronytask.Project.repository;

import com.Synchronytask.Project.entity.EntityCls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ExampleRepository extends CrudRepository<EntityCls, Long> {
}
