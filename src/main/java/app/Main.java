package app;

import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) {
        String filePath = args[0];
        csvData test = new csvData(filePath);
        JSONObject output = new JSONObject();
        JSONObject temp;

        for (int i = 1; i < test.getDataArray().length; i++) {
            temp = new JSONObject();
            for (int ii = 1; ii < test.getFieldCount(); ii++) {
                temp.put(test.getHeaderArray()[ii], test.getDataArray()[i][ii]);
            }
            output.put(test.getDataArray()[i][0], temp);
        }
        System.out.println(output.toJSONString());
    }
}
