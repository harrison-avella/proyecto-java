package com.comit.bikerama.repositories;

import javax.transaction.Transactional;

import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.models.ProductToCartArticle;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface IProductToCartArticleRepository extends JpaRepository<ProductToCartArticle, Long> {
    void deleteByCartArticle(CartArticle cartArticleId);

    void delete(CartArticle cartArticle);

    
}
