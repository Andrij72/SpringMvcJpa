package net.mateakademy.model;

import java.util.UUID;

public class NoEntityException extends Exception {
    public NoEntityException(){
    super("user not found");
}
    public NoEntityException(UUID id){
        super(id + "No user ");
    }
}
