package com.naidiuk.restpractice.mapper;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.dto.TeacherDto;
import com.naidiuk.restpractice.dto.TeacherGroupsDto;
import com.naidiuk.restpractice.entity.Teacher;

import java.util.List;

public class TeacherMapper {
    private TeacherMapper() {
    }

    public static Teacher transformToDao (TeacherDto teacherDto) {
        return Teacher.builder()
                .teacherId(teacherDto.getTeacherId())
                .teacherName(teacherDto.getTeacherName())
                .build();
    }

    public static TeacherDto transformToDto (Teacher teacher) {
        return TeacherDto.builder()
                .teacherId(teacher.getTeacherId())
                .teacherName(teacher.getTeacherName())
                .build();
    }

    public static TeacherGroupsDto transformToDtoWithGroups(Teacher teacher) {
        List<GroupDto> groupsDto = teacher.getGroups().stream()
                                            .map(GroupMapper::transformToDto)
                                            .toList();

        return TeacherGroupsDto.builder()
                .teacherId(teacher.getTeacherId())
                .teacherName(teacher.getTeacherName())
                .groups(groupsDto)
                .build();
    }
}
