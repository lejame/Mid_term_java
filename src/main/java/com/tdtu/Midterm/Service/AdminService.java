package com.tdtu.Midterm.Service;

import com.tdtu.Midterm.Models.Model_Caterory;
import com.tdtu.Midterm.Models.Model_Phone;
import com.tdtu.Midterm.Models.Model_Phone_Brand;
import com.tdtu.Midterm.Models.Model_UserShoppingCart;
import com.tdtu.Midterm.Repository.CateroryRepository;
import com.tdtu.Midterm.Repository.ManagementProductRepository;
import com.tdtu.Midterm.Repository.ModelPhoneBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AdminService {
    private final ManagementProductRepository managementProductRepository;
    private final ModelPhoneBrandRepository modelPhoneBrandRepository;

    private final CateroryRepository cateroryRepository;


    @Autowired
    public AdminService(ManagementProductRepository managementProductRepository, ModelPhoneBrandRepository modelPhoneBrandRepository, CateroryRepository cateroryRepository){
        this.managementProductRepository = managementProductRepository;
        this.modelPhoneBrandRepository = modelPhoneBrandRepository;
        this.cateroryRepository = cateroryRepository;
    }
    public void add_model_phone(Model_Phone modelPhone){managementProductRepository.save(modelPhone);}

    public List<Model_Phone> getbyAll(){
        return managementProductRepository.findAll();
    }
    public List<Model_Caterory> getAllByCaterory(){return cateroryRepository.findAll();}
    public void addModel(Model_Phone phone){
        managementProductRepository.save(phone);
    }
    public Optional<Model_Phone_Brand> getByIdBrand(int id){
        return modelPhoneBrandRepository.findById(id);
    }
    public Optional<Model_Caterory> getByIdCaterory(int id){
        return cateroryRepository.findById(id);
    }

    public Optional<Model_Phone> getByIdPhone(int id){
        return managementProductRepository.findById(id);
    }

    public List<Model_Phone_Brand> getAllByBrand(){
       return modelPhoneBrandRepository.findAll();
    }
    public boolean deletePhoneById(int id){
        try{
            managementProductRepository.deleteById(id);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Model_Caterory> getCaterory(){
        return cateroryRepository.findAll();
    }
    public void updateProducts(int id,String img,String name,String color,int price,String description,int caterory,int brand){
        Optional<Model_Phone> phone = managementProductRepository.findById(id);
        phone.get().setName(name);
        phone.get().setImg(img);
        phone.get().setPrice(price);
        phone.get().setDescription(description);
        phone.get().setModel_caterory(cateroryRepository.findById(caterory).get());
        phone.get().setPhoneBrand(modelPhoneBrandRepository.findById(brand).get());
        phone.get().setColor(color);
        managementProductRepository.save(phone.get());
    }
}
