package org.big.service;

import org.big.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper;

	@Override
	public void toggleLike(Long review_id, Long user_id) {
		// TODO Auto-generated method stub
		if (likeMapper.existsLike(review_id, user_id) > 0) {
			likeMapper.deleteLike(review_id, user_id);
			System.out.println("========== 좋아요 취소 ==========");
		} else {
			likeMapper.insertLike(review_id, user_id);
			System.out.println("========== 좋아요 추가 ==========");
		}
	}

	@Override
	public int getLikeCount(Long review_id) {
		// TODO Auto-generated method stub
		return likeMapper.countLikes(review_id);
	}

	@Override
	public boolean hasLiked(Long review_id, Long user_id) {
		// TODO Auto-generated method stub
	    return likeMapper.existsLike(review_id, user_id) > 0; // boolean 변환
	}

}
