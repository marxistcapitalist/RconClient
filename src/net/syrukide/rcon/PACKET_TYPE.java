package net.syrukide.rcon;

public enum PACKET_TYPE {
    SERVERDATA_AUTH(3),
    SERVERDATA_AUTH_RESPONSE(2),
    SERVERDATA_EXECCOMMAND(2),
    SERVERDATA_RESPONSE_VALUE(0);

    private int value;

    PACKET_TYPE(int val) {
        this.value = val;
    }

    public int getNumVal() {
        return value;
    }
}
