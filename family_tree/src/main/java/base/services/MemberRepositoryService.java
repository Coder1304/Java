package base.services;

import org.hibernate.mapping.List;

import base.entities.Member;

public interface MemberRepositoryService {
	public List findMember(Member member);
	public List findByName(String name);
	
}
