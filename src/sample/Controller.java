package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox cbCar;
    private final String[] carsItems = {"Benz","BMW","Aston martin","KIA"};
    ObservableList<String> carsList = FXCollections.observableArrayList(carsItems);
    @FXML
    private ChoiceBox chbDrink;
    @FXML
    private RadioButton rbBarca;
    @FXML
    private RadioButton rbJuve;
    @FXML
    private RadioButton rbManutd;
    @FXML
    private TextField txtTeamName;
    @FXML
    private CheckBox chkApple;
    @FXML
    private CheckBox chkOrange;
    @FXML
    private CheckBox chkPear;
    @FXML
    private TextArea txtaComments;
    @FXML
    private TextField txtComment;
    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;
    @FXML
    private TextField txtSum;

    @FXML
    private void handleBtnSum(ActionEvent event) {
        double num1 = Double.parseDouble(txtNumber1.getText());
        double num2 = Double.parseDouble(txtNumber2.getText());
        double sum = num1 + num2;
        txtSum.setText(String.valueOf(sum));
    }

    @FXML
    private void handleBtnAddText(ActionEvent event) {
        txtaComments.appendText(txtComment.getText() + "\n");
        txtComment.setText("");
    }

    @FXML
    private void handleBtnAddFruit(ActionEvent event) {
        if (chkApple.isSelected() && isExistFruit(chkApple.getText()) == false)
            txtaComments.appendText(chkApple.getText() + "\n");
        if (chkOrange.isSelected() && isExistFruit(chkOrange.getText()) == false)
            txtaComments.appendText(chkOrange.getText() + "\n");
        if (chkPear.isSelected() && isExistFruit(chkPear.getText()) == false)
            txtaComments.appendText(chkPear.getText() + "\n");
        checkBoxesDeselect();
    }

    private void checkBoxesDeselect() {
        chkApple.setSelected(false);
        chkOrange.setSelected(false);
        chkPear.setSelected(false);
    }

    private boolean isExistFruit(String line) {
        String[] lines = txtaComments.getText().split("\n");
        System.out.println(Arrays.toString(lines));
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(line))
                return true;
        }
        return false;
    }

    @FXML
    private void handleBtnClearTA(ActionEvent event) {
        txtaComments.setText("");
        checkBoxesDeselect();
    }

    @FXML
    private void handleBtnAddTeam(ActionEvent event) {
        if (rbBarca.isSelected()) txtTeamName.setText(rbBarca.getText());
        if (rbManutd.isSelected()) txtTeamName.setText(rbManutd.getText());
        if (rbJuve.isSelected()) txtTeamName.setText(rbJuve.getText());
    }

    @FXML
    private void handleBtnAddDrink(ActionEvent event) {
        txtaComments.appendText((String) chbDrink.getSelectionModel().getSelectedItem() + "\n");
    }

    private void initChbDrink() {
        chbDrink.setValue("Wine");
        chbDrink.getItems().addAll("Wine","Soda","Bear");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initChbDrink();

        cbCar.setItems(carsList);
        cbCar.setValue(carsList.get(0));
    }

    @FXML
    private void handleBtnSelectCar(ActionEvent event) {
        if (!isExistFruit(String.valueOf(cbCar.getSelectionModel().getSelectedItem())))
            txtaComments.appendText(cbCar.getSelectionModel().getSelectedItem() + "\n");
    }
}
