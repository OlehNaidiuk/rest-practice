package com.naidiuk.restpractice.service;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.dto.TeacherDto;
import com.naidiuk.restpractice.dto.TeacherGroupsDto;

public interface TeacherService {
    Long save(TeacherDto teacherDto);
    TeacherGroupsDto addGroupToTeacher(Long teacherId, GroupDto groupDto);
    TeacherGroupsDto deleteGroupFromTeacher(Long teacherId, Long groupId);
    TeacherGroupsDto findAllTeacherGroups(Long teacherId);
}
