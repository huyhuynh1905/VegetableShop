package com.ktltat.vegetshop.api;

import com.ktltat.vegetshop.config.payload.CartResponse;
import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.dto.SanPhamDTO;
import com.ktltat.vegetshop.entity.CartEntity;
import com.ktltat.vegetshop.entity.SanPhamEntity;
import com.ktltat.vegetshop.service.impl.CartService;
import com.ktltat.vegetshop.service.impl.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<CartResponse> getCartByIdtk(@RequestParam("idtk") Integer idtk){
        List<CartDTO> cartDTOs = cartService.getCartByIdtk(idtk);
        List<CartResponse> cartResponses = new ArrayList<>();
        for (CartDTO cartDTO:cartDTOs){
            SanPhamDTO sanPhamEntity = sanPhamService.findByIdsp(cartDTO.getIdsp());
            CartResponse cartResponse = new CartResponse();
            cartResponse.setIdcart(cartDTO.getIdcart());
            cartResponse.setIdsp(cartDTO.getIdsp());
            cartResponse.setIdtk(cartDTO.getIdtk());
            cartResponse.setSoluong(cartDTO.getSoluong());
            cartResponse.setGiasp(sanPhamEntity.getGiasp());
            cartResponse.setHinhanh(sanPhamEntity.getHinhanh());
            cartResponse.setTensp(sanPhamEntity.getTensp());
            cartResponse.setTonggia(cartDTO.getTonggia());
            cartResponses.add(cartResponse);
        }
        return cartResponses;
    }

    @PostMapping(value = "/cart")
    @PreAuthorize("hasRole('ROLE_USER')")
    public CartDTO addCart(@RequestBody CartDTO cartDTO){
        CartDTO cartDTOCheck = cartService.findByIdtkAndIdsp(cartDTO.getIdtk(),cartDTO.getIdsp());
        if (cartDTOCheck!=null){
            int soluong = cartDTO.getSoluong();
            double gia = (Double.parseDouble(cartDTO.getTonggia())/cartDTO.getSoluong())*soluong;
            cartDTOCheck.setSoluong(soluong);
            cartDTOCheck.setTonggia(String.valueOf(gia));
            return cartService.addCart(cartDTOCheck);
        }else {
            SanPhamDTO sanPhamDTO = sanPhamService.findByIdsp(cartDTO.getIdsp());
            double gia = Double.parseDouble(sanPhamDTO.getGiasp());
            double tonggia = cartDTO.getSoluong() * gia;
            cartDTO.setTonggia(String.valueOf(tonggia));
        }
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
        return cartService.reductionCart(idtk,idsp);
    }
}
