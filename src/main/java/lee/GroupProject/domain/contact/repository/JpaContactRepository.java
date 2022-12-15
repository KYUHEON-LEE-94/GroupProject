package lee.GroupProject.domain.contact.repository;

import lee.GroupProject.domain.contact.entitiy.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaContactRepository extends JpaRepository<Contact, Integer> {

    public String findByMemberId(String memberId);


}
