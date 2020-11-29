package com.ktltat.vegetshop.service;

import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.dto.HoaDonDTO;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
public interface ICartService {
    List<CartDTO> findAllCart();
    List<CartDTO> getCartByIdtk(Integer idtk);
    CartDTO addCart(CartDTO cartDTO);
    void updateCart(CartDTO cartDTO);
    void deleteCart(Integer idcart);
    CartDTO increaseCart(Integer idtk, Integer idsp);
    CartDTO reductionCart(Integer idtk, Integer idsp);
}
