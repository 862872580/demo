package json;

import java.util.List;

public class CreditWarn {
    private String appNo;
    private String userName;
    private String certNo;
    private String lastPhone;
    private String lastPhoneTime;
    private String lastAdress;
    private String marriage;
    private String mateName;
    private String mateCertNo;
    private String matePhone;
    private String creditPath;
    private List creditHitId;

    public CreditWarn() {
    }

    public CreditWarn(String appNo, String userName, String certNo, String lastPhone, String lastPhoneTime, String lastAdress, String marriage, String mateName, String mateCertNo, String matePhone, String creditPath, List creditHitId) {
        this.appNo = appNo;
        this.userName = userName;
        this.certNo = certNo;
        this.lastPhone = lastPhone;
        this.lastPhoneTime = lastPhoneTime;
        this.lastAdress = lastAdress;
        this.marriage = marriage;
        this.mateName = mateName;
        this.mateCertNo = mateCertNo;
        this.matePhone = matePhone;
        this.creditPath = creditPath;
        this.creditHitId = creditHitId;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getLastPhone() {
        return lastPhone;
    }

    public void setLastPhone(String lastPhone) {
        this.lastPhone = lastPhone;
    }

    public String getLastPhoneTime() {
        return lastPhoneTime;
    }

    public void setLastPhoneTime(String lastPhoneTime) {
        this.lastPhoneTime = lastPhoneTime;
    }

    public String getLastAdress() {
        return lastAdress;
    }

    public void setLastAdress(String lastAdress) {
        this.lastAdress = lastAdress;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateCertNo() {
        return mateCertNo;
    }

    public void setMateCertNo(String mateCertNo) {
        this.mateCertNo = mateCertNo;
    }

    public String getMatePhone() {
        return matePhone;
    }

    public void setMatePhone(String matePhone) {
        this.matePhone = matePhone;
    }

    public String getCreditPath() {
        return creditPath;
    }

    public void setCreditPath(String creditPath) {
        this.creditPath = creditPath;
    }

    public List getCreditHitId() {
        return creditHitId;
    }

    public void setCreditHitId(List creditHitId) {
        this.creditHitId = creditHitId;
    }

    @Override
    public String toString() {
        return "CreditWarn{" +
                "appNo='" + appNo + '\'' +
                ", userName='" + userName + '\'' +
                ", certNo='" + certNo + '\'' +
                ", lastPhone='" + lastPhone + '\'' +
                ", lastPhoneTime='" + lastPhoneTime + '\'' +
                ", lastAdress='" + lastAdress + '\'' +
                ", marriage='" + marriage + '\'' +
                ", mateName='" + mateName + '\'' +
                ", mateCertNo='" + mateCertNo + '\'' +
                ", matePhone='" + matePhone + '\'' +
                ", creditPath='" + creditPath + '\'' +
                ", creditHitId=" + creditHitId +
                '}';
    }
}
