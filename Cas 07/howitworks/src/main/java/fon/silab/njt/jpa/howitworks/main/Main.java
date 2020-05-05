/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.main;

import fon.silab.njt.jpa.howitworks.entity.CityEntity;
import fon.silab.njt.jpa.howitworks.entity.ProductCategoryEntity;
import fon.silab.njt.jpa.howitworks.service.CityService;
import fon.silab.njt.jpa.howitworks.service.ProductCategoryService;

/**
 *
 * @author Dusan
 */
public class Main {

    private final CityService cityService;
    private final ProductCategoryService productCategoryService;

    public Main() {
        cityService = new CityService();
        productCategoryService = new ProductCategoryService();
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.workWithCityEntity();
        
        main.workWithProductCategory();
    }

    private void workWithCityEntity() {
//        saveCityEntity(11000L, "Beograd");
//        saveOrUpdateCityEntity(11000L, "Novi Beograd");
//        updateCityEntity(11000L, "Stari Beograd");
        updateCityEntity(13000L, "Pancevo");
    }

    private void saveCityEntity(Long code, String name) {
        CityEntity entity = new CityEntity(code, name);
        cityService.save(entity);
    }

    private void saveOrUpdateCityEntity(Long code, String name) {
        CityEntity entity = new CityEntity(code, name);
        cityService.saveOrUpdate(entity);
    }

    private void updateCityEntity(Long code, String name) {
        CityEntity entity = new CityEntity(code, name);
        cityService.update(entity);
    }

    private void workWithProductCategory() {
        saveProductCategory("category - 2", "This is category 2.");
    }

    private void saveProductCategory(String name, String description) {
        ProductCategoryEntity productCategory = new ProductCategoryEntity(name,description);
        productCategory = productCategoryService.save(productCategory);
        System.out.println("New product category id: " + productCategory.getId());
    }
}
