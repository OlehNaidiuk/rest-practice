package com.naidiuk.restpractice.web.controller;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody GroupDto groupDto) {
        Long groupId = groupService.save(groupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(groupId);
    }
}
