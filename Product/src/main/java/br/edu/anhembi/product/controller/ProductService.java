package br.edu.anhembi.product.controller;

import br.edu.anhembi.model.Orders;
import br.edu.anhembi.order.OrderClient;
import br.edu.anhembi.product.model.Product;
import br.edu.anhembi.product.model.ProductRegistrationRequest;
import br.edu.anhembi.product.model.repository.ProductRepository;
import br.edu.anhembi.user.UserClient;
import br.edu.anhembi.model.Users;
import br.edu.anhembi.product.model.ProductOrderRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService{

    private final UserClient userClient;
    private final OrderClient orderClient;
    private final ProductRepository productRepository;

    public void registerProduct(ProductRegistrationRequest request) {
        Product product = Product.builder()
                .name(request.name())
                .price(Double.parseDouble(request.price()))
                .description(request.description())
                .build();
        // todo: add date of creation for product
        // todo: check if product is not duplicate
        productRepository.save(product);
    }
    public ResponseEntity<Users> checkUser(ProductOrderRegistrationRequest request){
        ResponseEntity<Users> user = userClient.getUserById(request.userId());
        return user;
    }

    public ResponseEntity<Orders> checkProductOrder(ProductOrderRegistrationRequest request){
        ResponseEntity<Orders> order = orderClient.findTopByUserIdAndOrderStatus(request.userId(),request.orderStatus());
        return order;
    }
}
