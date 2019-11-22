package com.huucong.repository;

import com.huucong.model.Category;
import com.huucong.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Integer> {
    Page<Phone> findAllByCategory(Category category, Pageable pageable);

    Page<Phone> findAllByOrderByPriceAsc(Pageable pageable);
    Page<Phone> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    Page<Phone> findAllByOrderByPriceDesc(Pageable pageable);
}
