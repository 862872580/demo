package json;

import java.util.Arrays;

public class Data {
    private CreditWarn[] creditWarn;
    private ThirdData[] thirdData;

    public Data() {
    }

    public Data(CreditWarn[] creditWarn, ThirdData[] thirdData) {
        this.creditWarn = creditWarn;
        this.thirdData = thirdData;
    }

    public CreditWarn[] getCreditWarn() {
        return creditWarn;
    }

    public void setCreditWarn(CreditWarn[] creditWarn) {
        this.creditWarn = creditWarn;
    }

    public ThirdData[] getThirdData() {
        return thirdData;
    }

    public void setThirdData(ThirdData[] thirdData) {
        this.thirdData = thirdData;
    }

    @Override
    public String toString() {
        return "Data{" +
                "creditWarn=" + Arrays.toString(creditWarn) +
                ", thirdData=" + Arrays.toString(thirdData) +
                '}';
    }

    /*
     *      {"creditWarn":
                [{"appNo": "FTAUMAN201926810","userName": "刘林岩","certNo": "210381198212261414","lastPhone": " 13951463844","lastPhoneTime": " 2019.12.11","lastAdress": " XXX地","marriage": " 01","mateName": " 刘配偶","mateCertNo": " 210381198212261414","matePhone": " 1532341234","creditPath": " obsId","creditHitId": ["cw002", "cw003"]}
                ,{"appNo": "FTAUMAN201926810","userName": "刘林岩","certNo": "210381198212261414","lastPhone": " 13951463844","lastPhoneTime": " 2019.12.11","lastAdress": " XXX地","marriage": " 01","mateName": " 刘配偶","mateCertNo": " --","matePhone": " --","creditPath": " obsId","creditHitId": ["cw002", "cw003", "cw004"]}]
             ,"thirdData":
                [{"appNo":"FTAUMAN201926810","resultList":
                    [{"custName":"刘林岩","idNo":"210381198212261414","riskFlag":"1","hitRiskList":["04"]}
                    ,{"custName":"刘林岩","idNo":"210381198212261414","riskFlag":"1","hitRiskList":["04"]}]}
                ,{"appNo":"FTAUMAN201926810","resultList":
                    [{"custName":"刘林岩","idNo":"210381198212261414","riskFlag":"1","hitRiskList":["04"]}
                    ,{"custName":"刘林岩","idNo":"210381198212261414","riskFlag":"1","hitRiskList":["04"]}]}

                 ]

            }
     */
}
