package com.example.washmachinedemo.util;

public final class URLConstant
{
    public static final String URL_WASH_MACHINE_DEMO = "/washMachineDemo";
    public static final String URL_SPIN_FUNCTIONALITY = "/spin/{time}";
    public static final String URL_WASH_FUNCTIONALITY = "/wash/{time}";
    public static final String URL_STOP_SPIN = "/stopSpin";
    public static final String URL_STOP_WASH = "/stopWash";
    
    private URLConstant() {
        throw new IllegalStateException("URLConstant Class");
    }
}
