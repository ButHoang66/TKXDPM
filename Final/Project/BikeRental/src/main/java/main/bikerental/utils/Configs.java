package main.bikerental.utils;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Configs {
    public static final String PROCESS_TRANSACTION_URL = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
    public static final String RESET_BALANCE_URL = "https://ecopark-system-api.herokuapp.com/api/card/reset-balance";

    public static final String POST_DATA = "{"
            + " \"secretKey\": \"BJSl1g22pd4=\" ,"
            + " \"transaction\": {"
            + " \"command\": \"pay\" ,"
            + " \"cardCode\": \"kscq2_group18_2021\" ,"
            + " \"owner\": \"Group 18\" ,"
            + " \"cvvCode\": \"227\" ,"
            + " \"dateExpired\": \"1125\" ,"
            + " \"transactionContent\": \"Pei debt\" ,"
            + " \"amount\": 50000 "
            + "}"
            + "}";

    public static final String RENTBIKE_SCREEN_PATH = "/main/bikerental/rentbike.fxml";
    public static final String PAYMENT_SCREEN_PATH = "/main/bikerental/payment.fxml";
    public static final String HOME_SCREEN_PATH = "/main/bikerental/home.fxml";

    public static final String BIKE_STATION_DETAIL_PATH = "/main/bikerental/screen_bike_station_detail.fxml";
    public static final String LIST_STATION_PATH = "/main/bikerental/screen_list_station.fxml";

    public static final String BIKE_STATION_PATH = "/main/bikerental/screen_bike_station_detail.fxml";

    public static final String BIKE_IMAGE_PATH = "/images/bike.png";
    public static final String EBIKE_IMAGE_PATH = "/images/ebike.png";
    public static final String TWINBIKE_IMAGE_PATH = "/images/twinbike.png";
    public static final String GIVE_BACK_BIKE_SCREEN_PATH = "/main/bikerental/givebackbike.fxml";
    public static final String RESULT_SCREEN_PATH = "/main/bikerental/resultpayment.fxml";
    public static final String CHOOSE_BIKE_TO_GIVE_BACK_SCREEN_PATH = "/main/bikerental/choosebiketogiveback.fxml";
    public static final String LIST_RENTAL_BIKE = "/main/bikerental/screen_list_bike_rental.fxml";
    public static String CURRENCY = "VND";
    public static Font REGULAR_FONT = Font.font("Segoe UI", FontWeight.NORMAL, FontPosture.REGULAR, 24);
}
