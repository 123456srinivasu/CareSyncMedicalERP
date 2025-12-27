package com.medical.caresync.controller;

import com.medical.caresync.entities.Expense;
import com.medical.caresync.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Integer id) {
        return expenseService.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Integer id, @RequestBody Expense expenseDetails) {
        return expenseService.getExpenseById(id)
                .map(expense -> {
                    expense.setAssetName(expenseDetails.getAssetName());
                    expense.setQuantity(expenseDetails.getQuantity());
                    expense.setAmount(expenseDetails.getAmount());
                    expense.setExpenseDt(expenseDetails.getExpenseDt());
                    expense.setAsset(expenseDetails.getAsset());
                    expense.setTblCamp(expenseDetails.getTblCamp());
                    return ResponseEntity.ok(expenseService.saveExpense(expense));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Integer id) {
        return expenseService.getExpenseById(id)
                .map(expense -> {
                    expenseService.deleteExpense(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
