package com.synthesis.billingverification.mappers;

import org.springframework.stereotype.Component;

import com.synthesis.billingverification.domain.Rule;
import com.synthesis.billingverification.dto.RuleDto;

@Component
public class RuleMapper {
	
	public RuleDto getRuleDtoFromRuleDomain (Rule rule) {		
		return RuleDto.builder()
				.id(rule.getId())
				.name(rule.getName())
				.group(rule.getGroup())
				.build();
	}
	
	public Rule getRuleDomainFromRuleDto (RuleDto ruleDto) {		
		Rule rule = new Rule();
		rule.setId(ruleDto.getId());
		rule.setName(ruleDto.getName());
		rule.setGroup(ruleDto.getGroup());
		return rule;		
	}

}
