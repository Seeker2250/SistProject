package org.sist.sistproject.manager;

import java.time.LocalDateTime;
import java.util.Optional;

import org.sist.sistproject.exception.DataNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service

public class FaqServiceImpl implements FaqService{
	
	private final FaqRepository faqRepository;
	
	public void register(String title, String content) {
		
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setCreateDate(LocalDateTime.now());
		this.faqRepository.save(faq);
	}
	
	
	@Transactional
    public Faq getFaq(Integer id) {
        Optional<Faq> faq = this.faqRepository.findById(id);
        if(faq.isPresent()) {
            Faq faqEntity = faq.get();
            faqEntity.increaseViewCount();  // 조회수 증가
            this.faqRepository.save(faqEntity);  // 저장
            return faqEntity;
        } else {
            throw new DataNotFoundException("faq not found");
        }
    }
}
