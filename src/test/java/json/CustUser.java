package json;

import java.util.List;

public class CustUser {
    private String custName;
    private String idNo;
    private String riskFlag;
    private List hitRiskList;

    public CustUser() {
    }

    public CustUser(String custName, String idNo, String riskFlag, List hitRiskList) {
        this.custName = custName;
        this.idNo = idNo;
        this.riskFlag = riskFlag;
        this.hitRiskList = hitRiskList;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRiskFlag() {
        return riskFlag;
    }

    public void setRiskFlag(String riskFlag) {
        this.riskFlag = riskFlag;
    }

    public List getHitRiskList() {
        return hitRiskList;
    }

    public void setHitRiskList(List hitRiskList) {
        this.hitRiskList = hitRiskList;
    }

    @Override
    public String toString() {
        return "CustUser{" +
                "custName='" + custName + '\'' +
                ", idNo='" + idNo + '\'' +
                ", riskFlag='" + riskFlag + '\'' +
                ", hitRiskList=" + hitRiskList +
                '}';
    }
}
