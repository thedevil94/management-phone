package com.huucong.controller;

import com.huucong.model.Category;
import com.huucong.model.Phone;
import com.huucong.service.CategoryService;
import com.huucong.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories () {
        return categoryService.findAll();
    }

    @GetMapping("/phone")
    public ModelAndView listPhone(@PageableDefault(size = 2) Pageable pageable){
        Page<Phone> phones = phoneService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    @GetMapping("/create-phone")
    public ModelAndView createFormPhone(){
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("/create-phone")
    public ModelAndView createPhone(@ModelAttribute("phone") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("redirect:/phone");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @GetMapping("/edit-phone/{id}")
    public ModelAndView editFormPhone(@PathVariable int id){
        Phone phone = phoneService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/phone/edit");
        modelAndView.addObject("phone", phone);
        return modelAndView;
    }

    @PostMapping("/edit-phone")
    public ModelAndView editPhone(@ModelAttribute("category") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("redirect:/phone");
        return modelAndView;
    }

    @GetMapping("/delete-phone/{id}")
    public String deletePhone(@PathVariable int id){
        phoneService.delete(id);
        return "redirect:/phone";
    }

    @GetMapping("/searchByCategory")
    public ModelAndView getPhoneByCategory(@RequestParam("srch") String search, @PageableDefault(size = 4) Pageable pageable){
        Category category = categoryService.findById(Integer.parseInt(search));
        Page<Phone> phones = phoneService.findAllByCategory(category, pageable);
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        modelAndView.addObject("srch",search);
        return modelAndView;
    }

    @GetMapping("/sortByPriceASC")
    public ModelAndView getPhoneByPriceASC(@RequestParam("srch") String search, @PageableDefault(size = 4) Pageable pageable){
        Page<Phone> phones = phoneService.findAllByOrderByPriceAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    @GetMapping("/sortByPriceDESC")
    public ModelAndView getPhoneByPriceDESC(@PageableDefault(size = 4) Pageable pageable){
        Page<Phone> phones = phoneService.findAllByOrderByPriceDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones",phones);
        return modelAndView;
    }
}
