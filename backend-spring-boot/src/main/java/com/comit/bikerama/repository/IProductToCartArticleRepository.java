package com.comit.bikerama.repository;

import javax.transaction.Transactional;

import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.domain.ProductToCartArticle;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface IProductToCartArticleRepository extends JpaRepository<ProductToCartArticle, Long> {
    void deleteByCartArticle(CartArticle cartArticleId);

    void delete(CartArticle cartArticle);

    
}
