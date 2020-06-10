package json;

public class Message {
    private String code;
    private String message;
    private String systemCode;
    private String warnType;
    private Data data;

    public Message() {
    }

    public Message(String code, String message, String systemCode, String warnType, Data data) {
        this.code = code;
        this.message = message;
        this.systemCode = systemCode;
        this.warnType = warnType;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "message{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", systemCode='" + systemCode + '\'' +
                ", warnType='" + warnType + '\'' +
                ", data=" + data +
                '}';
    }
}
