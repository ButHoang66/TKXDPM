package main.bikerental.views.screen.payment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.bikerental.controller.PaymentController;
import main.bikerental.entity.payment.CreditCard;
import main.bikerental.utils.Configs;
import main.bikerental.views.BaseScreenHandler;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

/**
 * @author nguyentuananh
 */
public class PaymentScreenHandler extends BaseScreenHandler implements Initializable {

    @FXML
    private TextField ExpirationDate;

    @FXML
    private Label amountLabel;

    @FXML
    private TextField cardNumber;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField holderName;

    @FXML
    private RadioButton radioButton;

    @FXML
    private PasswordField securityCode;

    private int amount;

    private boolean paymentResult;

    public PaymentScreenHandler(Stage stage, String screenPath, int amount) throws IOException {
        super(stage, screenPath);
        this.amount = amount / 1000;
        paymentResult = false;
    }

    public PaymentScreenHandler() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountLabel.setText(Integer.toString(amount * 1000) + " " + Configs.CURRENCY);
    }

    @FXML
    void confirm(ActionEvent event) {
        String cardCode = cardNumber.getText();
        String owner = holderName.getText();
        String dateExpired = ExpirationDate.getText();
        String cvv = securityCode.getText();

        if (validateInput(cardCode, owner, dateExpired, cvv)) {
            int cvvCode = Integer.valueOf(cvv);
            CreditCard creditCard = new CreditCard(cardCode, owner, cvvCode, dateExpired);

            Hashtable<String, String> result = ((PaymentController) getBController()).pay(creditCard, amount, "pay");
            System.out.println(result.get("RESULT"));

            if (result.get("RESULT").equals("PAYMENT FAILED")) {
                showAlertDialog(Alert.AlertType.ERROR, result.get("MESSAGE"));
            }
            else {
                paymentResult = true;
                showAlertDialog(Alert.AlertType.INFORMATION, "Thanh toán thành công");
                getStage().close();
            }
        } else {
            showAlertDialog(Alert.AlertType.WARNING, "Vui lòng nhập đúng các trường thông tin");
        }
    }

    public boolean getPaymentResult() {
        return paymentResult;
    }

    public boolean validateInput(String cardCode, String owner, String dateExpired, String cvv) {
        if (cardCode.length() == 0 || owner.length() == 0 ||
                dateExpired.length() == 0 || cvv.length() != 3 ||
                cvv.startsWith("+") || cvv.startsWith("-")) {
            return false;
        }
        try {
            Integer.valueOf(cvv);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
