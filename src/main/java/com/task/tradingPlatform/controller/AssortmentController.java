package com.task.tradingPlatform.controller;

import com.task.tradingPlatform.model.Assortment;
import com.task.tradingPlatform.model.Product;
import com.task.tradingPlatform.service.assortment.AssortmentService;
import com.task.tradingPlatform.service.product.ProductService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assortment")
public class AssortmentController {
    private final AssortmentService assortmentService;
    private final ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Assortment>> getAssortmentList() {
        return ResponseEntity.ok(assortmentService.getAssortmentList());
    }

    @GetMapping("/get-product")
    public ResponseEntity<Product> getProduct(@RequestParam @Positive String exbarBody,
                                              @RequestParam @Positive BigDecimal quantity,
                                              @RequestParam Boolean isDiscountProvided) {
        return ResponseEntity.ok(productService.getProduct(exbarBody, quantity, isDiscountProvided));
    }
}
