package base.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import base.entities.Member;

public class MemberDAOImpl extends HibernateDaoSupport implements MemberDAO {

	@Override
	public void addMember(Member member) {
		getHibernateTemplate().saveOrUpdate(member);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findMemberByName(final String name) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("from RELATIVES").setString("NAME", name);
                return query.list();
            }
        });
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findSyblings(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findParents(final Member member) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("from RELATIVES").setInteger("POST_ID", member.getMotherId()).setInteger("POST_ID", member.getFatherId());
                return query.list();
            }
        });
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findChildren(final Member member) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("from RELATIVES").setInteger("MOTHER_ID", member.getId()).setInteger("FATHER_ID", member.getId());
                return query.list();
            }
        });
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findInGenerationRange() {
		// TODO Auto-generated method stub
		return null;
	}
}
