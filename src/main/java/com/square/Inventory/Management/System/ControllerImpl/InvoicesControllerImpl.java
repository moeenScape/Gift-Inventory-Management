package com.square.Inventory.Management.System.ControllerImpl;

import com.square.Inventory.Management.System.Constant.InventoryConstant;
import com.square.Inventory.Management.System.Controller.InvoicesController;
import com.square.Inventory.Management.System.IMSUtils.InventoryUtils;
import com.square.Inventory.Management.System.Service.InvoicesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InvoicesControllerImpl implements InvoicesController {
    private final InvoicesService invoicesService;

    public InvoicesControllerImpl(InvoicesService invoicesService) {
        this.invoicesService = invoicesService;
    }

    @Override
    public ResponseEntity<String> generateInvoices(Map<String, String> requestMap) {
            return invoicesService.generateInvoices(requestMap);
    }
}
