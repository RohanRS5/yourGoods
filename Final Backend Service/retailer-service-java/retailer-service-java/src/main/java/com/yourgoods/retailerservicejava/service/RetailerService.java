package com.yourgoods.retailerservicejava.service;

import com.yourgoods.retailerservicejava.VO.RetailerLogin;
import com.yourgoods.retailerservicejava.models.ProductRequest;
import com.yourgoods.retailerservicejava.models.Retailer;
import com.yourgoods.retailerservicejava.repository.ProductRequestRepository;
import com.yourgoods.retailerservicejava.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetailerService {
    private final RetailerRepository retailerRepository;
    private final ProductRequestRepository productRequestRepository;

    @Autowired
    public RetailerService(RetailerRepository retailerRepository, ProductRequestRepository productRequestRepository) {
        this.retailerRepository = retailerRepository;
        this.productRequestRepository = productRequestRepository;
    }

    public Retailer registerRetailer(Retailer retailer) {
        return retailerRepository.save(retailer);
    }

    public List<Retailer> getAllRetailers() {
        return retailerRepository.findAll();
    }

    public Optional<Retailer> getRetailerById(String retailerId) {
        return retailerRepository.findById(retailerId);
    }

    public Boolean deleteRetailerById(String retailerId) {
        Optional<Retailer> retailerOptional = retailerRepository.findById(retailerId);
        if(retailerOptional.isPresent()){
            retailerRepository.deleteById(retailerId);
            return true;
        }
        return false;
    }

    public ResponseEntity<Retailer> updateRetailerDetails(String retailerId, Retailer retailer) {
        Optional<Retailer> retailerOptional = retailerRepository.findById(retailerId);
        if(retailerOptional.isPresent()){
            Retailer _retailer = retailerOptional.get();
            _retailer.setRetailerName(retailer.getRetailerName());
            _retailer.setRetailerPhone(retailer.getRetailerPhone());
            _retailer.setRetailerAddress(retailer.getRetailerAddress());
            _retailer.setRetailerPassword(retailer.getRetailerPassword());
            _retailer.setRetailerPincode(retailer.getRetailerPincode());
            _retailer.setRetailerEmail(retailer.getRetailerEmail());
            return new ResponseEntity<>(retailerRepository.save(_retailer),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //RETAILER REGISTRAION
    public ResponseEntity<Boolean> saveRetailer(Retailer retailer) {
        Optional<Retailer> optionalRetailer = retailerRepository.findByRetailerEmail(retailer.getRetailerEmail());
        if(optionalRetailer.isPresent()){
                System.out.println("Email Already Exists! ");
                return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_ACCEPTABLE);
            }
        retailerRepository.save(retailer);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
    // LOG IN
//    public RetailerLogin validateRetailer(RetailerLogin retailer) {
//        Optional<Retailer> optionalRetailer = retailerRepository.find(retailer.getRetailerEmail());
//
//        List<Retailer> retailers = getAllRetailers();
//        for(Retailer re : retailers){
//            if(re.getRetailerEmail().equals(retailer.getRetailerEmail()) && re.getRetailerPassword().equals(retailer.getRetailerPassword())){
//                System.out.println("Login Successfully");
//                //System.out.println(re);
//                return re;
//            }
//        }
//        System.out.println("Please Register! No Email Found!! ");
//        return null;
//    }


    public ProductRequest newProductRequest(ProductRequest productRequest) {
        return productRequestRepository.save(productRequest);
    }

    public Boolean validateRetailer(RetailerLogin retailer) {
        Optional<Retailer> optionalRetailer = retailerRepository.findByRetailerEmail(retailer.getRetailerEmail());
        if(optionalRetailer.isPresent()){
            Retailer _retailer =optionalRetailer.get();
            if(_retailer.getRetailerPassword().equals(retailer.getRetailerPassword())){
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<ProductRequest> getProductRequest(String requestId) {
        Optional<ProductRequest> optionalProductRequest = productRequestRepository.findById(requestId);
        if (optionalProductRequest.isPresent()){
            ProductRequest _productrequest = optionalProductRequest.get();
            return new ResponseEntity<>(_productrequest,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<ProductRequest>> getAllRequests() {
        return new ResponseEntity<>(productRequestRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Optional<Retailer>> getRetailerByEmail(String emailId) {
        return new ResponseEntity<>(retailerRepository.findByRetailerEmail(emailId),HttpStatus.OK);

    }
}
