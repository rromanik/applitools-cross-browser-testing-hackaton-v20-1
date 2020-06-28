package com.applitools.applifashion.specification;

import com.applitools.applifashion.pages.ProductGrid;
import com.applitools.applifashion.pages.ProductGridItem;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class ProductGridSpecification extends Specification {

    private final ProductGrid productGrid;

    public ProductGridSpecification(ProductGrid productGrid, SoftAssertions softAssertions, int task) {
        super(softAssertions, task);
        this.productGrid = productGrid;
    }

    @Override
    protected void validate1200x700() {
        List<ProductGridItem> items = productGrid.getItems();
        for (int i = 0; i < items.size(); i++) {
            ProductGridItem item = items.get(i);
            expectIsDisplayed(item.productImage(), "Product image for item #" + i);
            expectIsDisplayed(item.nameLabel(), "Name for item #" + i);
            expectIsHidden(item.addToFavoritesIcon(), "'Add to favorites' icon for item #" + i);
            expectIsHidden(item.addToCompareIcon(), "'Add to compare' icon for item #" + i);
            expectIsHidden(item.addToCartIcon(), "'Add to cart' icon for item #" + i);
        }
    }

    @Override
    protected void validate768x700() {
        List<ProductGridItem> items = productGrid.getItems();
        for (int i = 0; i < items.size(); i++) {
            ProductGridItem item = items.get(i);
            expectIsDisplayed(item.productImage(), "Product image for item #" + i);
            expectIsDisplayed(item.nameLabel(), "Name for item #" + i);
            expectIsDisplayed(item.addToFavoritesIcon(), "'Add to favorites' icon for item #" + i);
            expectIsDisplayed(item.addToCompareIcon(), "'Add to compare' icon for item #" + i);
            expectIsDisplayed(item.addToCartIcon(), "'Add to cart' icon for item #" + i);
        }
    }

    @Override
    protected void validate500x700() {
        List<ProductGridItem> items = productGrid.getItems();
        for (int i = 0; i < items.size(); i++) {
            ProductGridItem item = items.get(i);
            expectIsDisplayed(item.productImage(), "Product image for item #" + i);
            expectIsDisplayed(item.nameLabel(), "Name for item #" + i);
            expectIsDisplayed(item.addToFavoritesIcon(), "'Add to favorites' icon for item #" + i);
            expectIsDisplayed(item.addToCompareIcon(), "'Add to compare' icon for item #" + i);
            expectIsDisplayed(item.addToCartIcon(), "'Add to cart' icon for item #" + i);
        }
    }

}
