package com.ays.example.enums;

public enum ApiMessage {
    EXAMPLE_SAVED("eg-001", "Success", "Example saved successfully"),
    EXAMPLE_FIND("eg-002", "Success", "Example retrieved successfully"),
    EXAMPLE_FIND_BYI_D("eg-003", "Success", "Example retrieved by id successfully"),
    EXAMPLE_UPDATE_BYI_D("eg-004", "Success", "Example updated by id successfully"),
    NAME_SPECIAL_CHAR_NOT_ALLOWED("eg-002", "Validation failed", "Special character !~`@#$%^&*()_-+={[}]|\"':;>.<,?/ are not allowed in example name"),
    EXAMPLE_SAVE_SERVICE_ERROR("eg-003", "Internal server error", "Error has occurred while saving example"),
    DELETE_BY_INVALID_EXAMPLE_ID("eg-004", "Validation failed", "Invalid example id while deleting example"),

    ;
    private final String code;
    private final String reason;
    private final String message;

    ApiMessage(String code, String reason, String message) {
        this.code = code;
        this.reason = reason;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }
}
