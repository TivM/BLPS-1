package com.blps.demo.entity;

import com.blps.demo.entity.compositekey.CartId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "cart")
@Accessors(chain = true)
public class Cart {
    @EmbeddedId
    private CartId cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "count", nullable = false)
    private Integer count;
}
