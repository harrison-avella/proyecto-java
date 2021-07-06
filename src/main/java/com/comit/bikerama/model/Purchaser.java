package com.comit.bikerama.model;

public class Purchaser extends Role {
    private static final long serialVersionUID = 1L;
    private  static final String TYPE = "Purchaser";

    @Override
    public String getType(){
        return TYPE;
    }
}
