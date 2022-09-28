package org.excercise.service;


import org.excercise.domain.Category;
import org.springframework.stereotype.Component;

@Component
public interface CategoryShopService {
    public int createCategoryShop(Category cat);
    public Category getCategoryShop(int id);
    public Category updateCategoryShop(int id, Category cat);
    public String deleteCategoryShop(int id);
}