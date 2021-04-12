package com.synthesis.billingverification.controllers;

import java.util.List;
import java.util.Optional;

//import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synthesis.billingverification.dto.GroupDto;
import com.synthesis.billingverification.services.GroupService;

@RestController
@RequestMapping("/api/v1/biling")
public class BillingController {
	
	private final GroupService groupService;
	
	public BillingController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<GroupDto> getGroup(@PathVariable("id") Long id) {		
		
		Optional<GroupDto> groupDtoOptional =   groupService.getByID(id);
		if(groupDtoOptional.isPresent()) {
			return new ResponseEntity<GroupDto>(groupDtoOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<GroupDto>(HttpStatus.NOT_EXTENDED);
		}		
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpHeaders> createGroup(@RequestBody GroupDto groupDto){		
		GroupDto savedDto = groupService.saveNewGroup(groupDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/biling/" + savedDto.getId().toString());
		return new ResponseEntity<HttpHeaders>(headers, HttpStatus.CREATED);		
	}
	
	@GetMapping
	public ResponseEntity<List<GroupDto>> getAllGroups() {				
		List<GroupDto> dtos =   groupService.listAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);		
	}
	
	
	@PutMapping({"/{id}"})
	public ResponseEntity<HttpHeaders> updateGroup(@PathVariable("id") Long id, @RequestBody GroupDto  groupDto){
		if(id != groupDto.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			groupService.updateGroup(id, groupDto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	

}
	