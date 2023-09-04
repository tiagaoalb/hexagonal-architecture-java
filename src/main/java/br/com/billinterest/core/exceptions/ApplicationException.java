package br.com.billinterest.core.exceptions;

import br.com.billinterest.core.domain.enums.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private ExceptionType exceptionType;
}
