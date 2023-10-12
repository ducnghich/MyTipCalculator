package duc.mytipcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class PrimaryController {

    private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
   
    
    @FXML
    private TextField AmountTextField;

    @FXML
    private Label TipLabel;

    @FXML
    private Slider TipSlider;

    @FXML
    private TextField TipTextField;

    @FXML
    private TextField Total;

    @FXML
    void CalculateTips(ActionEvent event) {
        try {
         BigDecimal amount = new BigDecimal(AmountTextField.getText());
         BigDecimal tip = amount.multiply(tipPercentage);
         BigDecimal total = amount.add(tip);

         TipTextField.setText(currency.format(tip));
         Total.setText(currency.format(total));
         }
        catch (NumberFormatException ex) {
         AmountTextField.setText("Enter amount");
         AmountTextField.selectAll();
         AmountTextField.requestFocus();
      }
   
    }
    
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        TipSlider.valueProperty().addListener(
        new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
               tipPercentage = 
                  BigDecimal.valueOf(newValue.intValue() / 100.0);
               TipLabel.setText(percent.format(tipPercentage));
            }
        }
        );
    }
}