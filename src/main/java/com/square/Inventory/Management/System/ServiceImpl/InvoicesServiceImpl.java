package com.square.Inventory.Management.System.ServiceImpl;

import com.square.Inventory.Management.System.Entity.Invoices;
import com.square.Inventory.Management.System.Repository.InvoicesRepository;
import com.square.Inventory.Management.System.Service.InvoicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class InvoicesServiceImpl implements InvoicesService {

    private final InvoicesRepository invoicesRepository;

    public InvoicesServiceImpl(InvoicesRepository invoicesRepository) {
        this.invoicesRepository = invoicesRepository;
    }

    @Override
    public ResponseEntity<String> generateInvoices(Map<String, String> requestMap) {
        invoicesRepository.save(getFromMap(requestMap));
        return new ResponseEntity<>("add invoices", HttpStatus.OK);
    }

    private Invoices getFromMap(Map<String, String> requestMap) {
        Invoices invoices = new Invoices();
        invoices.setCreateAt(new Date());
        invoices.setDepotName(requestMap.get("DepotName"));
        invoices.setProductDetails(requestMap.get("productDetails"));
        invoices.setWarehouseName(requestMap.get("warehouseName"));
        return invoices;
    }
}
