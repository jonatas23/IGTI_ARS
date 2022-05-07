package com.igti.prestadorservico.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {

    public NotFoundException(UUID id) {
        super(String.format("Id %d not found", id));
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}

