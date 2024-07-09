package data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.railway.models.User;
import org.testng.annotations.DataProvider;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "FTTC702")
    public Object[][] getFTTC702TestData() {
        return getTestData("FTTC702");
    }

    @DataProvider(name="FTTC703")
    public Object[][] getFTTC703TestData() {
        return getTestData("FTTC703");
    }

    private Object[][] getTestData(String chapterKey) {
        JSONArray testData = loadTestData();
        List<Object[]> testDataList = parseTestData(testData, chapterKey);
        return convertToObjectArray(testDataList);
    }


    private Object[][] convertToObjectArray(List<Object[]> testDataList) {
        Object[][] testDataArray = new Object[testDataList.size()][];
        for (int i = 0; i < testDataList.size(); i++) {
            testDataArray[i] = testDataList.get(i);
        }
        return testDataArray;
    }

    private JSONArray loadTestData() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Test data file not found");
            }
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);
            return jsonObject.getJSONArray("testData");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    private List<Object[]> parseTestData(JSONArray testData, String dataKey) {
        List<Object[]> testDataList = new ArrayList<>();
        for (int i = 0; i < testData.length(); i++) {
            JSONObject testDataItem = testData.getJSONObject(i);
            if (testDataItem.has(dataKey)) {
                JSONObject data = testDataItem.getJSONObject(dataKey);
                User user = new User();
                user.setUsername(data.optString("username", ""));
                user.setDomain(data.optString("domain", ""));
                user.setPassword(data.optString("password", ""));
                user.setConfirmPassword(data.optString("confirmPassword", ""));
                user.setPassport(data.optString("passport", ""));
                user.setDepart(data.optString("depart", ""));
                user.setSeatType(data.optString("seatType", ""));
                user.setAmountTicket(data.optString("amountTicket", ""));
                user.setArrive(data.optString("arrive", ""));
                user.setDepartDate(data.optString("departDate", ""));
                user.setDate(data.getInt("date"));
                if (testDataItem.has("email")) {
                    user.setEmail(data.optString("email", ""));
                } else {
                    user.setEmail(generateEmail(data.optString("username", ""), data.optString("domain", "")));
                }

                String expectedMessage = data.optString("expectedMessage", "");
                int numberOfTickets = data.optInt("numberOfTickets");
                String section = data.optString("section","");
                int totalPrice = data.optInt("totalPrice");

                if (!expectedMessage.isEmpty()) {
                    testDataList.add(new Object[]{user, expectedMessage});
                } else if(numberOfTickets > 0){
                    testDataList.add(new Object[]{user, numberOfTickets});
                } else{
                    testDataList.add(new Object[]{user, section, totalPrice});
                }
            }
        }
        return testDataList;
    }

    private String generateEmail(String username, String domain) {
        return username + "@" + domain;
    }

}
