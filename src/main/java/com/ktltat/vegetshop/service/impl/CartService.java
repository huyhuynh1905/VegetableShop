package com.ktltat.vegetshop.service.impl;

import com.ktltat.vegetshop.converter.CartConverter;
import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.entity.CartEntity;
import com.ktltat.vegetshop.repository.CartRepository;
import com.ktltat.vegetshop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 20/11/2020
 */
@Service
@Transactional
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartConverter cartConverter;

    @Override
    public List<CartDTO> findAllCart() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        List<CartDTO> cartDTOS = cartConverter.asListDTO(cartEntities);
        return cartDTOS;
    }

    @Override
    public List<CartDTO> getCartByIdtk(Integer idtk) {
        List<CartEntity> cartEntities = cartRepository.findAllByIdtk(idtk);
        List<CartDTO> cartDTOS = cartConverter.asListDTO(cartEntities);
        return cartDTOS;
    }

    @Override
    public CartDTO addCart(CartDTO cartDTO) {
        CartEntity cartEntity = cartConverter.toCartEntity(cartDTO);
        cartEntity = cartRepository.save(cartEntity);
        return cartConverter.toCartDTO(cartEntity);
    }

    @Override
    public void updateCart(CartDTO cartDTO) {
        CartEntity cartEntity = cartConverter.toCartEntity(cartDTO);
        cartRepository.save(cartEntity);
    }

    @Override
    public void deleteCart(Integer idcart) {
        cartRepository.deleteByIdcart(idcart);
    }
}
