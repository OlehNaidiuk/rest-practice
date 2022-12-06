package com.naidiuk.restpractice.repository;

import com.naidiuk.restpractice.entity.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
