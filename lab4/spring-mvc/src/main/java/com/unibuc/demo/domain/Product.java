package com.unibuc.demo.domain;


import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    private String name;
    private String id;
    private int price;
    private int rating;

}
