package com.performance.improvement.common;

public class ApiConstants {

    public static class Status {
        public static final String SUCCESS = "success";
        public static final String ERROR = "error";
    }

    public static class Message {
        public static final String OPERATION_COMPLETED = "Operation completed successfully.";
        public static final String BAD_REQUEST = "Bad Request: Invalid input data.";
        public static final String UNAUTHORIZED = "Unauthorized: Authentication is required.";
        public static final String FORBIDDEN = "Forbidden: You do not have permission to access this resource.";
        public static final String NOT_FOUND = "Not Found: The requested resource was not found.";
        public static final String CONFLICT = "Conflict: The request could not be completed due to a conflict.";
        public static final String INTERNAL_SERVER_ERROR = "Internal Server Error: An unexpected error occurred.";
        public static final String SERVICE_UNAVAILABLE = "Service Unavailable: The service is temporarily unavailable. Please try again later.";
        public static final String VALIDATION_ERROR = "Validation Error: One or more fields have invalid values.";
        public static final String RESOURCE_CREATED = "Resource Created: The resource was created successfully.";
        public static final String RESOURCE_UPDATED = "Resource Updated: The resource was updated successfully.";
        public static final String RESOURCE_DELETED = "Resource Deleted: The resource was deleted successfully.";
    }
}
