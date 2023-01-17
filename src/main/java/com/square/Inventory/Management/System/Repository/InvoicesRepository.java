package com.square.Inventory.Management.System.Repository;

import com.square.Inventory.Management.System.Entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoicesRepository extends JpaRepository<Invoices,Long> {
}
