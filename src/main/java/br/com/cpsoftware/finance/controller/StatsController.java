package br.com.cpsoftware.finance.controller;

import br.com.cpsoftware.finance.model.Account;
import br.com.cpsoftware.finance.model.Category;
import br.com.cpsoftware.finance.model.Transaction;
import br.com.cpsoftware.finance.model.User;
import br.com.cpsoftware.finance.repository.CategoryRepository;
import br.com.cpsoftware.finance.repository.UserRepository;
import br.com.cpsoftware.finance.repository.AccountRepository;
import br.com.cpsoftware.finance.repository.TransactionRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class StatsController {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public StatsController(CategoryRepository categoryRepository, UserRepository userRepository,
            AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public String getStats(Model model) {
        List<User> users = userRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        List<Account> accounts = accountRepository.findAll();
        List<Transaction> transactions = transactionRepository.findAll();

        model.addAttribute("users", users.size());
        model.addAttribute("categories", categories.size());
        model.addAttribute("accounts", accounts.size());
        model.addAttribute("transactions", transactions.size());
        return "stats";
    }

}
