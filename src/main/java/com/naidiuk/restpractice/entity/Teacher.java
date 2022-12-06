package com.naidiuk.restpractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.MERGE)
    private List<Group> groups = new ArrayList<>();

    public void addGroup(Group group) {
        group.setTeacher(this);
        getGroups().add(group);
    }

    public void deleteGroup(Group group) {
        getGroups().remove(group);
        group.setTeacher(null);
    }
}
