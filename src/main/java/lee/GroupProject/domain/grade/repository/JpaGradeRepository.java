package lee.GroupProject.domain.grade.repository;

import lee.GroupProject.domain.grade.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaGradeRepository extends JpaRepository<Grade, Integer> {

    public List<Grade> findAllByProductNum(String productNum);

    public List<Grade>  findAllByProductNumAndMemberId(String productNum, String memberId);

}
