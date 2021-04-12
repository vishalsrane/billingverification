package com.synthesis.billingverification.mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.synthesis.billingverification.domain.Group;
import com.synthesis.billingverification.domain.Rule;
import com.synthesis.billingverification.dto.GroupDto;
import com.synthesis.billingverification.dto.RuleDto;

@Component
public class GroupMapper {
	
	private RuleMapper rulemapper;
	
	public GroupMapper(RuleMapper rulemapper) {
		this.rulemapper = rulemapper;
	}
	
	public GroupDto getGroupDtoFromGroupDomain (Group group) {
		
		Set<RuleDto> ruleDtos = group.getRules().stream()
						.map(rulemapper::getRuleDtoFromRuleDomain)
						.collect(Collectors.toSet());
		
		return GroupDto.builder()
				.id(group.getId())
				.description(group.getDescription())
				.name(group.getName())
				.query(group.getQuery())
				.rules(ruleDtos)
				.build();
		
	}
	
	
	public Group getGroupDomainFromGroupDto (GroupDto groupDto) {
		Group group = new Group();
		group.setId(groupDto.getId());
		group.setName(groupDto.getName());
		group.setQuery(groupDto.getQuery());
		group.setDescription(groupDto.getDescription());
		
		Set<Rule> rules = groupDto.getRules().stream()
							.map(
							    rule-> {
									rule.setGroup(group);
									return rule;
							    }
							)
							.map(rulemapper::getRuleDomainFromRuleDto)
							.collect(Collectors.toSet());
		
		group.setRules(rules);
		return group;		
	}

}
