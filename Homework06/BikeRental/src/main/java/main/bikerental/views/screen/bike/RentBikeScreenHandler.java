package main.bikerental.views.screen.bike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.bikerental.controller.PaymentController;
import main.bikerental.controller.RentBikeController;
import main.bikerental.entity.bike.Bike;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;
import main.bikerental.views.screen.home.HomeScreenHandler;
import main.bikerental.views.screen.payment.PaymentScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RentBikeScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private Button back;

    @FXML
    private Label barcode;

    @FXML
    private ImageView bikeImage;

    @FXML
    private Button confirm;

    @FXML
    private Label fee;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView logoUser;

    @FXML
    private Label station;

    @FXML
    private Label type;

    @FXML
    private Label userName;

    private Bike bike;

    private int amount;

    private String stationName;


    public RentBikeScreenHandler(Stage stage, String screenPath, Bike bike, String stationName) throws IOException {
        super(stage, screenPath);
        this.bike = bike;
        this.stationName = stationName;
    }

    public RentBikeScreenHandler() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImage(logoUser, "/images/LogoUser.png");
        setImage(logo, "/images/Logo1.png");
        setBikeInfo();
        userName.setText("Tuấn Anh");
        station.setText(stationName);
        this.amount = ((RentBikeController)getBController()).calculateFee(bike.getType());
        fee.setText(Integer.toString(amount) + " " + Configs.CURRENCY);
    }


    @FXML
    void back(ActionEvent event) throws IOException {
        getStage().setScene(getPreviousScene());
    }

    @FXML
    void confirm(ActionEvent event) throws IOException {
        RentBikeController rentBikeController = (RentBikeController) getBController();
        PaymentScreenHandler paymentScreenHandler = new PaymentScreenHandler(new Stage(), Configs.PAYMENT_SCREEN_PATH, amount);
        paymentScreenHandler.setBController(new PaymentController());
        paymentScreenHandler.getStage().initModality(Modality.APPLICATION_MODAL);
        paymentScreenHandler.showAndWait();

        if (paymentScreenHandler.getPaymentResult() == true) {
            getStage().hide();
            HomeScreenHandler homeScreenHandler = new HomeScreenHandler(new Stage(), Configs.HOME_SCREEN_PATH);
            homeScreenHandler.show();
            rentBikeController.updateRentInfo(bike, "admin");
            getStage().close();
        }
    }

    public void setBikeInfo() {
        String path;
        String bikeType;
        switch (bike.getType())  {
            case SINGLE_BIKE:
                path = Configs.BIKE_IMAGE_PATH;
                bikeType = "Xe đạp đơn";
                break;
            case E_BIKE:
                path = Configs.EBIKE_IMAGE_PATH;
                bikeType = "Xe đạp điện";
                break;
            case TWIN_BIKE:
                path = Configs.TWINBIKE_IMAGE_PATH;
                bikeType = "Xe đạp đôi";
                break;
            default:
                path = "";
                bikeType = "";
        }
        setImage(bikeImage, path);
        type.setText(bikeType);
        barcode.setText(String.valueOf(bike.getId()));
    }
}
