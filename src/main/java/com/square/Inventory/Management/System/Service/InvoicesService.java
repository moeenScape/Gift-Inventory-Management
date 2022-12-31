package com.square.Inventory.Management.System.Service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface InvoicesService {
    ResponseEntity<String> generateInvoices(Map<String, String> requestMap);
}
