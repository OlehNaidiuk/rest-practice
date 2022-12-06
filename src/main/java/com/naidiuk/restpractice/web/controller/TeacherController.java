package com.naidiuk.restpractice.web.controller;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.dto.TeacherDto;
import com.naidiuk.restpractice.dto.TeacherGroupsDto;
import com.naidiuk.restpractice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TeacherDto teacherDto) {
        Long teacherId = teacherService.save(teacherDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherId);
    }

    @PostMapping("/{teacherId}/groups")
    public ResponseEntity<?> addGroupToTeacher(
            @PathVariable Long teacherId,
            @RequestBody GroupDto groupDto
    ) {
        TeacherGroupsDto teacherGroupsDto = teacherService.addGroupToTeacher(teacherId, groupDto);
        return ResponseEntity.status(HttpStatus.OK).body(teacherGroupsDto);
    }

    @DeleteMapping("/{teacherId}/groups/{groupId}")
    public ResponseEntity<?> deleteGroupFromTeacher(
            @PathVariable Long teacherId,
            @PathVariable Long groupId
    ) {
        TeacherGroupsDto teacherGroupsDto = teacherService.deleteGroupFromTeacher(teacherId, groupId);
        return ResponseEntity.status(HttpStatus.OK).body(teacherGroupsDto);
    }

    @GetMapping("/{teacherId}/groups")
    public ResponseEntity<?> findAllTeacherGroups(@PathVariable Long teacherId) {
        TeacherGroupsDto teacherGroupsDto = teacherService.findAllTeacherGroups(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(teacherGroupsDto);
    }
}
