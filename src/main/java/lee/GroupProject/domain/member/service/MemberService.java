package lee.GroupProject.domain.member.service;

import java.util.List;
import java.util.Optional;

import lee.GroupProject.domain.member.entity.Members;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
	
	/** 회원가입 */
	public String register(Members member);
	
	/** 회원 인증 */
	public Members isMember(String id, String password);
	
	/** 회원 상세 */
	public Optional<Members> findMember(String id);

	/** 전체 회원 조회 */
	public List<Members> findMembers();
	
	/** 검색, 페이징 처리 회원 조회 */
	public Page<Members> findMembers(String searchValue, Pageable pageable);
}
