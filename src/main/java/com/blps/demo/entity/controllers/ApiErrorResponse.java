package com.blps.demo.entity.controllers;

import java.util.List;

public record ApiErrorResponse(String description, String code, String exceptionName, String exceptionMessage,
                               List<String> stackTrace){
}