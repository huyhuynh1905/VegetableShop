package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.service.impl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */

@CrossOrigin
@RestController
public class CartAPI {
    @Autowired
    private CartService cartService;

    @GetMapping(value = "/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<CartDTO> getAllCart(){
        return cartService.findAllCart();
    }

    @GetMapping(value = "/cartbyidtk")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<CartDTO> getCartByIdtk(@RequestParam("idtk") Integer idtk){
        return cartService.getCartByIdtk(idtk);
    }

    @PostMapping(value = "/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public CartDTO addCart(@RequestBody CartDTO cartDTO){
        return cartService.addCart(cartDTO);
    }

    @PutMapping(value = "/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void updateCart(@RequestBody CartDTO cartDTO){
        cartService.updateCart(cartDTO);
    }

    @DeleteMapping(value = "/cart/{idcart}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteCart(@PathVariable Integer idcart){
        cartService.deleteCart(idcart);
    }
}
