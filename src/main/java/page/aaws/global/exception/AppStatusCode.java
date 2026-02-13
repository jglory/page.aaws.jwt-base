package page.aaws.global.exception;

public interface AppStatusCode {
    int value();

    String message();

    boolean isError();
}
