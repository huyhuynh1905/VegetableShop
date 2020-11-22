package com.ktltat.vegetshop.converter;

import com.ktltat.vegetshop.dto.CartDTO;
import com.ktltat.vegetshop.entity.CartEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: vegetshop
 * @author: HuyHuynh on 21/11/2020
 */
@Component
public class CartConverter {
    public CartDTO toCartDTO(CartEntity entity){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setIdcart(entity.getIdcart());
        cartDTO.setIdsp(entity.getIdsp());
        cartDTO.setIdtk(entity.getIdtk());
        cartDTO.setSoluong(entity.getSoluong());
        return cartDTO;
    }
    public CartEntity toCartEntity(CartDTO cartDTO){
        CartEntity cartEntity = new CartEntity();
        cartEntity.setIdcart(cartDTO.getIdcart());
        cartEntity.setIdsp(cartDTO.getIdsp());
        cartEntity.setIdtk(cartDTO.getIdtk());
        cartEntity.setSoluong(cartDTO.getSoluong());
        return cartEntity;
    }

    public List<CartDTO> asListDTO(List<CartEntity> entityList){
        List<CartDTO> asListDTO = new ArrayList<>();
        for (CartEntity entity : entityList) {
            asListDTO.add(toCartDTO(entity));
        }
        return asListDTO;
    }
}
