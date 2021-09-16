package algorithm.practice;

import static algorithm.practice.ValidNumber.State.*;

public class ValidNumber {
    public static enum State {INIT, SIGN, DECIMAL, AFTER_DECIMAL, NUMBER, INVALID};

    public static void main(String[] args) {
        System.out.println( "34.23 - " + isValidNumber("34.23"));
        System.out.println( ".23 - " + isValidNumber(".23"));
        System.out.println( "0.23 - " + isValidNumber("0.23"));
        System.out.println( "34. - " + isValidNumber("34."));
        System.out.println( "34.0 - " + isValidNumber("34.0"));
        System.out.println( "-34.0 - " + isValidNumber("-34.03"));
        System.out.println( "+34.0 - " + isValidNumber("+34.03"));
        System.out.println( "-3x4.0 - " + isValidNumber("-3x4.03"));
        System.out.println( "xxx - " + isValidNumber("xxx"));
    }

    private static boolean isValidNumber(String givenNumber) {
        State current = State.INIT;

        for (int i = 0; i < givenNumber.length() && current != INVALID; i++) {
            char curChar = givenNumber.charAt(i);
            switch (current) {
                case INIT:
                {
                    if ((curChar >= '0') && (curChar <= '9')) {
                        current = NUMBER;
                    } else if ((curChar == '-') || (curChar == '+')) {
                        current = SIGN;
                    } else {
                        current = INVALID;
                    }
                };
                break;

                case SIGN:
                {
                    if ((curChar >= '0') && (curChar <= '9')) {
                        current = NUMBER;
                    } else {
                        current = INVALID;
                    }
                };
                break;

                case NUMBER:
                {
                    if ((curChar >= '0') && (curChar <= '9')) {
                        // Nothing to do
                    } else if ((curChar == '.')) {
                        current = DECIMAL;
                    } else {
                        current = INVALID;
                    }
                };
                break;

                case DECIMAL:
                {
                    if ((curChar >= '0') && (curChar <= '9')) {
                        current = AFTER_DECIMAL;
                    } else {
                        current = INVALID;
                    }
                };
                break;

                case AFTER_DECIMAL:
                {
                    if ((curChar >= '0') && (curChar <= '9')) {
                        // Nothing to do
                    } else {
                        current = INVALID;
                    }
                };
                break;
            }
        }

        return current == NUMBER || current == AFTER_DECIMAL;
    }
}
