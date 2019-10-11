package org.tk.acc_cus.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ValidateCustomerNumber {

    // Int constant for magic number 0
    private static final int I0 = 0;
    // Int constant for magic number 1
    private static final int I1 = 1;
    // Int constant for magic number 2
    private static final int I2 = 2;
    // Int constant for magic number 3
    private static final int I3 = 3;
    // Int constant for magic number 4
    private static final int I4 = 4;
    // Int constant for magic number 5
    private static final int I5 = 5;
    // Int constant for magic number 5
    private static final int I6 = 6;
    // Int constant for magic number 6
    private static final int I7 = 7;
    private static final int I11 = 11;
    private static final int I17 = 17;
    private static final int I18 = 18;


    private static final int[] MODULO11 = {ValidateCustomerNumber.I6, ValidateCustomerNumber.I5, ValidateCustomerNumber.I4,
            ValidateCustomerNumber.I3, ValidateCustomerNumber.I2, ValidateCustomerNumber.I7,
            ValidateCustomerNumber.I6, ValidateCustomerNumber.I5, ValidateCustomerNumber.I4,
            ValidateCustomerNumber.I3, ValidateCustomerNumber.I2,
            ValidateCustomerNumber.I7, ValidateCustomerNumber.I6, ValidateCustomerNumber.I5,
            ValidateCustomerNumber.I4, ValidateCustomerNumber.I3, ValidateCustomerNumber.I2};

    public boolean isValidCustomerNumbers(final List<String> customerNumber) {
        for (String custNo : customerNumber) {
            if (!(validateUsingModel11(getWorking18DigitString(custNo)))) {
                return false;
            }
        }
        return true;
    }

    private String getWorking18DigitString(final String cdvNumber) {
        if (!StringUtils.isNumeric(cdvNumber)) {
            throw new RuntimeException("Not a valid account number");
        }
        return StringUtils.leftPad(cdvNumber, ValidateCustomerNumber.I18, "0");
    }

    private boolean validateUsingModel11(final String cdvNumber) {
        Integer checkSum = 0, checkDigit = 0;
        for (int i = 0; i < ValidateCustomerNumber.I17; i++) {
            checkSum += ValidateCustomerNumber.MODULO11[i] * Integer.parseInt(cdvNumber.substring(i, ValidateCustomerNumber.I1 + i));
        }
        if ((checkSum % ValidateCustomerNumber.I11) == ValidateCustomerNumber.I1) {
            return false;
        } else {
            if (!((checkSum % ValidateCustomerNumber.I11) == ValidateCustomerNumber.I0)) {
                checkDigit = ValidateCustomerNumber.I11 - (checkSum % ValidateCustomerNumber.I11);
            }
        }
        return cdvNumber.substring(ValidateCustomerNumber.I17).equals(checkDigit.toString());
    }
}
