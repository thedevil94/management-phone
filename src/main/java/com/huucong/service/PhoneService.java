package com.huucong.service;

import com.huucong.model.Category;
import com.huucong.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    Page<Phone> findAll(Pageable pageable);

    Phone findById(int id);

    void save(Phone phone);

    void delete(int id);

    Page<Phone> findAllByCategory(Category category, Pageable pageable);

    Page<Phone> findAllByOrderByPriceAsc(Pageable pageable);

//    Page<Phone> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    Page<Phone> findAllByOrderByPriceDesc(Pageable pageable);

}
