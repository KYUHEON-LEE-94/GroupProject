package lee.GroupProject.domain.grade.service;

import lee.GroupProject.domain.contact.entitiy.Contact;
import lee.GroupProject.domain.grade.entity.Grade;

import java.util.List;

public interface GradeService {

    public List<Grade> findAllByProductNum(String productNum);

    public List<Grade>  findAllByProductNumAndMemberId(String productNum, String memberId);



}
