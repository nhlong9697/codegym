package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.BlogService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }
    @GetMapping("/")
    public ModelAndView listBlog(
            @RequestParam("search") Optional<String> search,
            @PageableDefault(size = 3, direction = Sort.Direction.DESC, sort = "id") Pageable pageable
    ) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContaining(search.get(),pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog is created");
        return modelAndView;
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }
    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-blog")
    public String deleteCustomer(@ModelAttribute("customer") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/";
    }
}
