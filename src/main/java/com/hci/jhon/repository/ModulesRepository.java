package com.hci.jhon.repository;

import com.hci.jhon.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  ModulesRepository extends JpaRepository<Modules, Integer> {
}
