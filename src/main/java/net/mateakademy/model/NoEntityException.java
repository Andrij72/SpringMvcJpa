package net.mateakademy.model;

public class NoEntityException extends Exception {
    public NoEntityException(){
    super("user not found");
}

    public NoEntityException(java.util.UUID id){
        super(id + "No user ");
    }
}
