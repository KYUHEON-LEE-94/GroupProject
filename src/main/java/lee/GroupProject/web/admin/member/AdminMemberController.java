package lee.GroupProject.web.admin.member;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Admin Page Controller
 * @author LEE KYUHEON
 */
@Slf4j
@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private ProductServiceImpl productService;

    // 검색 및 페이징 처리 추가 회원 목록
    @GetMapping
    /* default page = 0, default size = 10 */
    public String listBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "memberId", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model) {

        Page<Members> page = memberService.findMembers(search, pageable);

        long totalElements = page.getTotalElements();
        List<Members> list = page.getContent();

        int requestPage = page.getPageable().getPageNumber() + 1;
        int totalPage = page.getTotalPages();
        int startPage = Math.max(1, requestPage - 4);
        int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
        boolean hasPrevious = page.hasPrevious();
        boolean hasNext = page.hasNext();

        model.addAttribute("totalElements", totalElements);
        model.addAttribute("list", list);
        model.addAttribute("requestPage", requestPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("hasPrevious", hasPrevious);
        model.addAttribute("hasNext", hasNext);

        return "admin/includes/list";
    }

    @GetMapping("/{memberId}")
    public String MemberList(@PathVariable String memberId, Model model){
        Optional<Members> optional = memberService.findMember(memberId);
        model.addAttribute("member", optional.get());

        return "admin/includes/view";
    }


}
