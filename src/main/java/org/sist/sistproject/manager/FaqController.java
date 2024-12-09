package org.sist.sistproject.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor//final로 자동 주입 마치 autowired
public class FaqController {
	
	
	private final FaqService faqService;
	
	@GetMapping("/registerFAQ")
	public String createFAQ(@Valid String title, @Valid String content) {
		return null;
	}
	
}//class
