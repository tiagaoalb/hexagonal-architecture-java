package br.com.billinterest.core.domain.enums;

public enum ExceptionType {
    INVALID_BILL {
        @Override
        public String getErrorMessage() {
            return "Invalid bill";
        }
    },
    INVALID_BILL_TYPE {
        @Override
        public String getErrorMessage() {
            return "Unfortunately we can only calculate fees of XPTO bills";
        }
    },
    BILL_NOT_EXPIRED {
        @Override
        public String getErrorMessage() {
            return "This bill is not expired";
        }
    };

    public abstract String getErrorMessage();
}
