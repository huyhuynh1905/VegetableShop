package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.service.impl.CartService;
import com.ktltat.vegetshop.service.impl.SanPhamService;
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

    @Autowired
    private SanPhamService sanPhamService;

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
        SanPhamDTO sanPhamDTO = sanPhamService.findByIdsp(cartDTO.getIdsp());
        double gia = Double.parseDouble(sanPhamDTO.getGiasp());
        double tonggia = cartDTO.getSoluong()*gia;
        cartDTO.setTonggia(String.valueOf(tonggia));
        return cartService.addCart(cartDTO);
    }

    @PutMapping(value = "/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void updateCart(@RequestBody CartDTO cartDTO){
        SanPhamDTO sanPhamDTO = sanPhamService.findByIdsp(cartDTO.getIdsp());
        double gia = Double.parseDouble(sanPhamDTO.getGiasp());
        double tonggia = cartDTO.getSoluong()*gia;
        cartDTO.setTonggia(String.valueOf(tonggia));
        cartService.updateCart(cartDTO);
    }

    @DeleteMapping(value = "/cart={idcart}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteCart(@PathVariable Integer idcart){
        cartService.deleteCart(idcart);
    }


    @PostMapping(value = "/increasecart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public CartDTO increaseCart(@RequestParam("idtk") Integer idtk, @RequestParam("idsp") Integer idsp){
        return cartService.increaseCart(idtk,idsp);
    }

    @PostMapping(value = "/reductioncart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public CartDTO reductionCart(@RequestParam("idtk") Integer idtk, @RequestParam("idsp") Integer idsp){
        return cartService.increaseCart(idtk,idsp);
    }
}
