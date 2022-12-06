package com.naidiuk.restpractice.service;

import com.naidiuk.restpractice.dto.GroupDto;
import com.naidiuk.restpractice.entity.Group;
import com.naidiuk.restpractice.mapper.GroupMapper;
import com.naidiuk.restpractice.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public Long save(GroupDto groupDto) {
        Group group = GroupMapper.transformToDao(groupDto);
        Group savedGroup = groupRepository.save(group);
        return savedGroup.getGroupId();
    }
}
