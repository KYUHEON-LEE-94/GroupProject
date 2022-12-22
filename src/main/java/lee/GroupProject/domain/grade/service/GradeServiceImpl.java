package lee.GroupProject.domain.grade.service;

import lee.GroupProject.domain.contact.entitiy.Contact;
import lee.GroupProject.domain.contact.repository.JpaContactRepository;
import lee.GroupProject.domain.contact.service.ContactService;
import lee.GroupProject.domain.grade.entity.Grade;
import lee.GroupProject.domain.grade.repository.JpaGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    @Autowired
    private JpaGradeRepository jpaGradeRepository;

    @Override
    public List<Grade> findAllByProductNum(String productNum) {
        return jpaGradeRepository.findAllByProductNum(productNum);
    }

    @Override
    public List<Grade> findAllByProductNumAndMemberId(String productNum, String memberId) {
        return jpaGradeRepository.findAllByProductNumAndMemberId(productNum, memberId);
    }
}
