package lee.GroupProject.web.contact;

import lee.GroupProject.domain.contact.dto.ContactForm;
import lee.GroupProject.domain.contact.entitiy.Contact;
import lee.GroupProject.domain.contact.service.ContactServiceImpl;
import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/request/form")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping()
    public String doGet(HttpServletRequest request, Model model){
        Contact contactForm = new Contact();
        model.addAttribute("contactForm",contactForm);

        //Session으로 loginMember를 얻어와서, 있으면 members 객체를 전달 / 없으면 null값으로 전달
        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");


        if(session.getAttribute("loginMember") != null){
            model.addAttribute("members",members);
        }else{
            Optional<Members> FindnonMember = memberService.findMember("Nonmember");
            model.addAttribute("nonMemberId", FindnonMember.get().getMemberId());
        }


        return "includes/contact";
    }

    /* 입력받은 값 저장 후 리다이렉트 */
    @PostMapping()
    public String ContactForm(@Validated @ModelAttribute("contactForm") ContactForm contactForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            return "includes/contact";
        }

        Contact contact = new Contact();
        contact.setContactEmail(contactForm.getContactEmail());
        contact.setContactName(contactForm.getContactName());
        contact.setMemberId(contactForm.getMemberId());
        contact.setTitle(contactForm.getTitle());
        contact.setContent(contactForm.getContent());

        contactService.addContact(contact);
        redirectAttributes.addAttribute("confirm",true);
        return "redirect:/request/form";
    }



}
