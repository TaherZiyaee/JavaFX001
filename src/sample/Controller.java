package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class Controller {

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
}
