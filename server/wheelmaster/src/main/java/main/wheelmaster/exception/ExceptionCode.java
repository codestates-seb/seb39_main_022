package main.wheelmaster.exception;

import lombok.Getter;

public enum ExceptionCode {
  MEMBER_NOT_FOUND(404, "Member not found"),
  MEMBER_ALREADY_EXISTS(409, "Member already exists"),
  FIELD_ERROR(400, "Field Error"),
  CONSTRAINT_VIOLATION_ERROR(400, "Constraint Violation Error"),
  TOKEN_IS_INVALID(401, "Token is invalid"),
  REFRESH_TOKEN_IS_EXPIRED(403, "Refresh Token is expired");


  @Getter
  private int status;

  @Getter
  private String message;

  ExceptionCode(int code, String message) {
    this.status = code;
    this.message = message;
  }
}
