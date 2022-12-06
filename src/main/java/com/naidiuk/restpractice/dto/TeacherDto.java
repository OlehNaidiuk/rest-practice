package com.naidiuk.restpractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherDto {
    private Long teacherId;
    private String teacherName;
}
