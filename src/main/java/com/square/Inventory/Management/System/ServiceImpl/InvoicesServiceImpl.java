package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.Entity.Invoices;
import com.square.Inventory.Management.System.Repository.InvoicesRepository;
import com.square.Inventory.Management.System.Service.InvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Map;

public class InvoicesServiceImpl implements InvoicesService {
    @Autowired
    InvoicesRepository invoicesRepository;
    @Override
    public ResponseEntity<String> generateInvoices(Map<String, String> requestMap) {
        invoicesRepository.save(getFromMap(requestMap));
        return new ResponseEntity<>("add invoices", HttpStatus.OK);
    }

    private Invoices getFromMap(Map<String, String> requestMap) {
        Invoices invoices=new Invoices();
        invoices.setCreateDate(new Date());
        invoices.setDepotName((String) requestMap.get("DepotName"));
        invoices.setProductDetails((String) requestMap.get("productDetails"));
        invoices.setWarehouseName((String) requestMap.get("warehouseName"));
        return invoices;
    }
}
