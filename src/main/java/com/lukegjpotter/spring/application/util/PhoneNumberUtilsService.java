package com.lukegjpotter.spring.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberUtilsService {

    @Autowired
    private NullCheckUtilsService nullCheckUtilsService;

    public String formatPhoneNumber(String phoneNumber) {
        
        phoneNumber = phoneNumber.trim().replace(" ", "").replace("-", "");
        
        if (nullCheckUtilsService.stringNullCheck(phoneNumber) == null) return null;
        
        if (phoneNumber.isEmpty()) {
            return phoneNumber;
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_IRELAND_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_IRELAND.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_DOUBLE_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_DOUBLE_ZERO.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_DOUBLE.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_DOUBLE.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE_ZERO.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.IRELAND_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_N_IRELAND.code)) {
            return phoneNumber.replace(Prefix.IRELAND_N_IRELAND.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_EXTRA_PLUS.code)) {
            return phoneNumber.replace(Prefix.IRELAND_EXTRA_PLUS.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_ZERO.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_NO_COUNTRY_CODE.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_NO_COUNTRY_CODE.code, Prefix.N_IRELAND + "7");
        } else if (phoneNumber.startsWith(Prefix.IRELAND_MOBILE.code)) {
            return phoneNumber.replace(Prefix.IRELAND_MOBILE.code, Prefix.IRELAND.code + "8");
        } else if (!phoneNumber.startsWith(Prefix.PLUS.code)) {
            return Prefix.IRELAND + phoneNumber;
        }
        
        return phoneNumber;
    }
    
    private enum Prefix {
        PLUS("+"), IRELAND("+353"), N_IRELAND("+44"),
        IRELAND_DOUBLE("+353+353"), IRELAND_DOUBLE_ZERO("+353+3530"), IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN("+353353"), IRELAND_ZERO("+3530"), IRELAND_N_IRELAND("+353+44"), IRELAND_EXTRA_PLUS("+353+"),
        N_IRELAND_DOUBLE("+44+44"), N_IRELAND_IRELAND_ZERO("+44+3530"), N_IRELAND_DOUBLE_ZERO("+44+440"), N_IRELAND_ZERO("+440"), N_IRELAND_IRELAND("+44+353"), N_IRELAND_NO_COUNTRY_CODE("07"), IRELAND_MOBILE("08");
        
        private String code;

        Prefix(String code) {
            this.code = code;
        }
        
        @Override public String toString() {
            return code;
        }
    }
}
