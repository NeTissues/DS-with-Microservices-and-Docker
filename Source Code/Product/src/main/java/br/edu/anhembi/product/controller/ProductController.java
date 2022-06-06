package br.edu.anhembi.product.controller;

import br.edu.anhembi.model.Orders;
import br.edu.anhembi.product.model.Product;
import br.edu.anhembi.product.model.repository.ProductRepository;
import br.edu.anhembi.model.Users;
import br.edu.anhembi.product.model.ProductOrderRegistrationRequest;
import br.edu.anhembi.product.model.ProductRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @PostMapping
    public void registerProduct(@RequestBody ProductRegistrationRequest productRegistrationRequest){
        //todo: log this
        productService.registerProduct(productRegistrationRequest);
    }

    @PostMapping(path = "register-order")
    public ResponseEntity<Orders> registerOrderProduct(@RequestBody ProductOrderRegistrationRequest productOrderRegistrationRequest){
        ResponseEntity<Users> user = productService.checkUser(productOrderRegistrationRequest);
        ResponseEntity<Orders> order;
        if(user.hasBody()){
            order = productService.checkProductOrder(productOrderRegistrationRequest);
            if(order.hasBody()){
                //order = productService.updateProductOrder(productOrderRegistrationRequest);
            }else{
                //order = productService.createProductOrder(productOrderRegistrationRequest);
            }
        }else{
            order = null;
        }
        return order;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "productId") Long productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        return ResponseEntity.ok().body(product);
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId") Long productId,
                                            @Valid @RequestBody Product productDetails) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());

        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable(value = "productId") Long productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        productRepository.delete(product);
    }

    @PatchMapping(path = "{productId}/{price}")
    public ResponseEntity<Product> updateProductPartially(@PathVariable Long productId, @PathVariable Double price) {
        try {            Product product = productRepository.findById(productId).get();
            product.setPrice(price);
            return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}