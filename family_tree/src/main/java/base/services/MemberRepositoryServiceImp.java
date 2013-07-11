package base.services;

import org.hibernate.mapping.List;

import base.dao.MemberDAO;
import base.entities.Member;

public class MemberRepositoryServiceImp implements MemberRepositoryService {
	
	MemberDAO repository;

	@Override
	public List findMember(Member member) {
		return null;
	}

	@Override
	public List findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
