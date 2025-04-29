package org.big.service;

public interface LikeService {
	
	void toggleLike(Long review_id, Long user_id);

	int getLikeCount(Long review_id);

	boolean hasLiked(Long review_id, Long user_id);
	
}
