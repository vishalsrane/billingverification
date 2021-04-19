package com.synthesis.billingverification.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synthesis.billingverification.domain.Group;
import com.synthesis.billingverification.dto.GroupDto;
import com.synthesis.billingverification.mappers.GroupMapper;
import com.synthesis.billingverification.repositories.GroupRepository;


@Service
public class GroupServiceImpl implements GroupService{
	
	private GroupRepository groupRepository;
	private GroupMapper groupMapper;
	
	@Autowired
	public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
		this.groupRepository = groupRepository;
		this.groupMapper = groupMapper;
	}

	@Override
	public List<GroupDto> listAll() {
		return groupRepository.findAll()
						.stream()
						.map(groupMapper::getGroupDtoFromGroupDomain)
						.collect(Collectors.toList());
		
	}

	@Override
	public Optional<GroupDto> getByID(Long id) {
		Optional<Group> group = groupRepository.findById(id);			
		if(group.isPresent()) {
			GroupDto dto = groupMapper.getGroupDtoFromGroupDomain(group.get());
			return Optional.of(dto);
		}else {
			return Optional.empty();
		}
	}

	@Override
	public GroupDto saveNewGroup(GroupDto groupDto) {
		Group group = groupMapper.getGroupDomainFromGroupDto(groupDto);		
		Group groupSaved = groupRepository.save(group);
		
		
		return groupMapper.getGroupDtoFromGroupDomain(groupSaved);
	}

	@Override
	public GroupDto updateGroup(Long id, GroupDto groupDto) {
		groupDto.setId(id);
		Group group = groupMapper.getGroupDomainFromGroupDto(groupDto);
		Group savedGroup = groupRepository.save(group);		
		return groupMapper.getGroupDtoFromGroupDomain(savedGroup);
	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			groupRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	

}
