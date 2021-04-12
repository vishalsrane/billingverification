package com.synthesis.billingverification.mappers;

import org.springframework.stereotype.Component;

import com.synthesis.billingverification.domain.Group;
import com.synthesis.billingverification.dto.GroupDto;

@Component
public class GroupMapper {
	
	public GroupDto getGroupDtoFromGroupDomain (Group group) {
		return GroupDto.builder()
				.id(group.getId())
				.description(group.getDescription())
				.name(group.getName())
				.query(group.getQuery())
				.build();
		
	}
	
	public Group getGroupDomainFromGroupDto (GroupDto groupDto) {
		Group group = new Group();
		group.setId(groupDto.getId());
		group.setName(groupDto.getName());
		group.setQuery(groupDto.getQuery());
		group.setDescription(groupDto.getDescription());
		return group;		
	}

}
