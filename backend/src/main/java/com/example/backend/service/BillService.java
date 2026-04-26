package com.example.backend.service;

import com.example.backend.entity.Bill;
import com.example.backend.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAllByOrderByCreateTimeDesc();
    }
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    public void delete(Long id) {
        billRepository.deleteById(id);
    }

    public Bill update(Long id, Bill newBill) {
        Bill bill = billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("账单不存在"));
        bill.setCategory(newBill.getCategory());
        bill.setAmount(newBill.getAmount());
        bill.setType(newBill.getType());
        bill.setRemark(newBill.getRemark());
        return billRepository.save(bill);
    }

}
