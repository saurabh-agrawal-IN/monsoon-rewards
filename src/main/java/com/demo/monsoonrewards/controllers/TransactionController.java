package com.demo.monsoonrewards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.monsoonrewards.common.CustomException;
import com.demo.monsoonrewards.common.ErrorCodes;
import com.demo.monsoonrewards.domain.Transaction;
import com.demo.monsoonrewards.services.TransactionService;

@RestController
@RequestMapping("monsoon-rewards/v1/transactions")
public class TransactionController {
	@Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(path = "{id}")
    public Transaction getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id).orElse(null);
    }

    @GetMapping(path = "users/{id}")
    public List<Transaction> getTransactionsByUserId(@PathVariable("id") Long id) {
        return transactionService.getTransactionsByUserId(id);
    }
    /**
     * 
     * @param fromMonth a valid number from 01 to 12
     * @param toMonth a valid number from 01 to 12
     * @return
     */
    @GetMapping(path = "from/{from}/to/{to}")
    public List<Transaction> getTransactionsForPeriod(@PathVariable("from") String fromMonth, @PathVariable("to") String toMonth) {
    	if (Integer.parseInt(fromMonth) > Integer.parseInt(toMonth)) {
    		throw new CustomException(
    			ErrorCodes.MONTH_RANGE_ERROR,
    			"Invalid Month Range",
    			"You've entered invalid range of months",
    			"From Month < To Month",
    			"Please enter valid month span"
    		);
    	}

        return transactionService.getTransactionsForPeriod(fromMonth, toMonth);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTransaction(@PathVariable("id") Long id) {
        transactionService.deleteTransaction(id);
    }

    @PutMapping(path = "{id}")
    public Transaction updateTransaction(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }
}
