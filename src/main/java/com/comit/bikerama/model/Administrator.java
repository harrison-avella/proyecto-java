package com.comit.bikerama.model;

public class Administrator extends Role {
    private static final long serialVersionUID= 1L;
    private static final String TYPE = "Administrator";
    @Override
    public String getType(){
        return TYPE;
    }
}
