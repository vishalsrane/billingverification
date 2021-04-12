package com.synthesis.billingverification.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDto {
	
	private Long id;
	private String name;
	private String description;
	private String query;
	
	@JsonIgnoreProperties("group")
	private Set<RuleDto> rules;

}
