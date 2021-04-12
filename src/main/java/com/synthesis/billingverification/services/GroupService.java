package com.synthesis.billingverification.services;

import java.util.List;
import java.util.Optional;

//import java.util.UUID;

import com.synthesis.billingverification.dto.GroupDto;

public interface GroupService {
	
	List<GroupDto> listAll();
	
	Optional<GroupDto> getByID(Long id);

	GroupDto saveNewGroup(GroupDto groupDto);

	GroupDto updateGroup(Long id, GroupDto groupDto);

}
