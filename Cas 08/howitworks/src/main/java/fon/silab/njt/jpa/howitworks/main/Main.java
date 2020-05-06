/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.main;

import fon.silab.njt.jpa.howitworks.config.MyApplicationConfig;
import fon.silab.njt.jpa.howitworks.entity.CityEntity;
import fon.silab.njt.jpa.howitworks.entity.ContactPersonEntity;
import fon.silab.njt.jpa.howitworks.entity.ManufacturerEntity;
import fon.silab.njt.jpa.howitworks.entity.ProductCategoryEntity;
import fon.silab.njt.jpa.howitworks.service.CityService;
import fon.silab.njt.jpa.howitworks.service.ManufacturerService;
import fon.silab.njt.jpa.howitworks.service.ProductCategoryService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dusan
 */
@Component
public class Main {

    private final CityService cityService;
    private final ProductCategoryService productCategoryService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public Main(CityService cityService,
                ProductCategoryService productCategoryService,
                ManufacturerService manufacturerService ) {
//        cityService = new CityService();
//        productCategoryService = new ProductCategoryService();
//        manufacturerService = new ManufacturerService();

        this.cityService = cityService;
        this.productCategoryService = productCategoryService;
        this.manufacturerService = manufacturerService;
    }

    public static void main(String[] args) {
        BeanFactory container = new AnnotationConfigApplicationContext(MyApplicationConfig.class);
        Main main = container.getBean(Main.class);
        //Main main = new Main();
        //main.workWithCityEntity();
        //main.workWithProductCategory();

        main.workWithManufacturer();
    }

    private void workWithCityEntity() {
        //saveCityEntity(11000L, "Beograd");
        //saveOrUpdateCityEntity(11000L, "Beograd");
        updateCityEntity(11000L, "Novi Beograd");
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
        saveProductCategory("category - 1", "This is category 1.");
    }

    private void saveProductCategory(String name, String description) {
        ProductCategoryEntity productCategory = new ProductCategoryEntity(name, description);
        productCategory = productCategoryService.save(productCategory);
        System.out.println("New product category id: " + productCategory.getId());
    }

    private void workWithManufacturer() {
//        saveManufacturer(null,"manufacturer-3",new CityEntity(11002L, "City - 11002"));
//        saveOrUpdateManufacturer(2L, "manufacturer-5", new CityEntity(11006L, "City - 11006"));

//        saveOrUpdateManufacturerWithPersons(3L, "manufacturer 10", new CityEntity(11006L, "City 11006"));
//        findManufacturer(3L);
        
        deleteManufacturer(3L,"manufacturer-1",new CityEntity(11002L, "City - 11002"));
    }

    private void saveManufacturer(Long id, String name, CityEntity cityEntity) {
        ManufacturerEntity manufacturer = new ManufacturerEntity(id, name, cityEntity);
        manufacturerService.save(manufacturer);
    }

    private void saveOrUpdateManufacturer(Long id, String name, CityEntity cityEntity) {
        ManufacturerEntity manufacturer = new ManufacturerEntity(id, name, cityEntity);
        try {
            manufacturer = manufacturerService.saveOrUpdate(manufacturer);
            System.out.println(manufacturer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void saveOrUpdateManufacturerWithPersons(Long id, String name, CityEntity cityEntity) {
        ManufacturerEntity manufacturer = new ManufacturerEntity(id, name, cityEntity);
        //manufacturer.addPerson(new ContactPersonEntity(null, "Pera", "Peric"));
        //manufacturer.addPerson(new ContactPersonEntity(null, "Laza", "Lazic"));
        manufacturer.addPerson(new ContactPersonEntity(null, "J", "J"));
        manufacturer.addPerson(new ContactPersonEntity(2L, "Z", "Z"));

        try {
            manufacturer = manufacturerService.saveOrUpdate(manufacturer);
            System.out.println(manufacturer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void findManufacturer(Long id) {
        System.out.println(manufacturerService.findById(id));
    }

    private void deleteManufacturer(Long id, String name, CityEntity cityEntity) {
         ManufacturerEntity manufacturer = new ManufacturerEntity(id, name, cityEntity);
        try {
            manufacturerService.delete(manufacturer);
            System.out.println("Manufacturer is deleted!");
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
    }

}
