package br.com.fefproject.FefProjectApplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private String nameProduct;
    private String descriptionProduct;
    private String skuProduct;
    private String eanProduct;
    private String costPriceProduct;
    private String amountProduct;
    private Boolean publishedProduct;
    private String dateCreatedProduct;
    private Long idCategory;

}
