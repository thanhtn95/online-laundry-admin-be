package online.laundry.onlinelaundryadminbe.exception;

public class OrderCannotBeCancelException extends RuntimeException{
    public OrderCannotBeCancelException(String message) {
        super(message);
    }
}
