package com.example.backend.controller;

import com.example.backend.entity.Bill;
import com.example.backend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> list() {
        return billService.getAllBills();
    }

    @PostMapping
    public Bill create(@RequestBody Bill bill) {
        return billService.save(bill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getOne(@PathVariable Long id) {
        return billService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> update(@PathVariable Long id, @RequestBody Bill bill) {
        return ResponseEntity.ok(billService.update(id, bill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        billService.delete(id);
        return ResponseEntity.ok().build();
    }
}