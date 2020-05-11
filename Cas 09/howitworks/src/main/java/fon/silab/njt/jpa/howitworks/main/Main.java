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
import fon.silab.njt.jpa.howitworks.entity.MyEntity;
import fon.silab.njt.jpa.howitworks.entity.ProductCategoryEntity;
import fon.silab.njt.jpa.howitworks.entity.ProductEntity;
import fon.silab.njt.jpa.howitworks.entity.inheritance.BusinessPartnerEntity;
import fon.silab.njt.jpa.howitworks.entity.inheritance.LegalEntity;
import fon.silab.njt.jpa.howitworks.entity.inheritance.NaturalEntity;
import fon.silab.njt.jpa.howitworks.service.BusinessPartnerService;
import fon.silab.njt.jpa.howitworks.service.CityService;
import fon.silab.njt.jpa.howitworks.service.ManufacturerService;
import fon.silab.njt.jpa.howitworks.service.ProductCategoryService;
import fon.silab.njt.jpa.howitworks.service.ProductService;
import java.util.List;
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
    private final ProductService productService;
    private final BusinessPartnerService businessPartnerService;

    @Autowired
    public Main(CityService cityService,
                ProductCategoryService productCategoryService,
                ManufacturerService manufacturerService,
                ProductService productService,
                BusinessPartnerService businessPartnerService) {

        this.cityService = cityService;
        this.productCategoryService = productCategoryService;
        this.manufacturerService = manufacturerService;
        this.productService = productService;
        this.businessPartnerService = businessPartnerService;
    }

    public static void main(String[] args) {
        BeanFactory container = new AnnotationConfigApplicationContext(MyApplicationConfig.class);
        Main main = container.getBean(Main.class);
        //Main main = new Main();
        main.workWithCityEntity();
        //main.workWithProductCategory();
        //main.workWithManufacturer();

        //main.workWithProduct();
        //main.workWithBusinessPartner();
    }

    private void workWithCityEntity() {
        //saveCityEntity(11000L, "Beograd");
        //saveOrUpdateCityEntity(11000L, "Beograd");
        //updateCityEntity(11000L, "Novi Beograd");
        //updateCityEntity(13000L, "Pancevo");
        printAllCities();
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
        //saveManufacturer(null,"manufacturer-3",new CityEntity(11002L, "City - 11002"));
        //saveOrUpdateManufacturer(100L, "manufacturer-9", new CityEntity(11006L, "City 11006"));

        //saveOrUpdateManufacturerWithPersons(10L, "manufacturer 10", new CityEntity(11006L, "City 11006"));
        findManufacturer(8L);

        //deleteManufacturer(10L,"manufacturer-1",new CityEntity(11002L, "City - 11002"));
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
        manufacturer.addPerson(new ContactPersonEntity(11L, "Z", "Zikic"));

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

    private void workWithProduct() {
        saveProduct();
        //updateProduct(1L);
        //deleteProduct(1L);
    }

    private void saveProduct() {
        ProductEntity product = new ProductEntity();
        product.setName("Product - 1-4");
        product.setManufacturer(manufacturerService.findById(5L));

        //product.getProductCategories().add(productCategoryService.findById(1L));
        //product.getProductCategories().add(productCategoryService.findById(2L));
        product.addProductCategory(productCategoryService.findById(1L));
        product.addProductCategory(productCategoryService.findById(4L));
        productService.save(product);
    }

    private void updateProduct(Long id) {
        ProductEntity product = new ProductEntity();
        product.setId(id);
        product.setName("Product - 11");
        product.setManufacturer(manufacturerService.findById(6L));
        product.getProductCategories().add(productCategoryService.findById(1L));
        //product.getProductCategories().add(productCategoryService.findById(2L));
        product.getProductCategories().add(productCategoryService.findById(3L));
        product.getProductCategories().add(productCategoryService.findById(4L));

        productService.update(product);
    }

    private void deleteProduct(Long id) {
        productService.deleteById(id);
    }

    private void workWithBusinessPartner() {
        //saveLegalEntity();
        //saveNaturalEntity();

        //printAllBusinessPartners();
        //printAllNaturalBusinessPartnes();
        printAllLegalBusinessPartnes();
    }

    private void saveNaturalEntity() {
        BusinessPartnerEntity natural = new NaturalEntity("0000000000001", "Pera", "Peric");
        businessPartnerService.save(natural);
    }

    private void saveLegalEntity() {
        BusinessPartnerEntity legal = new LegalEntity("00000001", "Legal - 1");
        businessPartnerService.save(legal);
    }

    private void printAllBusinessPartners() {
        List<BusinessPartnerEntity> partners = businessPartnerService.findAll();
        partners.stream().forEach((partner) -> {
            System.out.println(partner);
        });
    }

    private void printAllNaturalBusinessPartnes() {
        List<NaturalEntity> partners = businessPartnerService.getAllNatural();
        partners.stream().forEach((partner) -> {
            System.out.println(partner);
        });
    }

    private void printAllLegalBusinessPartnes() {
        List<BusinessPartnerEntity> partners = businessPartnerService.findAllLegal();
        partners.stream().forEach((partner) -> {
            System.out.println(partner);
        });
    }

    private void printAllCities() {
        List<MyEntity> cities = cityService.findAll(CityEntity.class);
        for (MyEntity city : cities) {
            System.out.println(city);
        }
    }
}
