package com.deligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deligence.models.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
List<Module> findModulesByIndexId(long indexId);
}
