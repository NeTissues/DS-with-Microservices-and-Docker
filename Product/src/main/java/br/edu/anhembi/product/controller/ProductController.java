package br.edu.anhembi.product.controller;

import br.edu.anhembi.product.model.ProductRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void registerUser(@RequestBody ProductRegistrationRequest productRegistrationRequest){
        //todo: log this
        productService.registerProduct(productRegistrationRequest);
    }

    //todo: get mapping

    //todo: put mapping

    //todo: delete mapping
}
