package com.lucas.ecommerce.service.cart;

import com.lucas.ecommerce.model.cart.CartEntryModel;
import com.lucas.ecommerce.service.GenericService;

public interface CartEntryService extends GenericService<CartEntryModel> {
    CartEntryModel save(CartEntryModel cartEntry);
}
