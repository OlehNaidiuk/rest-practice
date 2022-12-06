package com.naidiuk.restpractice.mapper;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.entity.Group;

public class GroupMapper {
    private GroupMapper() {
    }

    public static Group transformToDao(GroupDto groupDto) {
        return Group.builder()
                .groupId(groupDto.getGroupId())
                .groupName(groupDto.getGroupName())
                .build();
    }

    public static GroupDto transformToDto(Group group) {
        return GroupDto.builder()
                .groupId(group.getGroupId())
                .groupName(group.getGroupName())
                .build();
    }
}
