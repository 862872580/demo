package json;

import com.alibaba.fastjson.JSON;

public class test {
    public static void main(String[] args) {
        String json = "{\"code\": \"200\",\"message\": \"征信预警推送\",\"systemCode\": \"04\",\"warnType\": \"02\",\"data\": {\"creditWarn\": [{\"appNo\": \"FTAUMAN201926810\",\"userName\": \"刘林岩\",\"certNo\": \"210381198212261414\",\"lastPhone\": \" 13951463844\",\"lastPhoneTime\": \" 2019.12.11\",\"lastAdress\": \" XXX地\",\"marriage\": \" 01\",\"mateName\": \" 刘配偶\",\"mateCertNo\": \" 210381198212261414\",\"matePhone\": \" 1532341234\",\"creditPath\": \" obsId\",\"creditHitId\": [\"cw002\", \"cw003\"]},{\"appNo\": \"FTAUMAN201926810\",\"userName\": \"刘林岩\",\"certNo\": \"210381198212261414\",\"lastPhone\": \" 13951463844\",\"lastPhoneTime\": \" 2019.12.11\",\"lastAdress\": \" XXX地\",\"marriage\": \" 01\",\"mateName\": \" 刘配偶\",\"mateCertNo\": \" --\",\"matePhone\": \" --\",\"creditPath\": \" obsId\",\"creditHitId\": [\"cw002\", \"cw003\", \"cw004\"]}],\"thirdData\":[{\"appNo\":\"FTAUMAN201926810\",\"resultList\":[{\"custName\":\"刘林岩\",\"idNo\":\"210381198212261414\",\"riskFlag\":\"1\",\"hitRiskList\":[\"04\"]},{\"custName\":\"刘林岩\",\"idNo\":\"210381198212261414\",\"riskFlag\":\"1\",\"hitRiskList\":[\"04\"]}]},{\"appNo\":\"FTAUMAN201926810\",\"resultList\":[{\"custName\":\"刘林岩\",\"idNo\":\"210381198212261414\",\"riskFlag\":\"1\",\"hitRiskList\":[\"04\"]},{\"custName\":\"刘林岩\",\"idNo\":\"210381198212261414\",\"riskFlag\":\"1\",\"hitRiskList\":[\"04\"]}]}]}}";
        Message message = JSON.parseObject(json, Message.class);
        System.out.println(message);
    /*
        {"code": "200"
        ,"message": "征信预警推送"
        ,"systemCode": "04"
        ,"warnType": "02"
        ,"data":

            {"creditWarn":
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

        }
     */
    }
}
