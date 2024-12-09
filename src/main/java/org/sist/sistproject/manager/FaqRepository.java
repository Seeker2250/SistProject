package org.sist.sistproject.manager;

import org.springframework.data.jpa.repository.JpaRepository;

//																				<CRUD할 Entity, 그 테이블의 pk 타입>																	
public interface FaqRepository extends JpaRepository<Faq, Integer>{

	Faq findByTitle(String title);
	
	
	
}//interface
