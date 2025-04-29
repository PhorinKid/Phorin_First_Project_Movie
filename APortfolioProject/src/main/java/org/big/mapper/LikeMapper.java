package org.big.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {

	void insertLike(@Param("review_id") Long review_id, @Param("user_id") Long user_id);

	void deleteLike(@Param("review_id") Long review_id, @Param("user_id") Long user_id);

	int countLikes(@Param("review_id") Long review_id);

	int existsLike(@Param("review_id") Long review_id, @Param("user_id") Long user_id);

}
