package com.tdtu.Midterm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * TẠo ra class này chỉ để lưu giữ thông tin
 */
@Data
@AllArgsConstructor
public class Info_product {
    private int id;
    private String name;
    private String img;
    private int price;
    private String description;
    private int id_brand;
}
