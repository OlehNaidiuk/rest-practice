package com.naidiuk.restpractice.repository;

import com.naidiuk.restpractice.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
