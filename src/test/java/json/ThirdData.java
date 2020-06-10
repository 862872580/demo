package json;

import java.util.Arrays;

public class ThirdData {
    private String appNo;
    private CustUser[] resultList;

    public ThirdData() {
    }

    public ThirdData(String appNo, CustUser[] resultList) {
        this.appNo = appNo;
        this.resultList = resultList;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public CustUser[] getResultList() {
        return resultList;
    }

    public void setResultList(CustUser[] resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "ThirdData{" +
                "appNo='" + appNo + '\'' +
                ", resultList=" + Arrays.toString(resultList) +
                '}';
    }
}
