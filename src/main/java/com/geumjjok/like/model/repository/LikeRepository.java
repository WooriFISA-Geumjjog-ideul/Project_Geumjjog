package com.geumjjok.like.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geumjjok.like.model.entity.PostLike;

@Repository
public interface LikeRepository extends JpaRepository<PostLike, Integer>{

}
