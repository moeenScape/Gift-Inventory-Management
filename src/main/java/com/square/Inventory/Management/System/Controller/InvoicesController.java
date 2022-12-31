package com.square.Inventory.Management.System.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/inventory")
public interface InvoicesController {

    @PostMapping(path = "/generate/invoices")
    ResponseEntity<String> generateInvoices(@RequestBody(required = true) Map<String,String > requestMap);
}
