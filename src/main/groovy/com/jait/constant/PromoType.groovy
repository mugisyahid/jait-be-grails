package com.jait.constant

enum PromoType {
    DISCOUNT('Discount'),
    REDUCTION('Reduction'), //DISKON harga
    CASHBACK('Cashback'),
    POINT('Point') // later

    String display

    PromoType(String display) {
        this.display = display
    }
}
