package com.born2code.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.born2code.spring.web.dao.Address;
import com.born2code.spring.web.dao.AddressDAO;

import java.util.List;

@Service("addressService")
public class AddressService {
    private AddressDAO addressDAO;

    @Autowired
    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public List<Address> getCurrent() {
        return addressDAO.getAddresses();

    }
    public void create(Address address){
        addressDAO.createAddress(address);
    }
}
