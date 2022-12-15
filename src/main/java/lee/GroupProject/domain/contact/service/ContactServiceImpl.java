package lee.GroupProject.domain.contact.service;

import lee.GroupProject.domain.contact.entitiy.Contact;
import lee.GroupProject.domain.contact.repository.JpaContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    private JpaContactRepository jpaContactRepository;


    @Override
    public Contact addContact(Contact contact) {
        return jpaContactRepository.save(contact);
    }


}
