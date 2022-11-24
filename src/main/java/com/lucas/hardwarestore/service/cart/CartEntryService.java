package com.lucas.hardwarestore.service.cart;

import com.lucas.hardwarestore.model.cart.CartEntryModel;
import com.lucas.hardwarestore.service.GenericService;

public interface CartEntryService extends GenericService<CartEntryModel> {
    CartEntryModel save(CartEntryModel cartEntry);
}
