package com.formaciontdd.acceptance.worlds;

import com.formaciontdd.infrastructure.rest.vo.IssueResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Data
public class World {

  public static final String ADMIN_USER = "admin";
  public static final String ADMIN_PASSWORD = "admin";
  public static final String USER = "course";
  public static final String USER_PASSWORD = "course";

  private ResponseEntity response;
  private ErrorResponse errorResponse;

  private String securityUser;
  private String securityPassword;

  private HttpStatus lastHTTPCode;
  private IssueResponse lastBody;

  @Data
  public static class ErrorResponse {

    private String errorCode;
    private String errorMessage;
  }
}
