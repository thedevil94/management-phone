package com.huucong.service.impl;

import com.huucong.model.Category;
import com.huucong.model.Phone;
import com.huucong.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhoneServiceImpl implements com.huucong.service.PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }

    @Override
    public Phone findById(int id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void delete(int id) {
        phoneRepository.delete(id);
    }

    @Override
    public Page<Phone> findAllByCategory(Category category, Pageable pageable) {
        return phoneRepository.findAllByCategory(category, pageable);
    }

    @Override
    public Page<Phone> findAllByOrderByPriceAsc(Pageable pageable) {
        return phoneRepository.findAllByOrderByPriceAsc(pageable);
    }

//    @Override
//    public Page<Phone> findAllByCategoryOrderByPriceAsc(Category category, Pageable pageable) {
//        return phoneRepository.findAllByCategoryOrderByPriceAsc(category, pageable);
//    }

    @Override
    public Page<Phone> findAllByOrderByPriceDesc(Pageable pageable) {
        return phoneRepository.findAllByOrderByPriceDesc(pageable);
    }


}
