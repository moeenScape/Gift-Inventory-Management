package com.square.Inventory.Management.System.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@RequestMapping(path = "/invoices")
public interface InvoicesController {

    @PostMapping(path = "/generate")
    ResponseEntity<String> generateInvoices(@RequestBody Map<String,String > requestMap);
}
