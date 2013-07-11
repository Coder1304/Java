package base;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import base.dao.MemberDAO;
import base.entities.Member;

@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
//@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class MemberRepositoryTest extends AbstractTestNGSpringContextTests {

	@Autowired
	MemberDAO repository;
	
	@Test
	public void test() {
		/*Member post = new Member();
		post.setBirdthDate(new Date());
		post.setName("Joe");
		
		repository.save(post);
		
		Member dbpost = repository.findOne(post.getId());
		assertThat(dbpost).isNotNull();
		System.out.println(dbpost.getName());
		*/
	}

}
