package base.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import base.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
