package com.naidiuk.restpractice.service;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.dto.TeacherDto;
import com.naidiuk.restpractice.dto.TeacherGroupsDto;
import com.naidiuk.restpractice.entity.Group;
import com.naidiuk.restpractice.entity.Teacher;
import com.naidiuk.restpractice.error.GroupNotFoundException;
import com.naidiuk.restpractice.error.TeacherNotFoundException;
import com.naidiuk.restpractice.mapper.GroupMapper;
import com.naidiuk.restpractice.mapper.TeacherMapper;
import com.naidiuk.restpractice.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public Long save(TeacherDto teacherDto) {
        Teacher teacher = TeacherMapper.transformToDao(teacherDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher.getTeacherId();
    }

    @Override
    public TeacherGroupsDto addGroupToTeacher(Long teacherId, GroupDto groupDto) {
        Teacher teacher = findById(teacherId);
        Group group = GroupMapper.transformToDao(groupDto);
        teacher.addGroup(group);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.transformToDtoWithGroups(savedTeacher);
    }

    @Override
    public TeacherGroupsDto deleteGroupFromTeacher(Long teacherId, Long groupId) {
        Teacher teacher = findById(teacherId);
        Group groupToDelete = teacher.getGroups().stream()
                                        .filter(tGroup -> tGroup.getGroupId().equals(groupId))
                                        .findFirst()
                                        .orElseThrow(() ->
                                                new GroupNotFoundException(
                                                        String.format("Group with id=%d not found!", groupId)));
        teacher.deleteGroup(groupToDelete);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherMapper.transformToDtoWithGroups(savedTeacher);
    }

    @Override
    @Transactional
    public TeacherGroupsDto findAllTeacherGroups(Long teacherId) {
        Teacher teacher = findById(teacherId);
        return TeacherMapper.transformToDtoWithGroups(teacher);
    }

    private Teacher findById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                                .orElseThrow(() ->
                                        new TeacherNotFoundException(
                                                String.format("Teacher with id=%d not found!", teacherId)));
    }
}
