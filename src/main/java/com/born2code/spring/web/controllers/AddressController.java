package com.born2code.spring.web.controllers;

import com.born2code.spring.web.dao.Address;
import com.born2code.spring.web.dao.AddressDAO;
import com.born2code.spring.web.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("address")
public class AddressController {

    private AddressService addressService;
    private AddressDAO addressDAO;

    @RequestMapping("/view")
    public String view(Model model){

        List<Address> address = addressService.getCurrent();

        model.addAttribute("address", address);

        return "address_view";
    }
    @RequestMapping("/insert")
    public String insert(Model model){

        model.addAttribute(new Address());

        return "address_insert";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, Address address, BindingResult result){

//        if( result.hasErrors() ) {
//            return "address_insert";
//        }

//        address.setPostcode();
        //addressDAO.createAddress(address);

        System.out.println("Street: " + address.getStreet());
        System.out.println("City: " + address.getCity());
        System.out.println("Post: " + address.getPostcode());
        System.out.println("Country: " + address.getCountry());
        addressService.create(address);
        return "address_view";
    }

    @RequestMapping("/update")
    public String update(){
        return "address_update";
    }
//    public boolean delete(){
//        return false;
//    }
}
