package base.dao;

import java.util.List;

import base.entities.Member;

public interface MemberDAO {
	public void addMember(Member member);
	@SuppressWarnings("rawtypes")
	public List findMemberByName(String name);
	@SuppressWarnings("rawtypes")
	public List findSyblings(Member member);
	@SuppressWarnings("rawtypes")
	public List findParents(Member member);
	@SuppressWarnings("rawtypes")
	public List findChildren(Member member);
	@SuppressWarnings("rawtypes")
	public List findInGenerationRange();
}
 