package lee.GroupProject.domain.member.repository;

import lee.GroupProject.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, String>{
	// 아이디와 비밀번호에 의한 조회
	public Member findByMemberIdAndMemberPw(String memberId, String memberPw);

	// 아이디 또는 이름에 의한 검색 - 목록 페이징 처리
	Page<Member> findAllByMemberIdOrMemberNameContaining(String memberId, String memberName, Pageable pageable);
}
