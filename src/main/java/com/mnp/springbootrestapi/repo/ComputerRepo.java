package com.mnp.springbootrestapi.repo;

import com.mnp.springbootrestapi.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepo extends CrudRepository<Computer, Long> {
}
