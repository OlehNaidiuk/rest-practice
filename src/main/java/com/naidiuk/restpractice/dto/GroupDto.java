package com.naidiuk.restpractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GroupDto {
    private Long groupId;
    private String groupName;
}
