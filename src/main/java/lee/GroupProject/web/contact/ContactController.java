package lee.GroupProject.web.contact;

import lee.GroupProject.domain.contact.entitiy.Contact;
import lee.GroupProject.domain.contact.service.ContactServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/request/form")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping()
    public String doGet(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact",contact);

        return "includes/contact";
    }

    /* 입력받은 값 저장 후 리다이렉트 */
    @PostMapping()
    public String ContactForm(@ModelAttribute("Contact") Contact contact, Model model){
        contactService.addContact(contact);
        return "redirect:/request/form";
    }



}
